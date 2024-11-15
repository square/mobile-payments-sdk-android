package com.example.mpsdkquickstart
import android.app.Application
import com.squareup.sdk.mobilepayments.MobilePaymentsSdk

class DemoApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    MobilePaymentsSdk.initialize(getString(R.string.mpsdk_application_id), this)
  }
}