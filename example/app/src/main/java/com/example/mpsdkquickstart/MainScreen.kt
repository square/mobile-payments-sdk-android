package com.example.mpsdkquickstart

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mpsdkquickstart.ui.theme.MPSDKQuickstartTheme
import com.squareup.sdk.mobilepayments.MobilePaymentsSdk
import com.squareup.sdk.mobilepayments.core.Result.Failure
import com.squareup.sdk.mobilepayments.core.Result.Success

private const val TAG_SETTINGS = "Settings Screen"

@Composable
fun MainScreen(
  isAuthorized: Boolean,
  modifier: Modifier = Modifier
) {

  var showPermissionsDialog by remember { mutableStateOf(false) }

  Box(
    modifier = modifier
      .padding(16.dp)
  ) {
    MainContent(
      isAuthorized = isAuthorized,
      onSettingsClicked = { showSettings() },
      onPermissionsClicked = { showPermissionsDialog = true }
    )

    if (showPermissionsDialog) {
      PermissionsScreen(
        isAuthorized = isAuthorized,
        onDismiss = { showPermissionsDialog = false }
      )
    }
  }
}

private fun showSettings() {
  val settingsManager = MobilePaymentsSdk.settingsManager()
  settingsManager.showSettings { result ->
    when (result) {
      is Success -> {
        Log.i(TAG_SETTINGS, "Success")
      }

      is Failure -> {
        Log.e(
          TAG_SETTINGS,
          "Error launching settings screen: ${result.errorCode}-${result.errorMessage}"
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
  MPSDKQuickstartTheme {
    MainScreen(isAuthorized = false)
  }
}