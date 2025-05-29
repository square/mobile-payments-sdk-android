package com.example.mpsdkquickstart

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mpsdkquickstart.ui.theme.MPSDKQuickstartTheme
import com.squareup.sdk.mobilepayments.MobilePaymentsSdk
import com.squareup.sdk.mobilepayments.core.Result.Failure
import com.squareup.sdk.mobilepayments.core.Result.Success
import com.squareup.sdk.mobilepayments.payment.CurrencyCode.USD
import com.squareup.sdk.mobilepayments.payment.Money
import com.squareup.sdk.mobilepayments.payment.Payment.OfflinePayment
import com.squareup.sdk.mobilepayments.payment.Payment.OnlinePayment
import com.squareup.sdk.mobilepayments.payment.PaymentErrorCode
import com.squareup.sdk.mobilepayments.payment.PaymentParameters
import com.squareup.sdk.mobilepayments.payment.ProcessingMode.AUTO_DETECT
import com.squareup.sdk.mobilepayments.payment.PromptMode
import com.squareup.sdk.mobilepayments.payment.PromptParameters
import java.util.UUID

private const val TAG = "Payment"

@Composable
fun MainContent(
  isAuthorized: Boolean,
  onSettingsClicked: () -> Unit,
  onPermissionsClicked: () -> Unit,
  modifier: Modifier = Modifier
) {
  var startPaymentErrorDetails: StartPaymentError? by remember { mutableStateOf(null) }

  Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      SettingsButton(onSettingsClicked)
      PermissionsButton(onPermissionsClicked)
    }

    DonutImage(
      modifier = Modifier
        .padding(vertical = 53.dp)
    )

    Text(
      text = stringResource(R.string.donut_counter),
      modifier = Modifier
        .padding(vertical = 16.dp),
      fontWeight = FontWeight.Bold,
      style = MaterialTheme.typography.titleLarge
    )

    BuyButton(
      isAuthorized = isAuthorized,
      onStartPaymentError = { startPaymentErrorDetails = it }
    )

    AuthorizationStatus(isAuthorized)

    if (startPaymentErrorDetails != null) {
      StartPaymentErrorDialog(
        startPaymentError = startPaymentErrorDetails,
        onDismiss = { startPaymentErrorDetails = null }
      )
    }
  }
}

@Composable
fun SettingsButton(onSettingsClicked: () -> Unit) {
  FilledTonalButton(
    onClick = onSettingsClicked,
    shape = RoundedCornerShape(6.dp),
    colors = ButtonDefaults.filledTonalButtonColors(
      containerColor = Color(0x0D00000D),
      contentColor = Color(0xFF005AD9)
    )
  ) {
    Text(stringResource(R.string.settings))
  }
}

@Composable
fun PermissionsButton(onPermissionsClicked: () -> Unit) {
  FilledTonalButton(
    onClick = onPermissionsClicked,
    shape = RoundedCornerShape(6.dp),
    colors = ButtonDefaults.filledTonalButtonColors(
      containerColor = Color(0x0D00000D),
      contentColor = Color(0xFF005AD9)
    )
  ) {
    Text(stringResource(R.string.permissions))
  }
}

@Composable
fun DonutImage(
  modifier: Modifier = Modifier
) {
  Image(
    painter = painterResource(id = R.drawable.donut),
    contentDescription = stringResource(id = R.string.main_image_description),
    modifier = modifier
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
      text = stringResource(R.string.buy_for_1),
      modifier = Modifier.padding(vertical = 8.dp),
      fontWeight = FontWeight.Bold,
      style = MaterialTheme.typography.bodyLarge
    )
  }
}

@Composable
fun AuthorizationStatus(isAuthorized: Boolean) {
  if (!isAuthorized) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Image(
        painter = painterResource(id = R.drawable.not_authorized_icon),
        contentDescription = stringResource(R.string.not_authorized_warning_icon)
      )
      Text(
        text = stringResource(R.string.device_not_authorized_open_permissions_to_authorize),
        modifier = Modifier.padding(horizontal = 4.dp),
        style = MaterialTheme.typography.bodySmall,
        color = Color(0xFF945C25)
      )
    }
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

fun startPaymentActivity(
  onStartPaymentError: (StartPaymentError) -> Unit
) {
  val paymentManager = MobilePaymentsSdk.paymentManager()
  // Configure the payment parameters
  val paymentParams = PaymentParameters.Builder(
    amount = Money(100, USD), // $1
    processingMode = AUTO_DETECT
  )
    .paymentAttemptId(UUID.randomUUID().toString())
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
      is Success -> {
        when (val payment = result.value) {
          is OnlinePayment -> {
            Log.i(TAG, "Successful online payment ${payment.id}")
          }
          is OfflinePayment -> {
            Log.i(TAG, "Successful offline payment ${payment.localId}")
          }
        }
      }
      is Failure -> {
        Log.e(TAG, "Start payment failed: ${result.errorCode}-${result.errorMessage}")
        onStartPaymentError(StartPaymentError(result.errorCode, result.errorMessage))
      }
    }
  }
}

data class StartPaymentError(
  val errorCode: PaymentErrorCode,
  val errorMessage: String
)

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
  MPSDKQuickstartTheme {
    MainContent(
      isAuthorized = false,
      onSettingsClicked = {},
      onPermissionsClicked = {}
    )
  }
}
