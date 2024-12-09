package com.example.mpsdkquickstart

import android.Manifest.permission
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString
import com.squareup.sdk.mobilepayments.MobilePaymentsSdk
import com.squareup.sdk.mobilepayments.authorization.AuthorizeErrorCode
import com.squareup.sdk.mobilepayments.core.Result.Failure
import com.squareup.sdk.mobilepayments.core.Result.Success
import com.squareup.sdk.mobilepayments.mockreader.ui.MockReaderUI

private const val TAG = "Authorization"

@Composable
fun PermissionsScreen(
  isAuthorized: Boolean,
  onDismiss: () -> Unit
) {
  var authorizationErrorDetails: AuthorizationError? by remember { mutableStateOf(null) }

  PermissionsContent(
    isAuthorized = isAuthorized,
    onDismiss = onDismiss,
    onAuthorizationError = { authorizationErrorDetails = it }
  )

  if (authorizationErrorDetails != null) {
    AuthorizationErrorDialog(
      authorizationError = authorizationErrorDetails,
      onDismiss = { authorizationErrorDetails = null }
    )
  }
}

@Composable
fun AuthorizationErrorDialog(
  authorizationError: AuthorizationError?,
  onDismiss: () -> Unit
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    confirmButton = {
      Button(onClick = onDismiss) { Text(stringResource(R.string.ok)) }
    },
    title = { Text(text = authorizationError?.authorizeErrorCode?.name.orEmpty()) },
    text = { Text(text = authorizationError?.authorizationMessage.orEmpty()) }
  )
}

@Composable
fun PermissionsContent(
  isAuthorized: Boolean,
  onDismiss: () -> Unit,
  onAuthorizationError: (AuthorizationError) -> Unit
) {
  Dialog(
    properties = DialogProperties(usePlatformDefaultWidth = false),
    onDismissRequest = onDismiss,
  ) {
    // Background
    Surface(
      modifier = Modifier.fillMaxSize(),
      color = Color.White
    ) {
      // Main body column
      Column(
        modifier = Modifier
          .verticalScroll(rememberScrollState())
          .padding(16.dp)
      ) {
        // Top Row
        Row(
          Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          // Close Permissions Dialog button
          Box(
            modifier = Modifier
              .size(48.dp)
              .clip(RoundedCornerShape(0.dp))
              .clickable { onDismiss() }
          ) {
            Image(
              painter = painterResource(id = R.drawable.close_permissions_button),
              contentDescription = stringResource(R.string.close_button_for_permissions_dialog)
            )
          }

          // Dialog title
          Text(
            text = "Permissions",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.width(48.dp))

        }

        // Permissions body
        BluetoothPermission()
        HorizontalDivider()

        LocationPermission()
        HorizontalDivider()

        MicrophonePermission()
        HorizontalDivider()

        PhoneStatePermission()

        AuthorizeButton(
          isAuthorized = isAuthorized,
          onAuthorizationFailure = { onAuthorizationError(it) }
        )

        AuthorizationStatusSignInButton(isAuthorized)
      }
    }
  }
}

@Composable
private fun PhoneStatePermission() {
  PermissionsRow(
    title = stringResource(R.string.read_phone_state_permission_title),
    description = stringResource(R.string.read_phone_state_permission_description),
    permissionsToRequest = arrayOf(
      permission.READ_PHONE_STATE,
    )
  )
}

@Composable
private fun MicrophonePermission() {
  PermissionsRow(
    title = stringResource(R.string.microphone_permission_title),
    description = stringResource(R.string.microphone_permission_description),
    permissionsToRequest = arrayOf(
      permission.RECORD_AUDIO,
    )
  )
}

@Composable
private fun LocationPermission() {
  PermissionsRow(
    title = stringResource(R.string.location_permission_title),
    description = stringResource(R.string.location_permission_description),
    permissionsToRequest = arrayOf(
      permission.ACCESS_COARSE_LOCATION,
      permission.ACCESS_FINE_LOCATION,
    )
  )
}

@Composable
private fun BluetoothPermission() {
  PermissionsRow(
    title = stringResource(R.string.bluetooth_permission_title),
    description = stringResource(R.string.bluetooth_permission_description),
    permissionsToRequest = arrayOf(
      permission.BLUETOOTH_CONNECT,
      permission.BLUETOOTH_SCAN,
    )
  )
}

@Composable
fun PermissionsRow(
  title: String,
  description: String,
  permissionsToRequest: Array<String>
) {
  Row(
    modifier = Modifier.padding(vertical = 16.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    // Text
    Column(
      modifier = Modifier.weight(weight = 1.0f, fill = false)
    ) {
      Text(
        text = title,
        fontWeight = FontWeight.Bold
      )
      Text(
        text = description,
        color = Color(0x8C000000)
      )
    }
    // Checkbox
    PermissionsCheckbox(permissionsToRequest)
  }
}

@Composable
fun PermissionsCheckbox(permissionsToRequest: Array<String>) {
  var checked by remember { mutableStateOf(true) }

  val requestMultiplePermissionsLauncher = rememberLauncherForActivityResult(
    RequestMultiplePermissions()
  ) { requestedPermissions: Map<String, Boolean> ->
    if (requestedPermissions.all { it.value }) {
      checked = true
    }
  }

  permissionsToRequest.forEach { permission ->
    if (ContextCompat.checkSelfPermission(LocalContext.current, permission)
      != PackageManager.PERMISSION_GRANTED
    ) {
      checked = false
    }
  }
  Checkbox(
    checked = checked,
    onCheckedChange = {
      requestMultiplePermissionsLauncher.launch(
        permissionsToRequest
      )
    }
  )
}

@Composable
fun AuthorizeButton(
  isAuthorized: Boolean,
  onAuthorizationFailure: (AuthorizationError) -> Unit
) {
  val context = LocalContext.current
  if (isAuthorized) {
    // Sign out button
    Button(
      modifier = Modifier.fillMaxWidth(),
      onClick = { deauthorizeSdk() },
      shape = RoundedCornerShape(6.dp),
      colors = ButtonDefaults.filledTonalButtonColors(
        containerColor = Color(0x0D000000),
        contentColor = Color(0xFF006AFF)
      )
    ) {
      Text(stringResource(R.string.sign_out))
    }
  } else {
    // Sign in button
    Button(
      modifier = Modifier.fillMaxWidth(),
      onClick = {
        authorizeSdk(
          context = context,
          onAuthorizationFailure = onAuthorizationFailure
        )
      },
      shape = RoundedCornerShape(6.dp),
      colors = ButtonDefaults.filledTonalButtonColors(
        containerColor = Color(0xFF006AFF),
        contentColor = Color(0xFFFFFFFF)
      )
    ) {
      Text(stringResource(R.string.sign_in))
    }
  }
}

@Composable
fun AuthorizationStatusSignInButton(isAuthorized: Boolean) {
  if (!isAuthorized) {
    Row {
      Image(
        painter = painterResource(id = R.drawable.not_authorized_icon),
        contentDescription = stringResource(R.string.not_authorized_warning_icon)
      )
      Text(
        text = stringResource(R.string.device_not_authorized),
        style = MaterialTheme.typography.labelLarge,
        color = Color(0xFF945C25),
        modifier = Modifier.padding(horizontal = 4.dp)
      )
    }
  } else {
    Row {
      Image(
        painter = painterResource(id = R.drawable.authorized_icon),
        contentDescription = stringResource(R.string.authorized_checkmark_icon)
      )
      Text(
        text = stringResource(R.string.this_device_is_authorized),
        style = MaterialTheme.typography.labelLarge,
        color = Color(0xFF007D2A),
        modifier = Modifier.padding(horizontal = 4.dp)
      )
    }
  }
}

fun authorizeSdk(
  context: Context,
  onAuthorizationFailure: (AuthorizationError) -> Unit
) {
  val authorizationManager = MobilePaymentsSdk.authorizationManager()
  // Authorize and handle authorization successes or failures
  authorizationManager.authorize(
    getString(context, R.string.mpsdk_access_token),
    getString(context, R.string.mpsdk_location_id),
  ) { result ->
    when (result) {
      is Success -> {
        if (MobilePaymentsSdk.isSandboxEnvironment()) {
          MockReaderUI.show()
        }
        Log.i(TAG, "Authorization Success")
      }

      is Failure -> {
        Log.e(TAG, "Authorization Failure: ${result.errorCode}-${result.errorMessage}")
        onAuthorizationFailure(AuthorizationError(result.errorCode, result.errorMessage))
      }
    }
  }
}

fun deauthorizeSdk() {
  MobilePaymentsSdk.authorizationManager().deauthorize()
  MockReaderUI.hide()
}

/**
 * Represents an error coming from the SDK authorization call
 */
data class AuthorizationError(
  val authorizeErrorCode: AuthorizeErrorCode,
  val authorizationMessage: String
)