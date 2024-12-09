package com.example.mpsdkquickstart

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getString
import com.example.mpsdkquickstart.ui.theme.MPSDKQuickstartTheme
import com.squareup.sdk.mobilepayments.MobilePaymentsSdk
import com.squareup.sdk.mobilepayments.authorization.AuthorizeErrorCode
import com.squareup.sdk.mobilepayments.core.Result.Failure
import com.squareup.sdk.mobilepayments.core.Result.Success
import com.squareup.sdk.mobilepayments.mockreader.ui.MockReaderUI
import com.squareup.sdk.mobilepayments.payment.CurrencyCode.USD
import com.squareup.sdk.mobilepayments.payment.Money
import com.squareup.sdk.mobilepayments.payment.PaymentErrorCode
import com.squareup.sdk.mobilepayments.payment.PaymentParameters
import com.squareup.sdk.mobilepayments.payment.PromptMode
import com.squareup.sdk.mobilepayments.payment.PromptParameters
import java.util.UUID

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MPSDKQuickstartTheme {
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

        MainScreen(isAuthorized = isAuthorized)
      }
    }
  }
}

@Composable
fun MainScreen(isAuthorized: Boolean) {
  var startPaymentErrorDetails: StartPaymentError? by remember { mutableStateOf(null) }

  Column(
    modifier = Modifier
      .safeDrawingPadding()
      .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      SettingsButton()
      PermissionsDialog(isAuthorized)
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 53.dp),
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      DonutImage()
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp),
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      Text(
        text = "Donut Counter",
        fontSize = 25.sp,
        fontWeight = FontWeight(700)
      )
    }
    BuyButton(
      isAuthorized = isAuthorized,
      onStartPaymentError = { startPaymentErrorDetails = it }
    )
    AuthorizationStatusBuyButton(isAuthorized)
  }

  if (startPaymentErrorDetails != null) {
    StartPaymentErrorDialog(
      startPaymentError = startPaymentErrorDetails,
      onDismiss = { startPaymentErrorDetails = null }
    )
  }
}

@Composable
fun SettingsButton() {
  FilledTonalButton(
    onClick = { showSettings() },
    shape = RoundedCornerShape(6.dp),
    colors = ButtonDefaults.filledTonalButtonColors(
      containerColor = Color(0x0D00000D),
      contentColor = Color(0xFF005AD9)
    )
  ) {
    Text("Settings")
  }
}

fun showSettings() {
  val settingsManager = MobilePaymentsSdk.settingsManager()
  settingsManager.showSettings { result ->
    when (result) {
      is Success -> {
        Log.i("Settings Screen", "Success")
      }

      is Failure -> {
        Log.i("Settings Screen", "Error")

        //TODO: logSettingsFailure(result.errorCode, result.errorMessage)
      }
    }
  }
}

@Composable
fun DonutImage() {
  Image(
    painter = painterResource(id = R.drawable.donut),
    contentDescription = stringResource(id = R.string.main_image_description)
  )
}

@Composable
fun BuyButton(
  isAuthorized: Boolean,
  onStartPaymentError: (StartPaymentError) -> Unit
) {
  Button(
    modifier = Modifier.fillMaxWidth(),
    onClick = { startPaymentActivity(onStartPaymentError) },
    enabled = isAuthorized,
    shape = RoundedCornerShape(6.dp),
    colors = ButtonDefaults.filledTonalButtonColors(
      containerColor = Color(0xFFE5ACD4),
      contentColor = Color(0xE6000000)
    )
  ) {
    Text(
      text = "Buy for $1",
      fontSize = 18.sp,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(vertical = 8.dp)
    )
  }
}

fun startPaymentActivity(
  onStartPaymentError: (StartPaymentError) -> Unit
) {
  val paymentManager = MobilePaymentsSdk.paymentManager()
  // Configure the payment parameters
  val paymentParams = PaymentParameters.Builder(
    amount = Money(100, USD), // $1
    idempotencyKey = UUID.randomUUID().toString()
  )
    .referenceId("1234")
    .note("Donut")
    .autocomplete(true)
    .build()
  // Configure the prompt parameters
  val promptParams = PromptParameters(
    mode = PromptMode.DEFAULT,
  )
  // Start the payment activity
  paymentManager.startPaymentActivity(paymentParams, promptParams) { result ->
    // Callback to handle the payment result
    when (result) {
      is Success -> Log.i("Payment", "Success")
      is Failure -> {
        Log.e("Payment", "Start payment failed: ${result.errorCode}-${result.errorMessage}")
        onStartPaymentError(StartPaymentError(result.errorCode, result.errorMessage))
      }
    }
  }
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
      Row {
        Text(
          text = title,
          fontWeight = FontWeight.Bold
        )
      }
      Row {
        Text(
          text = description,
          color = Color(0x8C000000)
        )
      }
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
      Text("Sign out")
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
      Text("Sign in")
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
        Log.i("Authorization", "Success")
      }

      is Failure -> {
        onAuthorizationFailure(AuthorizationError(result.errorCode, result.errorMessage))
      }
    }
  }
}

fun deauthorizeSdk() {
  MobilePaymentsSdk.authorizationManager().deauthorize()
  MockReaderUI.hide()
}

@Composable
fun AuthorizationStatusBuyButton(isAuthorized: Boolean) {
  if (!isAuthorized) {
    Row {
      Image(
        painter = painterResource(id = R.drawable.not_authorized_icon),
        contentDescription = "Not authorized warning icon"
      )
      Text(
        text = "Device not authorized. Open permissions to authorize.",
        fontSize = 13.sp,
        color = Color(0xFF945C25),
        modifier = Modifier.padding(horizontal = 4.dp)
      )
    }
  }
}

@Composable
fun AuthorizationStatusSignInButton(isAuthorized: Boolean) {
  if (!isAuthorized) {
    Row {
      Image(
        painter = painterResource(id = R.drawable.not_authorized_icon),
        contentDescription = "Not authorized warning icon"
      )
      Text(
        text = "Device not authorized",
        fontSize = 13.sp,
        color = Color(0xFF945C25),
        modifier = Modifier.padding(horizontal = 4.dp)
      )
    }
  } else {
    Row {
      Image(
        painter = painterResource(id = R.drawable.authorized_icon),
        contentDescription = "Authorized checkmark icon"
      )
      Text(
        text = "This device is authorized",
        fontSize = 13.sp,
        color = Color(0xFF007D2A),
        modifier = Modifier.padding(horizontal = 4.dp)
      )
    }
  }
}

@Composable
fun PermissionsDialog(
  isAuthorized: Boolean
) {
  var showPermissionsDialog by remember { mutableStateOf(false) }
  var authorizationErrorDetails: AuthorizationError? by remember { mutableStateOf(null) }

  Column {
    FilledTonalButton(
      onClick = { showPermissionsDialog = true },
      shape = RoundedCornerShape(6.dp),
      colors = ButtonDefaults.filledTonalButtonColors(
        containerColor = Color(0x0D00000D),
        contentColor = Color(0xFF005AD9)
      )
    ) {
      Text(
        text = "Permissions",
      )
    }
  }

  if (showPermissionsDialog) {
    Dialog(
      properties = DialogProperties(usePlatformDefaultWidth = false),
      onDismissRequest = { showPermissionsDialog = false },
    ) {
      // Background
      Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
      ) {
        // Main body column
        Column(
          modifier = Modifier.padding(16.dp)
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
                .clickable { showPermissionsDialog = false }
            ) {
              Image(
                painter = painterResource(id = R.drawable.close_permissions_button),
                contentDescription = "Close button for Permissions dialog"
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
          // Bluetooth permissions
          PermissionsRow(
            title = "Bluetooth",
            description = "Square uses Bluetooth to connect and communicate with Square devices.\n" +
              "You should ask for this permission if you are using readers that connect via Bluetooth",
            permissionsToRequest = arrayOf(
              android.Manifest.permission.BLUETOOTH_CONNECT,
              android.Manifest.permission.BLUETOOTH_SCAN,
            )
          )
          HorizontalDivider(thickness = 1.dp)
          PermissionsRow(
            title = "Location",
            description = "Square uses location to know where transactions take place. " +
              "This reduces risk and minimizes payment disputes. ",
            permissionsToRequest = arrayOf(
              android.Manifest.permission.ACCESS_COARSE_LOCATION,
              android.Manifest.permission.ACCESS_FINE_LOCATION,
            )
          )
          HorizontalDivider(thickness = 1.dp)
          PermissionsRow(
            title = "Microphone",
            description = "Square Reader for magstripe uses the microphone to communicate " +
              "payment card data to your device.\n" +
              "You should ask for this permission if you are using a magstripe reader.",
            permissionsToRequest = arrayOf(
              android.Manifest.permission.RECORD_AUDIO,
            )
          )
          HorizontalDivider(thickness = 1.dp)
          PermissionsRow(
            title = "Read Phone State",
            description = "Square needs phone access in order to uniquely identify the devices " +
              "associated with your account and ensure that unauthorized devices are not able to " +
              "act on your behalf.",
            permissionsToRequest = arrayOf(
              android.Manifest.permission.READ_PHONE_STATE,
            )
          )
          AuthorizeButton(
            isAuthorized = isAuthorized,
            onAuthorizationFailure = { authorizationError -> authorizationErrorDetails = authorizationError }
          )
          AuthorizationStatusSignInButton(isAuthorized)
        }
      }
    }
  }

  if (authorizationErrorDetails != null) {
    AlertDialog(
      onDismissRequest = { authorizationErrorDetails = null },
      confirmButton = {
        Button(onClick = { authorizationErrorDetails = null }) { Text(stringResource(R.string.ok)) }
      },
      title = { Text(text = authorizationErrorDetails?.authorizeErrorCode?.name.orEmpty()) },
      text = { Text(text = authorizationErrorDetails?.authorizationMessage.orEmpty()) }
    )
  }
}

@Composable
fun StartPaymentErrorDialog(
  startPaymentError: StartPaymentError?,
  onDismiss: () -> Unit
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    confirmButton = {
      Button(onClick = onDismiss) { Text(stringResource(R.string.ok)) }
    },
    title = { Text(text = startPaymentError?.errorCode?.name.orEmpty()) },
    text = { Text(text = startPaymentError?.errorMessage.orEmpty()) }
  )
}

/**
 * Represents an error coming from the SDK authorization call
 */
data class AuthorizationError(
  val authorizeErrorCode: AuthorizeErrorCode,
  val authorizationMessage: String
)

/**
 * Represents and error coming from the SDK start payment activity call
 */
data class StartPaymentError(
  val errorCode: PaymentErrorCode,
  val errorMessage: String
)

@Preview(showBackground = true)
@Composable
fun DemoPreview() {
  MPSDKQuickstartTheme {
    MainScreen(isAuthorized = true)
  }
}

