package com.example.mpsdkquickstart

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mpsdkquickstart.ui.theme.MPSDKQuickstartTheme
import com.squareup.sdk.mobilepayments.MobilePaymentsSdk
import com.squareup.sdk.mobilepayments.mockreader.ui.MockReaderUI

@Composable
fun DonutCounterApp() {
  MPSDKQuickstartTheme {
    Scaffold { paddingValues ->
      var isAuthorized by remember { mutableStateOf(MobilePaymentsSdk.authorizationManager().authorizationState.isAuthorized) }

      DisposableEffect(Unit) {
        // Add callback and update isAuthorized from the callback
        val callback = MobilePaymentsSdk.authorizationManager().setAuthorizationStateChangedCallback { result ->
          isAuthorized = result.isAuthorized
        }
        // Make sure to clear the callback when the composable is disposed
        onDispose {
          callback.clear()
        }
      }

      LaunchedEffect(isAuthorized) {
        if (isAuthorized && MobilePaymentsSdk.isSandboxEnvironment()) {
          MockReaderUI.show()
        }
      }

      MainScreen(
        isAuthorized = isAuthorized,
        modifier = Modifier
          .padding(paddingValues)
      )
    }
  }
}