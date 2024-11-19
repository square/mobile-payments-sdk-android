package com.example.mpsdkquickstart
import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.squareup.sdk.mobilepayments.MobilePaymentsSdk

class DemoApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    MobilePaymentsSdk.initialize(getString(R.string.mpsdk_application_id), this)
  }
}