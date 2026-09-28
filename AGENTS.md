# AGENTS.md — Square Mobile Payments SDK for Android

Guidance for coding agents **integrating the Mobile Payments SDK into an Android app**.
This repo is the Donut Counter quickstart sample; `example/` is a working reference, not the SDK source.

Current SDK version: **2.6.1**.

## Dependencies

Square's Maven repo is not on Maven Central. Add it in `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
    maven("https://sdk.squareup.com/public/android/")
  }
}
```

Then in the app module's `build.gradle.kts`:

```kotlin
val squareSdkVersion = "2.6.1"
implementation("com.squareup.sdk:mobile-payments-sdk:$squareSdkVersion")
// Sandbox-only. Do not ship in release builds.
implementation("com.squareup.sdk:mockreader-ui:$squareSdkVersion")
```

Reference: [example/settings.gradle.kts](example/settings.gradle.kts), [example/app/build.gradle.kts](example/app/build.gradle.kts).

## Build constraints

These silently break integrations. Check them before writing any code.

| Constraint | Value |
| :--- | :--- |
| `minSdk` | 28 (Android 9) |
| `compileSdk` / `targetSdk` | 36 |
| Android Gradle Plugin | 8.9.1 or later |
| Gradle | 8.13 or later |
| AndroidX | required (or `android.enableJetifier=true`) |

**Proguard / R8 is not supported.** The SDK does not ship consumer rules covering everything it needs, and shrinking strips bytecode it loads reflectively at runtime. Set both flags off in every build type that ships the SDK:

```kotlin
buildTypes {
  release {
    isMinifyEnabled = false
    isShrinkResources = false
  }
}
```

This is the single most expensive thing to get wrong: the debug build works, the release build compiles, and the failure only appears at runtime. Do not "fix" it by adding keep rules.

The AGP/Gradle floor comes from `androidx.core:core:1.18.0`, which SDK 2.6.x depends on. Older values fail during dependency resolution, not at runtime.

Taking **production** payments with SDK 2.1+ also requires submitting an application signature to Square beforehand. Sandbox does not.

## Credentials

Three values, from the [Developer Console](https://developer.squareup.com/apps) (toggle **Sandbox** at the top of the Credentials page):

| Value | Used by |
| :--- | :--- |
| Application ID | `MobilePaymentsSdk.initialize(applicationId, context)` |
| Access token | `authorizationManager.authorize(accessToken, locationId)` |
| Location ID | same call — from the **Locations** page |

A Sandbox application ID puts the SDK in sandbox mode; `MobilePaymentsSdk.isSandboxEnvironment()` reports it. To move to production you re-initialize with the production application ID.

In this sample the values live in [example/app/src/main/res/values/environments.xml](example/app/src/main/res/values/environments.xml) as the placeholders `SANDBOX APPLICATION ID`, `SANDBOX ACCESS TOKEN`, `SANDBOX LOCATION ID`. **Leave those placeholders in place** — never commit real credential values to this repo or to the user's. Tell the user to fill them in locally.

A personal access token is acceptable for Sandbox only. Production authorization must use OAuth; a shipped app must not contain a personal access token.

## Device permissions

Declared in the manifest, and all requested at runtime:

| Permission | Purpose |
| :--- | :--- |
| `ACCESS_FINE_LOCATION` / `ACCESS_COARSE_LOCATION` | Confirm payments occur in a supported Square location |
| `BLUETOOTH_CONNECT` | Communicate with contactless and chip readers |
| `BLUETOOTH_SCAN` | Discover nearby readers |
| `RECORD_AUDIO` | Receive data from magstripe readers |
| `READ_PHONE_STATE` | Identify the device to Square servers |

See [example/app/src/main/AndroidManifest.xml](example/app/src/main/AndroidManifest.xml) and [PermissionsScreen.kt](example/app/src/main/java/com/example/mpsdkquickstart/PermissionsScreen.kt).

## Ordering rule

The order is not optional:

1. **Initialize** — `MobilePaymentsSdk.initialize(applicationId, this)` in `Application.onCreate()`.
2. **Request permissions** — at runtime, before authorizing.
3. **Authorize** — `MobilePaymentsSdk.authorizationManager().authorize(accessToken, locationId) { … }`.
4. Only then use `paymentManager()`, `readerManager()`, or `settingsManager()`.

Any manager call made before authorization completes fails with **`NOT_AUTHORIZED`**. If you see that error code, the fix is ordering, not parameters.

```kotlin
// 1. Application.onCreate()
MobilePaymentsSdk.initialize(getString(R.string.mpsdk_application_id), this)

// 3. after permissions are granted
MobilePaymentsSdk.authorizationManager().authorize(accessToken, locationId) { result ->
  when (result) {
    is Success -> if (MobilePaymentsSdk.isSandboxEnvironment()) MockReaderUI.show()
    is Failure -> Log.e(TAG, "${result.errorCode}-${result.errorMessage}")
  }
}
```

## Taking a payment

```kotlin
val params = PaymentParameters.Builder(
  amount = Money(100, CurrencyCode.USD),
  processingMode = ProcessingMode.AUTO_DETECT,
  allowCardSurcharge = false,
  paymentAttemptId = UUID.randomUUID().toString(),
).autocomplete(true).build()

MobilePaymentsSdk.paymentManager()
  .startPaymentActivity(params, PromptParameters(mode = PromptMode.DEFAULT)) { result -> … }
```

`paymentAttemptId` must be derived from an order/sale identifier in a real integration, not a fresh UUID per tap — that is what protects against duplicate payments on retry. Success returns `Payment.OnlinePayment` or `Payment.OfflinePayment`; handle both.

See [MainContent.kt](example/app/src/main/java/com/example/mpsdkquickstart/MainContent.kt).

## Testing with mock readers in Sandbox

Physical Square readers do **not** work in Sandbox. Virtual readers come from the `mockreader-ui` artifact.

```kotlin
MockReaderUI.show()   // after a successful sandbox authorize()
MockReaderUI.hide()   // on deauthorize
```

**Known limitation — read this before planning an automated test.** The published artifact exposes only `MockReaderUI.show()` and `MockReaderUI.hide()`. There is no public API to add a mock reader, select a card brand, or simulate a tap/insert/swipe. Those steps happen only through the floating button the SDK attaches to the current Activity, and require a human:

> tap the floater → **Add Contactless & Chip Reader** → start the payment → tap the floater → **Tap Card**

So an agent **cannot** drive an end-to-end sandbox payment on its own. If a task requires one, say so and ask the user to perform the taps — do not sit waiting on a payment callback that will never fire.

Also: after testing an inserted card, remove it through the mock reader UI before starting the next payment.

## Documentation

Fetch the `.md` variants. The HTML pages are iframe shells and return only navigation chrome to a programmatic fetch.

- Overview — https://developer.squareup.com/docs/mobile-payments-sdk.md
- Build on Android — https://developer.squareup.com/docs/mobile-payments-sdk/android.md
- Authorize — https://developer.squareup.com/docs/mobile-payments-sdk/android/configure-authorize.md
- Pair and manage readers — https://developer.squareup.com/docs/mobile-payments-sdk/android/pair-manage-readers.md
- Take payments — https://developer.squareup.com/docs/mobile-payments-sdk/android/take-payments.md
- Handling errors — https://developer.squareup.com/docs/mobile-payments-sdk/android/handling-errors.md
- Offline payments — https://developer.squareup.com/docs/mobile-payments-sdk/android/offline-payments.md
- API reference — https://developer.squareup.com/docs/sdk/mobile-payments/android

Note that the docs page currently lists `compileSdkVersion` 35; 2.6.x requires 36, as this sample uses.

## Repo layout

```
example/                        Donut Counter sample app (Compose)
  app/build.gradle.kts          dependency coordinates, SDK levels, minify settings
  settings.gradle.kts           Square Maven repo
  app/src/main/res/values/environments.xml   credential placeholders
  app/src/main/java/com/example/mpsdkquickstart/
    DemoApplication.kt          initialize()
    PermissionsScreen.kt        runtime permissions + authorize() + MockReaderUI
    MainContent.kt              startPaymentActivity()
    MainScreen.kt               settingsManager.showSettings()
```

Running the sample: open `example/` in Android Studio, fill in `environments.xml`, run on a device or emulator.
