<!--
  This file is generated from the Mobile Payments SDK public API KDoc. Do not edit by hand.
  It is a flat, machine-readable rendering of the same reference published at
  https://developer.squareup.com/docs/mobile-payments-sdk/android
-->

# Mobile Payments SDK for Android — API reference

## Overview

The main entry point to the Mobile Payments SDK is the MobilePaymentsSdk class. Refer to the [quickstart guide](https://developer.squareup.com/docs/mobile-payments-sdk/android) to initialize Mobile Payments SDK.

MobilePaymentsSdk provides access to three SDK components:

- AuthorizationManager is used to authorize/deauthorize Mobile Payments SDK on behalf of Square location.
- ReaderManager tracks connected Square Readers and allows pairing/unpairing card readers.
- PaymentManager is used to process payments.
- SettingsManager is used to manage Mobile Payments SDK settings.

## Contents

- [com.squareup.sdk.mobilepayments](#comsquareupsdkmobilepayments)
  - [MobilePaymentsSdk](#comsquareupsdkmobilepaymentsmobilepaymentssdk)
- [com.squareup.sdk.mobilepayments.authorization](#comsquareupsdkmobilepaymentsauthorization)
  - [AuthorizationManager](#comsquareupsdkmobilepaymentsauthorizationauthorizationmanager)
  - [AuthorizationState](#comsquareupsdkmobilepaymentsauthorizationauthorizationstate)
    - [Companion](#comsquareupsdkmobilepaymentsauthorizationauthorizationstatecompanion)
  - [AuthorizeErrorCode](#comsquareupsdkmobilepaymentsauthorizationauthorizeerrorcode)
  - [AuthorizedLocation](#comsquareupsdkmobilepaymentsauthorizationauthorizedlocation)
- [com.squareup.sdk.mobilepayments.cardreader](#comsquareupsdkmobilepaymentscardreader)
  - [CardEntryMethod](#comsquareupsdkmobilepaymentscardreadercardentrymethod)
  - [PairingErrorCode](#comsquareupsdkmobilepaymentscardreaderpairingerrorcode)
  - [PairingHandle](#comsquareupsdkmobilepaymentscardreaderpairinghandle)
    - [StopResult](#comsquareupsdkmobilepaymentscardreaderpairinghandlestopresult)
  - [ReaderChangedEvent](#comsquareupsdkmobilepaymentscardreaderreaderchangedevent)
    - [Change](#comsquareupsdkmobilepaymentscardreaderreaderchangedeventchange)
  - [ReaderInfo](#comsquareupsdkmobilepaymentscardreaderreaderinfo)
    - [BatteryStatus](#comsquareupsdkmobilepaymentscardreaderreaderinfobatterystatus)
    - [ConnectionType](#comsquareupsdkmobilepaymentscardreaderreaderinfoconnectiontype)
    - [FirmwareUpdateStatus](#comsquareupsdkmobilepaymentscardreaderreaderinfofirmwareupdatestatus)
      - [InProgress](#comsquareupsdkmobilepaymentscardreaderreaderinfofirmwareupdatestatusinprogress)
      - [None](#comsquareupsdkmobilepaymentscardreaderreaderinfofirmwareupdatestatusnone)
      - [Pending](#comsquareupsdkmobilepaymentscardreaderreaderinfofirmwareupdatestatuspending)
    - [Model](#comsquareupsdkmobilepaymentscardreaderreaderinfomodel)
    - [ReaderFirmwareInfo](#comsquareupsdkmobilepaymentscardreaderreaderinforeaderfirmwareinfo)
    - [ReaderWarning](#comsquareupsdkmobilepaymentscardreaderreaderinforeaderwarning)
    - [Status](#comsquareupsdkmobilepaymentscardreaderreaderinfostatus)
      - [ConnectingToDevice](#comsquareupsdkmobilepaymentscardreaderreaderinfostatusconnectingtodevice)
      - [ConnectingToSquare](#comsquareupsdkmobilepaymentscardreaderreaderinfostatusconnectingtosquare)
      - [Faulty](#comsquareupsdkmobilepaymentscardreaderreaderinfostatusfaulty)
      - [ReaderUnavailable](#comsquareupsdkmobilepaymentscardreaderreaderinfostatusreaderunavailable)
        - [ReaderUnavailableReason](#comsquareupsdkmobilepaymentscardreaderreaderinfostatusreaderunavailablereaderunavailablereason)
      - [Ready](#comsquareupsdkmobilepaymentscardreaderreaderinfostatusready)
  - [ReaderManager](#comsquareupsdkmobilepaymentscardreaderreadermanager)
    - [Companion](#comsquareupsdkmobilepaymentscardreaderreadermanagercompanion)
  - [ReaderSettings](#comsquareupsdkmobilepaymentscardreaderreadersettings)
  - [RetryConnectionResult](#comsquareupsdkmobilepaymentscardreaderretryconnectionresult)
  - [TapToPaySettings](#comsquareupsdkmobilepaymentscardreadertaptopaysettings)
- [com.squareup.sdk.mobilepayments.core](#comsquareupsdkmobilepaymentscore)
  - [Callback](#comsquareupsdkmobilepaymentscorecallback)
  - [CallbackReference](#comsquareupsdkmobilepaymentscorecallbackreference)
  - [ErrorCode](#comsquareupsdkmobilepaymentscoreerrorcode)
  - [ErrorDetails](#comsquareupsdkmobilepaymentscoreerrordetails)
  - [Result](#comsquareupsdkmobilepaymentscoreresult)
    - [Failure](#comsquareupsdkmobilepaymentscoreresultfailure)
    - [Success](#comsquareupsdkmobilepaymentscoreresultsuccess)
  - [TimeOfDay](#comsquareupsdkmobilepaymentscoretimeofday)
- [com.squareup.sdk.mobilepayments.extensions](#comsquareupsdkmobilepaymentsextensions)
  - [AuthorizeResult](#comsquareupsdkmobilepaymentsextensionsauthorizeresult)
  - [GetAllIdempotencyKeysResult](#comsquareupsdkmobilepaymentsextensionsgetallidempotencykeysresult)
  - [GetIdempotencyKeyResult](#comsquareupsdkmobilepaymentsextensionsgetidempotencykeyresult)
  - [GetOfflinePaymentsResult](#comsquareupsdkmobilepaymentsextensionsgetofflinepaymentsresult)
  - [GetTotalStoredPaymentAmountResult](#comsquareupsdkmobilepaymentsextensionsgettotalstoredpaymentamountresult)
  - [PairingResult](#comsquareupsdkmobilepaymentsextensionspairingresult)
  - [PaymentResult](#comsquareupsdkmobilepaymentsextensionspaymentresult)
  - [SettingsResult](#comsquareupsdkmobilepaymentsextensionssettingsresult)
- [com.squareup.sdk.mobilepayments.payment](#comsquareupsdkmobilepaymentspayment)
  - [AdditionalPaymentMethod](#comsquareupsdkmobilepaymentspaymentadditionalpaymentmethod)
    - [CashMethod](#comsquareupsdkmobilepaymentspaymentadditionalpaymentmethodcashmethod)
    - [Companion](#comsquareupsdkmobilepaymentspaymentadditionalpaymentmethodcompanion)
    - [KeyedMethod](#comsquareupsdkmobilepaymentspaymentadditionalpaymentmethodkeyedmethod)
    - [Type](#comsquareupsdkmobilepaymentspaymentadditionalpaymentmethodtype)
  - [Card](#comsquareupsdkmobilepaymentspaymentcard)
    - [Brand](#comsquareupsdkmobilepaymentspaymentcardbrand)
    - [Builder](#comsquareupsdkmobilepaymentspaymentcardbuilder)
    - [CoBrand](#comsquareupsdkmobilepaymentspaymentcardcobrand)
  - [CardPaymentDetails](#comsquareupsdkmobilepaymentspaymentcardpaymentdetails)
    - [CardSurchargeDetails](#comsquareupsdkmobilepaymentspaymentcardpaymentdetailscardsurchargedetails)
    - [EntryMethod](#comsquareupsdkmobilepaymentspaymentcardpaymentdetailsentrymethod)
    - [OfflineCardPaymentDetails](#comsquareupsdkmobilepaymentspaymentcardpaymentdetailsofflinecardpaymentdetails)
    - [OnlineCardPaymentDetails](#comsquareupsdkmobilepaymentspaymentcardpaymentdetailsonlinecardpaymentdetails)
      - [Builder](#comsquareupsdkmobilepaymentspaymentcardpaymentdetailsonlinecardpaymentdetailsbuilder)
    - [Status](#comsquareupsdkmobilepaymentspaymentcardpaymentdetailsstatus)
    - [VerificationMethod](#comsquareupsdkmobilepaymentspaymentcardpaymentdetailsverificationmethod)
    - [VerificationResult](#comsquareupsdkmobilepaymentspaymentcardpaymentdetailsverificationresult)
  - [CashPaymentDetails](#comsquareupsdkmobilepaymentspaymentcashpaymentdetails)
    - [Builder](#comsquareupsdkmobilepaymentspaymentcashpaymentdetailsbuilder)
  - [CurrencyCode](#comsquareupsdkmobilepaymentspaymentcurrencycode)
  - [DelayAction](#comsquareupsdkmobilepaymentspaymentdelayaction)
  - [Money](#comsquareupsdkmobilepaymentspaymentmoney)
  - [OfflinePaymentQueue](#comsquareupsdkmobilepaymentspaymentofflinepaymentqueue)
  - [Payment](#comsquareupsdkmobilepaymentspaymentpayment)
    - [Capabilities](#comsquareupsdkmobilepaymentspaymentpaymentcapabilities)
      - [Companion](#comsquareupsdkmobilepaymentspaymentpaymentcapabilitiescompanion)
    - [OfflinePayment](#comsquareupsdkmobilepaymentspaymentpaymentofflinepayment)
      - [Builder](#comsquareupsdkmobilepaymentspaymentpaymentofflinepaymentbuilder)
    - [OfflineStatus](#comsquareupsdkmobilepaymentspaymentpaymentofflinestatus)
    - [OnlinePayment](#comsquareupsdkmobilepaymentspaymentpaymentonlinepayment)
      - [Builder](#comsquareupsdkmobilepaymentspaymentpaymentonlinepaymentbuilder)
    - [SourceType](#comsquareupsdkmobilepaymentspaymentpaymentsourcetype)
    - [Status](#comsquareupsdkmobilepaymentspaymentpaymentstatus)
  - [PaymentErrorCode](#comsquareupsdkmobilepaymentspaymentpaymenterrorcode)
  - [PaymentHandle](#comsquareupsdkmobilepaymentspaymentpaymenthandle)
    - [CancelResult](#comsquareupsdkmobilepaymentspaymentpaymenthandlecancelresult)
  - [PaymentManager](#comsquareupsdkmobilepaymentspaymentpaymentmanager)
    - [IdempotencyKeyData](#comsquareupsdkmobilepaymentspaymentpaymentmanageridempotencykeydata)
  - [PaymentParameters](#comsquareupsdkmobilepaymentspaymentpaymentparameters)
    - [Builder](#comsquareupsdkmobilepaymentspaymentpaymentparametersbuilder)
  - [PaymentProcessingFee](#comsquareupsdkmobilepaymentspaymentpaymentprocessingfee)
    - [Type](#comsquareupsdkmobilepaymentspaymentpaymentprocessingfeetype)
  - [PaymentSettings](#comsquareupsdkmobilepaymentspaymentpaymentsettings)
  - [ProcessingMode](#comsquareupsdkmobilepaymentspaymentprocessingmode)
  - [PromptMode](#comsquareupsdkmobilepaymentspaymentpromptmode)
  - [PromptParameters](#comsquareupsdkmobilepaymentspaymentpromptparameters)
- [com.squareup.sdk.mobilepayments.settings](#comsquareupsdkmobilepaymentssettings)
  - [Environment](#comsquareupsdkmobilepaymentssettingsenvironment)
  - [SdkSettings](#comsquareupsdkmobilepaymentssettingssdksettings)
  - [SettingsClosed](#comsquareupsdkmobilepaymentssettingssettingsclosed)
  - [SettingsErrorCode](#comsquareupsdkmobilepaymentssettingssettingserrorcode)
  - [SettingsManager](#comsquareupsdkmobilepaymentssettingssettingsmanager)
  - [TrackingConsentState](#comsquareupsdkmobilepaymentssettingstrackingconsentstate)

## com.squareup.sdk.mobilepayments

The top-level entry point class `MobilePaymentsSdk`.

### com.squareup.sdk.mobilepayments.MobilePaymentsSdk

object MobilePaymentsSdk

Top-level access to Mobile Payments SDK functionality. The various manager classes provided here all implement interface types you can stub out and mock for testing applications using MobilePaymentsSdk; this class functions as a factory to provide the "real" implementations.

#### Functions

| Name | Summary |
|---|---|
| authorizationManager | @JvmStatic<br>fun authorizationManager(): AuthorizationManager<br>Returns the AuthorizationManager singleton for authorizing Mobile Payments SDK to collect payments. |
| initialize | @JvmStatic<br>fun initialize(applicationId: String, application: Application)<br>The entry point for Mobile Payments SDK. Manages initialization and provides access to managers for all SDK operations. You must initialize the SDK before attempting any other operation. The SDK may only be initialized once. |
| isSandboxEnvironment | @JvmStatic<br>fun isSandboxEnvironment(): Boolean<br>Returns 'true' if Mobile Payments SDK is in Sandbox environment, 'false' otherwise. |
| paymentManager | @JvmStatic<br>fun paymentManager(): PaymentManager<br>Retrieves PaymentManager, a singleton responsible for processing payments. |
| readerManager | @JvmStatic<br>fun readerManager(): ReaderManager<br>Retrieves ReaderManager, responsible for tracking and updating the available readers. |
| settingsManager | @JvmStatic<br>fun settingsManager(): SettingsManager<br>Retrieves SettingsManager, a singleton responsible for managing SDK settings. |

#### com.squareup.sdk.mobilepayments.MobilePaymentsSdk.authorizationManager

@JvmStatic

fun authorizationManager(): AuthorizationManager

Returns the AuthorizationManager singleton for authorizing Mobile Payments SDK to collect payments.

#### com.squareup.sdk.mobilepayments.MobilePaymentsSdk.initialize

@JvmStatic

fun initialize(applicationId: String, application: Application)

The entry point for Mobile Payments SDK. Manages initialization and provides access to managers for all SDK operations. You must initialize the SDK before attempting any other operation. The SDK may only be initialized once.

#### com.squareup.sdk.mobilepayments.MobilePaymentsSdk.isSandboxEnvironment

@JvmStatic

fun isSandboxEnvironment(): Boolean

Returns 'true' if Mobile Payments SDK is in Sandbox environment, 'false' otherwise.

#### com.squareup.sdk.mobilepayments.MobilePaymentsSdk.paymentManager

@JvmStatic

fun paymentManager(): PaymentManager

Retrieves PaymentManager, a singleton responsible for processing payments.

#### com.squareup.sdk.mobilepayments.MobilePaymentsSdk.readerManager

@JvmStatic

fun readerManager(): ReaderManager

Retrieves ReaderManager, responsible for tracking and updating the available readers.

#### com.squareup.sdk.mobilepayments.MobilePaymentsSdk.settingsManager

@JvmStatic

fun settingsManager(): SettingsManager

Retrieves SettingsManager, a singleton responsible for managing SDK settings.

## com.squareup.sdk.mobilepayments.authorization

Classes to manage Mobile Payments SDK authentication.

### com.squareup.sdk.mobilepayments.authorization.AuthorizationManager

interface AuthorizationManager

Lets the application authorize and deauthorize Mobile Payments SDK to collect payments on behalf of a Square location.

#### Properties

| Name | Summary |
|---|---|
| authorizationState | abstract val authorizationState: AuthorizationState<br>Snapshot of the current authorization state. The returned AuthorizationState is immutable and is NOT modified if the state changes. If you are looking for a way to track AuthorizationState, register a callback with setAuthorizationStateChangedCallback. |
| location | abstract val location: AuthorizedLocation?<br>Snapshot of info about the authorized location, if Mobile Payments SDK is currently authorized. This value will be `null` if not authorized. |

#### Functions

| Name | Summary |
|---|---|
| authorize | abstract fun authorize(token: String, locationId: String, callback: Callback&lt;AuthorizeResult&gt;): CallbackReference<br>Asynchronously authorizes Mobile Payments SDK with an OAuth Access Token and Location ID. Applications must authorize Mobile Payments SDK before performing any other operations. |
| deauthorize | abstract fun deauthorize()<br>Deauthorizes Mobile Payments SDK. Has no effect if the SDK is already in a deauthorized state. |
| setAuthorizationStateChangedCallback | abstract fun setAuthorizationStateChangedCallback(callback: Callback&lt;AuthorizationState&gt;): CallbackReference<br>Registers a callback to be called when an authorization state changes. The supplied Callback will be called on the application UI thread when user is logged in or logged out. Important note: this callback will be called AFTER the authorization callback supplied to authorize. |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizationManager.authorizationState

abstract val authorizationState: AuthorizationState

Snapshot of the current authorization state. The returned AuthorizationState is immutable and is NOT modified if the state changes. If you are looking for a way to track AuthorizationState, register a callback with setAuthorizationStateChangedCallback.

Note: authorizationState is updated AFTER Authorization Callback is called, so you should not be using the authorizationState inside that callback.

#### com.squareup.sdk.mobilepayments.authorization.AuthorizationManager.authorize

abstract fun authorize(token: String, locationId: String, callback: Callback&lt;AuthorizeResult&gt;): CallbackReference

Asynchronously authorizes Mobile Payments SDK with an OAuth Access Token and Location ID. Applications must authorize Mobile Payments SDK before performing any other operations.

If authorization completes successfully, the callback will be called with a AuthorizedLocation object containing information about user's location. In case of failure, error description would contain an AuthorizeErrorCode.

This method must be called from the main thread. It should always be given an authorization token and a location identifier.

##### Return

a CallbackReference handle to remove the callback later.

##### Parameters

| | |
|---|---|
| token | An authorization token. Preferably an OAuth token created via the [OAuth API](https://developer.squareup.com/docs/oauth-api/overview), but it is possible to use a Personal Access Token instead. Best practice is generally to store tokens in server-side storage, refreshing and maintaining them there, and to send the token from that secure storage to the client application and to this API as part of a user login or registration process in your app. |
| locationId | The identifier of the location which will be associated with payments processed via the SDK. |
| callback | Adds a callback to handle the result of an authorization attempt. The callback is executed on the main thread. It is suggested to rely on setAuthorizationStateChangedCallback instead, however, as deauthorization can happen at any time due to token expiration or revocation. If a callback has already been provided via setAuthorizationStateChangedCallback and the authorization state changes during a call to this method, both this argument *and* the registered callback will be called. |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizationManager.deauthorize

abstract fun deauthorize()

Deauthorizes Mobile Payments SDK. Has no effect if the SDK is already in a deauthorized state.

#### com.squareup.sdk.mobilepayments.authorization.AuthorizationManager.location

abstract val location: AuthorizedLocation?

Snapshot of info about the authorized location, if Mobile Payments SDK is currently authorized. This value will be `null` if not authorized.

#### com.squareup.sdk.mobilepayments.authorization.AuthorizationManager.setAuthorizationStateChangedCallback

abstract fun setAuthorizationStateChangedCallback(callback: Callback&lt;AuthorizationState&gt;): CallbackReference

Registers a callback to be called when an authorization state changes. The supplied Callback will be called on the application UI thread when user is logged in or logged out. Important note: this callback will be called AFTER the authorization callback supplied to authorize.

If you are looking for a synchronous way to get authorization state, use authorizationState property instead.

##### Return

a CallbackReference handle to remove the callback later.

##### See also

| |
|---|
| AuthorizationManager.authorizationState |

### com.squareup.sdk.mobilepayments.authorization.AuthorizationState

class AuthorizationState

An immutable snapshot of the authorization state of Mobile Payments SDK.

#### Types

| Name | Summary |
|---|---|
| Companion | object Companion<br>Helper methods to create a new AuthorizationState instance. |

#### Properties

| Name | Summary |
|---|---|
| isAuthorizationInProgress | val isAuthorizationInProgress: Boolean<br>Returns `true` if a Mobile Payments SDK authorization is in progress, `false` otherwise. |
| isAuthorized | val isAuthorized: Boolean<br>Returns `true` if Mobile Payments SDK is currently authorized to collect payments on behalf of a Square location, `false` otherwise. |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizationState.isAuthorizationInProgress

val isAuthorizationInProgress: Boolean

Returns `true` if a Mobile Payments SDK authorization is in progress, `false` otherwise.

#### com.squareup.sdk.mobilepayments.authorization.AuthorizationState.isAuthorized

val isAuthorized: Boolean

Returns `true` if Mobile Payments SDK is currently authorized to collect payments on behalf of a Square location, `false` otherwise.

#### com.squareup.sdk.mobilepayments.authorization.AuthorizationState.Companion

object Companion

Helper methods to create a new AuthorizationState instance.

##### Functions

| Name | Summary |
|---|---|
| newAuthorizedState | @JvmStatic<br>fun newAuthorizedState(): AuthorizationState<br>Returns new authorized AuthorizationState instance. This method is provided for testing purposes. |
| newInProgressState | @JvmStatic<br>fun newInProgressState(): AuthorizationState<br>Returns a new in progress AuthorizationState instance. This method is provided for testing purposes. |
| newUnauthorizedState | @JvmStatic<br>fun newUnauthorizedState(): AuthorizationState<br>Returns a new unauthorized AuthorizationState instance. This method is provided for testing purposes. |

##### com.squareup.sdk.mobilepayments.authorization.AuthorizationState.Companion.newAuthorizedState

@JvmStatic

fun newAuthorizedState(): AuthorizationState

Returns new authorized AuthorizationState instance. This method is provided for testing purposes.

##### com.squareup.sdk.mobilepayments.authorization.AuthorizationState.Companion.newInProgressState

@JvmStatic

fun newInProgressState(): AuthorizationState

Returns a new in progress AuthorizationState instance. This method is provided for testing purposes.

##### com.squareup.sdk.mobilepayments.authorization.AuthorizationState.Companion.newUnauthorizedState

@JvmStatic

fun newUnauthorizedState(): AuthorizationState

Returns a new unauthorized AuthorizationState instance. This method is provided for testing purposes.

### com.squareup.sdk.mobilepayments.authorization.AuthorizeErrorCode

enum AuthorizeErrorCode : ErrorCode, Enum&lt;AuthorizeErrorCode&gt; 

Possible error codes that can be returned as a result of a call to AuthorizationManager.authorize.

#### Entries

| | |
|---|---|
| NO_NETWORK | NO_NETWORK<br>Mobile Payments SDK could not connect to the network. |
| OBSOLETE_SDK | OBSOLETE_SDK<br>The SDK version is obsolete and must be updated. This error is only triggered in debuggable builds when the obsolete SDK feature flag is enabled. |
| UNSUPPORTED_COUNTRY | UNSUPPORTED_COUNTRY<br>Usage of Mobile Payments SDK is not allowed in this country. |
| USAGE_ERROR | USAGE_ERROR<br>AuthorizationManager.authorize was used in an unexpected or unsupported way. See Result.Failure.debugCode and Result.Failure.debugMessage for more information. |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;AuthorizeErrorCode&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| isUsageError | open override val isUsageError: Boolean<br>Returns `true` if the error is a usage error, `false` otherwise. |
| name | val name: String<br>Returns the name of the error code. |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): AuthorizeErrorCode<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;AuthorizeErrorCode&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizeErrorCode.entries

val entries: EnumEntries&lt;AuthorizeErrorCode&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.authorization.AuthorizeErrorCode.isUsageError

open override val isUsageError: Boolean

Returns `true` if the error is a usage error, `false` otherwise.

Useful for writing shared handling of debug codes and messages across Mobile Payments SDK operations.

#### com.squareup.sdk.mobilepayments.authorization.AuthorizeErrorCode.valueOf

fun valueOf(value: String): AuthorizeErrorCode

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizeErrorCode.values

fun values(): Array&lt;AuthorizeErrorCode&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.authorization.AuthorizedLocation

class AuthorizedLocation(val merchantId: String, val locationId: String, val currencyCode: CurrencyCode, val name: String, val businessName: String, val cardProcessingActivated: Boolean)

Authorized account location information.

#### Parameters

| | |
|---|---|
| merchantId | Merchant ID of the authorized user, |
| locationId | Location ID of the authorized user. |
| currencyCode | Currency code of the authorized location. |
| name | Location name of the authorized user. |
| businessName | Business name of the authorized user. |
| cardProcessingActivated | Card processing capabilities. |

#### Constructors

| | |
|---|---|
| AuthorizedLocation | constructor(merchantId: String, locationId: String, currencyCode: CurrencyCode, name: String, businessName: String, cardProcessingActivated: Boolean) |

#### Properties

| Name | Summary |
|---|---|
| businessName | val businessName: String |
| cardProcessingActivated | val cardProcessingActivated: Boolean |
| currencyCode | val currencyCode: CurrencyCode |
| locationId | val locationId: String |
| merchantId | val merchantId: String |
| name | val name: String |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizedLocation.businessName

val businessName: String

##### Parameters

| | |
|---|---|
| businessName | Business name of the authorized user. |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizedLocation.cardProcessingActivated

val cardProcessingActivated: Boolean

##### Parameters

| | |
|---|---|
| cardProcessingActivated | Card processing capabilities. |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizedLocation.currencyCode

val currencyCode: CurrencyCode

##### Parameters

| | |
|---|---|
| currencyCode | Currency code of the authorized location. |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizedLocation.locationId

val locationId: String

##### Parameters

| | |
|---|---|
| locationId | Location ID of the authorized user. |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizedLocation.merchantId

val merchantId: String

##### Parameters

| | |
|---|---|
| merchantId | Merchant ID of the authorized user, |

#### com.squareup.sdk.mobilepayments.authorization.AuthorizedLocation.name

val name: String

##### Parameters

| | |
|---|---|
| name | Location name of the authorized user. |

## com.squareup.sdk.mobilepayments.cardreader

Classes to connect and manage a set of Square Readers, including advisory hardware warnings exposed through reader snapshots and change callbacks.

### com.squareup.sdk.mobilepayments.cardreader.CardEntryMethod

enum CardEntryMethod : Enum&lt;CardEntryMethod&gt; 

Methods of payments that might be supported by readers.

#### Entries

| | |
|---|---|
| SWIPED | SWIPED<br>Magnetic strip swiping. |
| EMV | EMV<br>Chip card insertion, or "dip". |
| CONTACTLESS | CONTACTLESS<br>NFC contactless payment, or "tap". |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;CardEntryMethod&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): CardEntryMethod<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;CardEntryMethod&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.cardreader.CardEntryMethod.entries

val entries: EnumEntries&lt;CardEntryMethod&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.cardreader.CardEntryMethod.valueOf

fun valueOf(value: String): CardEntryMethod

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.cardreader.CardEntryMethod.values

fun values(): Array&lt;CardEntryMethod&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.cardreader.PairingErrorCode

enum PairingErrorCode : ErrorCode, Enum&lt;PairingErrorCode&gt; 

Error conditions that arise when pairing readers.

#### Entries

| | |
|---|---|
| BLUETOOTH_ALREADY_SCANNING | BLUETOOTH_ALREADY_SCANNING<br>Only one scan is allowed at a time. |
| BLUETOOTH_DISABLED | BLUETOOTH_DISABLED<br>Bluetooth is disabled. |
| BLUETOOTH_PERMISSION_DENIED | BLUETOOTH_PERMISSION_DENIED<br>Missing one or both of the Android runtime permissions for Bluetooth, BLUETOOTH_CONNECT and/or BLUETOOTH_SCAN. |
| BLUETOOTH_UNSUPPORTED | BLUETOOTH_UNSUPPORTED<br>Device does not support bluetooth. |
| NOT_AUTHORIZED | NOT_AUTHORIZED<br>Pairing attempted before authorization. |
| TIMEOUT | TIMEOUT<br>Pairing did not complete in reasonable time. |
| USAGE_ERROR | USAGE_ERROR<br>ReaderManager.pairReader was used in an unexpected or unsupported way. See the debug code and debug message for more information. |
| APP_UPDATE_REQUIRED | APP_UPDATE_REQUIRED<br>App version is incompatible with reader firmware and requires an update. |
| BOND_FAILED | BOND_FAILED<br>Unable to create a Bluetooth bond with the reader device. |
| INTERNAL_FIRMWARE_ERROR | INTERNAL_FIRMWARE_ERROR<br>An internal firmware error occurred on the reader device. |
| HOST_ID_MISMATCH | HOST_ID_MISMATCH<br>The reader refused the connection because it is paired to another device. A reader only accepts connections from the device it was most recently paired with. Put the reader into pairing mode and pair it with this device. |
| UNKNOWN_ERROR | UNKNOWN_ERROR<br>An unknown error occurred while attempting to pair with the reader. |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;PairingErrorCode&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| isUsageError | open override val isUsageError: Boolean<br>Returns `true` if the error is a usage error, `false` otherwise. |
| name | val name: String<br>Returns the name of the error code. |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): PairingErrorCode<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;PairingErrorCode&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.cardreader.PairingErrorCode.entries

val entries: EnumEntries&lt;PairingErrorCode&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.cardreader.PairingErrorCode.isUsageError

open override val isUsageError: Boolean

Returns `true` if the error is a usage error, `false` otherwise.

Useful for writing shared handling of debug codes and messages across Mobile Payments SDK operations.

#### com.squareup.sdk.mobilepayments.cardreader.PairingErrorCode.valueOf

fun valueOf(value: String): PairingErrorCode

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.cardreader.PairingErrorCode.values

fun values(): Array&lt;PairingErrorCode&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.cardreader.PairingHandle

interface PairingHandle

Representation of a reader pairing available immediately from ReaderManager.pairReader. Provides a way to interact with an ongoing reader pairing, e.g. stop it.

#### Types

| Name | Summary |
|---|---|
| StopResult | enum StopResult : Enum&lt;PairingHandle.StopResult&gt; |

#### Functions

| Name | Summary |
|---|---|
| stop | abstract fun stop(): PairingHandle.StopResult<br>Attempts to stop pairing readers. |

#### com.squareup.sdk.mobilepayments.cardreader.PairingHandle.stop

abstract fun stop(): PairingHandle.StopResult

Attempts to stop pairing readers.

#### com.squareup.sdk.mobilepayments.cardreader.PairingHandle.StopResult

enum StopResult : Enum&lt;PairingHandle.StopResult&gt;

##### Entries

| | |
|---|---|
| ALREADY_COMPLETE | ALREADY_COMPLETE<br>Error result when the pairing has already completed. |
| STOPPED | STOPPED<br>Successfully stopped the attempt to pair the SDK to the reader. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;PairingHandle.StopResult&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): PairingHandle.StopResult<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;PairingHandle.StopResult&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.cardreader.PairingHandle.StopResult.entries

val entries: EnumEntries&lt;PairingHandle.StopResult&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.cardreader.PairingHandle.StopResult.valueOf

fun valueOf(value: String): PairingHandle.StopResult

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.cardreader.PairingHandle.StopResult.values

fun values(): Array&lt;PairingHandle.StopResult&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.cardreader.ReaderChangedEvent

class ReaderChangedEvent(val change: ReaderChangedEvent.Change, val reader: ReaderInfo, val readerSerialNumber: String?)

Data provided by Mobile Payments SDK to indicate a change in a specific reader.

#### Parameters

| | |
|---|---|
| change | the type of change that occurred. |
| reader | the new status of the card reader. This is a "snapshot," not a live object, so it will not be updated in place to reflect new changes. Instead, a second callback will be made with a second instance of ReaderInfo. |
| readerSerialNumber | the serial number of the reader obtained from ReaderInfo. |

#### Constructors

| | |
|---|---|
| ReaderChangedEvent | constructor(change: ReaderChangedEvent.Change, reader: ReaderInfo, readerSerialNumber: String?) |

#### Types

| Name | Summary |
|---|---|
| Change | enum Change : Enum&lt;ReaderChangedEvent.Change&gt; <br>Types of reader-related changes. |

#### Properties

| Name | Summary |
|---|---|
| change | val change: ReaderChangedEvent.Change |
| reader | val reader: ReaderInfo |
| readerSerialNumber | val readerSerialNumber: String? |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderChangedEvent.change

val change: ReaderChangedEvent.Change

##### Parameters

| | |
|---|---|
| change | the type of change that occurred. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderChangedEvent.readerSerialNumber

val readerSerialNumber: String?

##### Parameters

| | |
|---|---|
| readerSerialNumber | the serial number of the reader obtained from ReaderInfo. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderChangedEvent.reader

val reader: ReaderInfo

##### Parameters

| | |
|---|---|
| reader | the new status of the card reader. This is a "snapshot," not a live object, so it will not be updated in place to reflect new changes. Instead, a second callback will be made with a second instance of ReaderInfo. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderChangedEvent.Change

enum Change : Enum&lt;ReaderChangedEvent.Change&gt; 

Types of reader-related changes.

##### Entries

| | |
|---|---|
| ADDED | ADDED<br>Discovery of a new card reader. |
| CHANGED_STATE | CHANGED_STATE<br>A change to the internal state of the reader. See ReaderInfo.status for details. |
| BATTERY_THRESHOLD | BATTERY_THRESHOLD<br>Called when a reader's battery level passes pre-defined thresholds. |
| BATTERY_CHARGING | BATTERY_CHARGING<br>Called when a reader is plugged in or unplugged from charging. |
| FIRMWARE_PROGRESS | FIRMWARE_PROGRESS<br>Called repeatedly during a firmware update to report completion status. Reader state may be either ReaderInfo.Status.ReaderUnavailable(reason = BLOCKING_UPDATE) for blocking updates, or ReaderInfo.Status.Ready during non-blocking updates. |
| REMOVED | REMOVED<br>Called when a reader is unplugged from device, or "forgotten" from pairing. |
| WARNING_RAISED | WARNING_RAISED<br>Called when the reader reports one or more new advisory warnings. Inspect ReaderInfo.warnings on ReaderChangedEvent.reader; the set contains every warning reported during the current connection, not only the newly reported warnings, and can contain multiple values. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;ReaderChangedEvent.Change&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): ReaderChangedEvent.Change<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;ReaderChangedEvent.Change&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderChangedEvent.Change.entries

val entries: EnumEntries&lt;ReaderChangedEvent.Change&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.cardreader.ReaderChangedEvent.Change.valueOf

fun valueOf(value: String): ReaderChangedEvent.Change

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderChangedEvent.Change.values

fun values(): Array&lt;ReaderChangedEvent.Change&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo

class ReaderInfo(val id: String, val model: ReaderInfo.Model, val status: ReaderInfo.Status, val serialNumber: String?, val name: String, val connectionType: ReaderInfo.ConnectionType, val batteryStatus: ReaderInfo.BatteryStatus?, firmwareVersion: String?, firmwarePercent: Int?, val supportedCardEntryMethods: Set&lt;CardEntryMethod&gt;, val isForgettable: Boolean = model == Model.CONTACTLESS_AND_CHIP, val isBlinkable: Boolean = model == Model.CONTACTLESS_AND_CHIP, val firmwareInfo: ReaderInfo.ReaderFirmwareInfo, val warnings: Set&lt;ReaderInfo.ReaderWarning&gt; = emptySet())

Provides information about an individual card reader at a given time. This is an immutable snapshot of the reader's past state, not a live model object. Updates are provided via callbacks registered via ReaderManager.setReaderChangedCallback.

#### Parameters

| | |
|---|---|
| id | String that identifies this reader. For "smart" readers, this represents the mac address of the device. If the reader is a magstripe reader, the ID will be a string identifying it as a magstripe reader. |
| model | Type of the reader, one of the Model. |
| status | Current status of the reader. A reader in Status.Ready can be used to take a payment. Other statuses represent readers that cannot currently take payments. However, you can start a payment with a non-Ready reader if the payment is made with manually-entered card information, or if the reader becomes Status.Ready later in the course of the payment. |
| serialNumber | Unique but not particularly informative string that identifies this reader. Provided by "smart" readers. This represents the serial number of the device. A null value indicates that the smart reader has not yet provided a serial or that the device isn't a smart reader. |
| name | Readable and hopefully-unique name for this reader. Unlike the return from serialNumber, which is guaranteed to be different from any other reader, the name is only *unlikely* to be duplicated by other readers. |
| batteryStatus | Current battery information. Returns `null` for readers without a battery, such as the magstripe reader. See BatteryStatus. |
| firmwareVersion | Unique identifier of the firmware currently installed on the reader. If the firmware version is not identifiable (e.g. magstripe readers), returns `null`. |
| firmwarePercent | set only if either a blocking or non-blocking firmware update is in progress. If set, it is an integer from 0 to 100 inclusive with an estimate of the update percentage completed. |
| supportedCardEntryMethods | Set of card entry methods this reader can support. At a given time, a reader might not be able to use all the "supported" payment methods. In particular, for a CardEntryMethod.CONTACTLESS the contactless NFC field will time out a while after a payment begins, and after that a contactless tap will not work, even though contactless payments are supported by the reader. Because these changes to the *available* payment methods happen in the context of a payment, they are reported through the com.squareup.sdk.mobilepayments.payment.PaymentManager instead. See CardEntryMethod for possible entry values. |
| isForgettable | Indicates whether reader can be "forgotten", either to permanently remove the reader, or to allow it to pair again "from scratch". |
| isBlinkable | Indicates whether reader has LEDs to blink. This can be used to identify a particular reader among several, with the ReaderManager.blink method. |
| firmwareInfo | Information about the reader's firmware, including the current version and update status. |
| warnings | SDK-defined advisory warnings the reader has reported during the current connection. Warnings do not affect status: a reader can be Status.Ready and still carry a warning. When ReaderChangedEvent.Change.WARNING_RAISED is delivered, inspect the event's ReaderChangedEvent.reader and its warnings; the set contains every warning reported during the connection, not only the newly reported warnings, and can contain multiple values. Warnings are cleared when the reader disconnects or reconnects. In particular, a reader that powers itself off because its temperature is outside the supported range reports as disconnected *without*ReaderWarning.THERMAL_FAULT_POWER_OFF, so respond to the warning callback promptly. |

#### Constructors

| | |
|---|---|
| ReaderInfo | constructor(id: String, model: ReaderInfo.Model, status: ReaderInfo.Status, serialNumber: String?, name: String, connectionType: ReaderInfo.ConnectionType, batteryStatus: ReaderInfo.BatteryStatus?, firmwareVersion: String?, firmwarePercent: Int?, supportedCardEntryMethods: Set&lt;CardEntryMethod&gt;, isForgettable: Boolean = model == Model.CONTACTLESS_AND_CHIP, isBlinkable: Boolean = model == Model.CONTACTLESS_AND_CHIP, firmwareInfo: ReaderInfo.ReaderFirmwareInfo, warnings: Set&lt;ReaderInfo.ReaderWarning&gt; = emptySet()) |

#### Types

| Name | Summary |
|---|---|
| BatteryStatus | class BatteryStatus(val percent: Int, val isCharging: Boolean)<br>Status of the reader's battery. |
| ConnectionType | enum ConnectionType : Enum&lt;ReaderInfo.ConnectionType&gt; <br>The reader's connection type. |
| FirmwareUpdateStatus | sealed class FirmwareUpdateStatus<br>The status of any firmware update currently in progress. |
| Model | enum Model : Enum&lt;ReaderInfo.Model&gt; <br>The model of reader. |
| ReaderFirmwareInfo | data class ReaderFirmwareInfo(val version: String?, val updateStatus: ReaderInfo.FirmwareUpdateStatus)<br>Information about the reader's firmware. |
| ReaderWarning | enum ReaderWarning : Enum&lt;ReaderInfo.ReaderWarning&gt; <br>An SDK-defined advisory warning reported by the reader during the current connection. These values are independent of reader firmware notification identifiers. See ReaderInfo.warnings for delivery and lifetime semantics. |
| Status | sealed class Status<br>The current status of a reader. Model.MAGSTRIPE readers are unavailable when microphone permission is required; otherwise they are Ready. |

#### Properties

| Name | Summary |
|---|---|
| batteryStatus | val batteryStatus: ReaderInfo.BatteryStatus? |
| connectionType | val connectionType: ReaderInfo.ConnectionType |
| firmwareInfo | val firmwareInfo: ReaderInfo.ReaderFirmwareInfo |
| id | val id: String |
| isBlinkable | val isBlinkable: Boolean |
| isForgettable | val isForgettable: Boolean |
| model | val model: ReaderInfo.Model |
| name | val name: String |
| serialNumber | val serialNumber: String? |
| status | val status: ReaderInfo.Status |
| supportedCardEntryMethods | val supportedCardEntryMethods: Set&lt;CardEntryMethod&gt; |
| warnings | val warnings: Set&lt;ReaderInfo.ReaderWarning&gt; |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.batteryStatus

val batteryStatus: ReaderInfo.BatteryStatus?

##### Parameters

| | |
|---|---|
| batteryStatus | Current battery information. Returns `null` for readers without a battery, such as the magstripe reader. See BatteryStatus. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.firmwareInfo

val firmwareInfo: ReaderInfo.ReaderFirmwareInfo

##### Parameters

| | |
|---|---|
| firmwareInfo | Information about the reader's firmware, including the current version and update status. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.id

val id: String

##### Parameters

| | |
|---|---|
| id | String that identifies this reader. For "smart" readers, this represents the mac address of the device. If the reader is a magstripe reader, the ID will be a string identifying it as a magstripe reader. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.isBlinkable

val isBlinkable: Boolean

##### Parameters

| | |
|---|---|
| isBlinkable | Indicates whether reader has LEDs to blink. This can be used to identify a particular reader among several, with the ReaderManager.blink method. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.isForgettable

val isForgettable: Boolean

##### Parameters

| | |
|---|---|
| isForgettable | Indicates whether reader can be "forgotten", either to permanently remove the reader, or to allow it to pair again "from scratch". |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.model

val model: ReaderInfo.Model

##### Parameters

| | |
|---|---|
| model | Type of the reader, one of the Model. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.name

val name: String

##### Parameters

| | |
|---|---|
| name | Readable and hopefully-unique name for this reader. Unlike the return from serialNumber, which is guaranteed to be different from any other reader, the name is only *unlikely* to be duplicated by other readers. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.serialNumber

val serialNumber: String?

##### Parameters

| | |
|---|---|
| serialNumber | Unique but not particularly informative string that identifies this reader. Provided by "smart" readers. This represents the serial number of the device. A null value indicates that the smart reader has not yet provided a serial or that the device isn't a smart reader. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.status

val status: ReaderInfo.Status

##### Parameters

| | |
|---|---|
| status | Current status of the reader. A reader in Status.Ready can be used to take a payment. Other statuses represent readers that cannot currently take payments. However, you can start a payment with a non-Ready reader if the payment is made with manually-entered card information, or if the reader becomes Status.Ready later in the course of the payment. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.supportedCardEntryMethods

val supportedCardEntryMethods: Set&lt;CardEntryMethod&gt;

##### Parameters

| | |
|---|---|
| supportedCardEntryMethods | Set of card entry methods this reader can support. At a given time, a reader might not be able to use all the "supported" payment methods. In particular, for a CardEntryMethod.CONTACTLESS the contactless NFC field will time out a while after a payment begins, and after that a contactless tap will not work, even though contactless payments are supported by the reader. Because these changes to the *available* payment methods happen in the context of a payment, they are reported through the com.squareup.sdk.mobilepayments.payment.PaymentManager instead. See CardEntryMethod for possible entry values. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.warnings

val warnings: Set&lt;ReaderInfo.ReaderWarning&gt;

##### Parameters

| | |
|---|---|
| warnings | SDK-defined advisory warnings the reader has reported during the current connection. Warnings do not affect status: a reader can be Status.Ready and still carry a warning. When ReaderChangedEvent.Change.WARNING_RAISED is delivered, inspect the event's ReaderChangedEvent.reader and its warnings; the set contains every warning reported during the connection, not only the newly reported warnings, and can contain multiple values. Warnings are cleared when the reader disconnects or reconnects. In particular, a reader that powers itself off because its temperature is outside the supported range reports as disconnected *without*ReaderWarning.THERMAL_FAULT_POWER_OFF, so respond to the warning callback promptly. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.BatteryStatus

class BatteryStatus(val percent: Int, val isCharging: Boolean)

Status of the reader's battery.

##### Parameters

| | |
|---|---|
| percent | The charge percentage, an integer between 0 and 100. |
| isCharging | `true` if the reader is connected to a charger. |

##### Constructors

| | |
|---|---|
| BatteryStatus | constructor(percent: Int, isCharging: Boolean) |

##### Properties

| Name | Summary |
|---|---|
| isCharging | val isCharging: Boolean |
| percent | val percent: Int |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.BatteryStatus.isCharging

val isCharging: Boolean

###### Parameters

| | |
|---|---|
| isCharging | `true` if the reader is connected to a charger. |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.BatteryStatus.percent

val percent: Int

###### Parameters

| | |
|---|---|
| percent | The charge percentage, an integer between 0 and 100. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.ConnectionType

enum ConnectionType : Enum&lt;ReaderInfo.ConnectionType&gt; 

The reader's connection type.

##### Entries

| | |
|---|---|
| USB | USB |
| BLUETOOTH | BLUETOOTH |
| AUDIO | AUDIO |
| EMBEDDED | EMBEDDED |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;ReaderInfo.ConnectionType&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): ReaderInfo.ConnectionType<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;ReaderInfo.ConnectionType&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.ConnectionType.entries

val entries: EnumEntries&lt;ReaderInfo.ConnectionType&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.ConnectionType.valueOf

fun valueOf(value: String): ReaderInfo.ConnectionType

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.ConnectionType.values

fun values(): Array&lt;ReaderInfo.ConnectionType&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.FirmwareUpdateStatus

sealed class FirmwareUpdateStatus

The status of any firmware update currently in progress.

##### Inheritors

| |
|---|
| None |
| Pending |
| InProgress |

##### Types

| Name | Summary |
|---|---|
| InProgress | data class InProgress(val updatePercentage: Int?) : ReaderInfo.FirmwareUpdateStatus<br>A firmware update is currently in progress. |
| None | data object None : ReaderInfo.FirmwareUpdateStatus<br>No firmware update is currently in progress. |
| Pending | data class Pending(val updateDate: Date) : ReaderInfo.FirmwareUpdateStatus<br>A firmware update is pending. The reader will restart at the specified updateDate. |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.FirmwareUpdateStatus.InProgress

data class InProgress(val updatePercentage: Int?) : ReaderInfo.FirmwareUpdateStatus

A firmware update is currently in progress.

###### Constructors

| | |
|---|---|
| InProgress | constructor(updatePercentage: Int?) |

###### Properties

| Name | Summary |
|---|---|
| updatePercentage | val updatePercentage: Int?<br>an integer from 0 to 100 (inclusive), representing the percentage of the update that is complete, if known. |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.FirmwareUpdateStatus.None

data object None : ReaderInfo.FirmwareUpdateStatus

No firmware update is currently in progress.

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.FirmwareUpdateStatus.Pending

data class Pending(val updateDate: Date) : ReaderInfo.FirmwareUpdateStatus

A firmware update is pending. The reader will restart at the specified updateDate.

###### Constructors

| | |
|---|---|
| Pending | constructor(updateDate: Date) |

###### Properties

| Name | Summary |
|---|---|
| updateDate | val updateDate: Date |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Model

enum Model : Enum&lt;ReaderInfo.Model&gt; 

The model of reader.

##### Entries

| | |
|---|---|
| MAGSTRIPE | MAGSTRIPE<br>[Square Reader for magstripe](https://squareup.com/shop/hardware/us/en/products/free-credit-card-reader). |
| CONTACTLESS_AND_CHIP | CONTACTLESS_AND_CHIP<br>[Square Reader for contactless and chip](https://squareup.com/shop/hardware/us/en/products/chip-credit-card-reader-with-nfc). |
| TAP_TO_PAY | TAP_TO_PAY<br>Square Embedded Reader for contactless This Reader model is currently unavailable. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;ReaderInfo.Model&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): ReaderInfo.Model<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;ReaderInfo.Model&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Model.entries

val entries: EnumEntries&lt;ReaderInfo.Model&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Model.valueOf

fun valueOf(value: String): ReaderInfo.Model

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Model.values

fun values(): Array&lt;ReaderInfo.Model&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.ReaderFirmwareInfo

data class ReaderFirmwareInfo(val version: String?, val updateStatus: ReaderInfo.FirmwareUpdateStatus)

Information about the reader's firmware.

##### Constructors

| | |
|---|---|
| ReaderFirmwareInfo | constructor(version: String?, updateStatus: ReaderInfo.FirmwareUpdateStatus) |

##### Properties

| Name | Summary |
|---|---|
| updateStatus | val updateStatus: ReaderInfo.FirmwareUpdateStatus<br>The status of any firmware update currently in progress. If no update is in progress, this will be FirmwareUpdateStatus.None. |
| version | val version: String?<br>Unique identifier of the firmware currently installed on the reader. If the firmware version is not identifiable (e.g. magstripe readers), returns `null`. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.ReaderWarning

enum ReaderWarning : Enum&lt;ReaderInfo.ReaderWarning&gt; 

An SDK-defined advisory warning reported by the reader during the current connection. These values are independent of reader firmware notification identifiers. See ReaderInfo.warnings for delivery and lifetime semantics.

##### Entries

| | |
|---|---|
| USB_THERMAL_FAULT | USB_THERMAL_FAULT<br>The reader detected an abnormally high temperature on its USB port, usually caused by an electrical short circuit. Unplug the reader, remove any debris from the charging port, and plug it back in after two minutes. |
| THERMAL_FAULT_DISCONNECT_USB | THERMAL_FAULT_DISCONNECT_USB<br>The reader is overheating while connected to USB. Unplug the reader from USB and plug it back in once it has cooled down. |
| THERMAL_FAULT_POWER_OFF | THERMAL_FAULT_POWER_OFF<br>The reader is overheating while not connected to USB and will power itself off. Press the button on the reader to reconnect once it has cooled down. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;ReaderInfo.ReaderWarning&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): ReaderInfo.ReaderWarning<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;ReaderInfo.ReaderWarning&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.ReaderWarning.entries

val entries: EnumEntries&lt;ReaderInfo.ReaderWarning&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.ReaderWarning.valueOf

fun valueOf(value: String): ReaderInfo.ReaderWarning

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.ReaderWarning.values

fun values(): Array&lt;ReaderInfo.ReaderWarning&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

#### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status

sealed class Status

The current status of a reader. Model.MAGSTRIPE readers are unavailable when microphone permission is required; otherwise they are Ready.

##### Inheritors

| |
|---|
| ConnectingToDevice |
| ConnectingToSquare |
| ReaderUnavailable |
| Faulty |
| Ready |

##### Types

| Name | Summary |
|---|---|
| ConnectingToDevice | data object ConnectingToDevice : ReaderInfo.Status<br>Establishing a connection to the device. |
| ConnectingToSquare | data object ConnectingToSquare : ReaderInfo.Status<br>Establishing a secure connection to Square. |
| Faulty | data object Faulty : ReaderInfo.Status<br>This reader is in an unrecoverable state, and may require replacement. Contact support. |
| ReaderUnavailable | data class ReaderUnavailable(val reason: ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason) : ReaderInfo.Status<br>This reader is unavailable. |
| Ready | data object Ready : ReaderInfo.Status<br>This reader is ready to take payments. |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status.ConnectingToDevice

data object ConnectingToDevice : ReaderInfo.Status

Establishing a connection to the device.

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status.ConnectingToSquare

data object ConnectingToSquare : ReaderInfo.Status

Establishing a secure connection to Square.

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status.Faulty

data object Faulty : ReaderInfo.Status

This reader is in an unrecoverable state, and may require replacement. Contact support.

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status.ReaderUnavailable

data class ReaderUnavailable(val reason: ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason) : ReaderInfo.Status

This reader is unavailable.

###### Parameters

| | |
|---|---|
| reason | why this reader is unavailable. |

###### Constructors

| | |
|---|---|
| ReaderUnavailable | constructor(reason: ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason) |

###### Types

| Name | Summary |
|---|---|
| ReaderUnavailableReason | enum ReaderUnavailableReason : Enum&lt;ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason&gt; <br>The reason this reader is unavailable. This information is included in Status. |

###### Properties

| Name | Summary |
|---|---|
| reason | val reason: ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason |

###### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status.ReaderUnavailable.reason

val reason: ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason

###### Parameters

| | |
|---|---|
| reason | why this reader is unavailable. |

###### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason

enum ReaderUnavailableReason : Enum&lt;ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason&gt; 

The reason this reader is unavailable. This information is included in Status.

###### Entries

| | |
|---|---|
| INTERNAL_ERROR | INTERNAL_ERROR<br>Square experienced an issue connecting to this reader. |
| BLUETOOTH_DISABLED | BLUETOOTH_DISABLED<br>Bluetooth has been disabled on this device. Re-enable Bluetooth to connect to a reader. |
| BLUETOOTH_FAILURE | BLUETOOTH_FAILURE<br>Something went wrong establishing a Bluetooth connection. Disable and re-enable Bluetooth on your device to try again. |
| SECURE_CONNECTION_TO_SQUARE_FAILURE | SECURE_CONNECTION_TO_SQUARE_FAILURE<br>Unable to establish a secure connection to Square. |
| SECURE_CONNECTION_NETWORK_FAILURE | SECURE_CONNECTION_NETWORK_FAILURE<br>Unable to establish a secure connection to Square. Connect to a network and try again. |
| OFFLINE_SESSION_EXPIRED | OFFLINE_SESSION_EXPIRED<br>Connect to a network to renew your secure connection to Square. |
| READER_UNAVAILABLE_OFFLINE | READER_UNAVAILABLE_OFFLINE<br>The merchant is offline and this reader is not able to take offline payments. Connect to a network or try another reader. |
| OFFLINE_MODE_DISABLED | OFFLINE_MODE_DISABLED<br>The merchant is offline and offline mode has been disabled. Merchant must connect to a network and enable offline mode before using this reader offline. |
| READER_UPDATE_FAILED | READER_UPDATE_FAILED<br>This reader failed to update. |
| BLOCKING_UPDATE | BLOCKING_UPDATE<br>The reader is getting a blocking update and cannot be used to take payments until the update completes. |
| MERCHANT_SUSPENDED | MERCHANT_SUSPENDED<br>The merchant's account is suspended. Readers cannot be connected until the merchant's account is active. |
| MERCHANT_INELIGIBLE | MERCHANT_INELIGIBLE<br>The merchant's account is ineligible for activation with Square. Readers cannot be connected until the merchant's account is active. |
| MERCHANT_NOT_ACTIVATED | MERCHANT_NOT_ACTIVATED<br>The merchant's Square account is not active and cannot take payments. Readers cannot be connected until the merchant's account is active. |
| DEVICE_NOT_SUPPORTED | DEVICE_NOT_SUPPORTED<br>This mobile device is not supported by the Mobile Payments SDK. Connect the reader to a supported device to take payments. |
| READER_FIRMWARE_UPDATE_REQUIRED | READER_FIRMWARE_UPDATE_REQUIRED<br>Reader firmware update required. Please disconnect and reconnect the reader to trigger a firmware update. |
| READER_NOT_SUPPORTED | READER_NOT_SUPPORTED<br>This reader is not supported. Please try another reader. |
| DEVICE_ROOTED | DEVICE_ROOTED<br>Rooted devices are not supported. Remove Root from this mobile device in order to connect a reader. |
| DEVICE_DEVELOPER_MODE | DEVICE_DEVELOPER_MODE<br>Developer Options are enabled. Please disable Developer Options on this mobile device and restart app in order to use this reader. |
| DISABLED | DISABLED<br>This device has been disabled. Please enable this device, to take payments with it. |
| HOST_ID_MISMATCH | HOST_ID_MISMATCH<br>This reader is paired to another device. A reader only accepts connections from the device it was most recently paired with. Put the reader into pairing mode and pair it with this device to take payments. |
| MICROPHONE_PERMISSION_REQUIRED | MICROPHONE_PERMISSION_REQUIRED<br>Microphone permission is required but not granted. Grant microphone permission to use the Square Reader for magstripe. |

###### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

###### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

####### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason.entries

val entries: EnumEntries&lt;ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

####### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason.valueOf

fun valueOf(value: String): ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

####### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason.values

fun values(): Array&lt;ReaderInfo.Status.ReaderUnavailable.ReaderUnavailableReason&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

##### com.squareup.sdk.mobilepayments.cardreader.ReaderInfo.Status.Ready

data object Ready : ReaderInfo.Status

This reader is ready to take payments.

### com.squareup.sdk.mobilepayments.cardreader.ReaderManager

interface ReaderManager

Tracks changes to the set of available readers and their state; provides pairing and removal capabilities for card readers.

#### Types

| Name | Summary |
|---|---|
| Companion | object Companion<br>Constants for the ReaderManager. |

#### Properties

| Name | Summary |
|---|---|
| isPairingInProgress | abstract val isPairingInProgress: Boolean<br>Returns `true` if a Reader pairing is in progress, `false` otherwise. |
| readerSettings | abstract val readerSettings: ReaderSettings<br>Returns ReaderSettings, including firmware update preferences. |
| tapToPaySettings | abstract val tapToPaySettings: TapToPaySettings<br>Returns TapToPaySettings that provides information about Tap to Pay on this device. |

#### Functions

| Name | Summary |
|---|---|
| blink | abstract fun blink(reader: ReaderInfo)<br>Flashes LEDs on this reader to assist in identifying it. |
| forget | abstract fun forget(reader: ReaderInfo)<br>Disconnects from the given ReaderInfo and "forgets" about it for future execution, returning it to a state before the reader was paired. |
| getReader | abstract fun getReader(id: String): ReaderInfo?<br>Gets a specific ReaderInfo by its id. Returns `null` if no such reader is found. |
| getReaders | abstract fun getReaders(): List&lt;ReaderInfo&gt;<br>Gets a snapshot of the current state of all known readers. The returned objects will *not* reflect changes to the readers' state after this method is called. |
| pairReader | abstract fun pairReader(callback: Callback&lt;PairingResult&gt;): PairingHandle<br>Begins scanning for a new Bluetooth reader. The scan will terminate after a timeout, or after one new reader is identified, whether that reader is paired successfully or not. |
| retryConnection | abstract fun retryConnection(reader: ReaderInfo): RetryConnectionResult<br>Attempts to retry the connection with Square's servers. |
| setReaderChangedCallback | abstract fun setReaderChangedCallback(callback: Callback&lt;ReaderChangedEvent&gt;): CallbackReference<br>Registers a callback to be called when a reader changes state. The supplied Callback will be called on the application UI thread at various perhaps-interesting moments, including when readers are discovered or lost, when cards are inserted or removed, etc. When ReaderChangedEvent.change is ReaderChangedEvent.Change.WARNING_RAISED, inspect ReaderChangedEvent.reader and its ReaderInfo.warnings promptly because warning history is cleared when the reader disconnects. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.blink

abstract fun blink(reader: ReaderInfo)

Flashes LEDs on this reader to assist in identifying it.

##### Parameters

| | |
|---|---|
| reader | the reader to cause to blink. |

##### Throws

| | |
|---|---|
| UnsupportedOperationException | if this reader does not have a way of being identified. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.forget

abstract fun forget(reader: ReaderInfo)

Disconnects from the given ReaderInfo and "forgets" about it for future execution, returning it to a state before the reader was paired.

##### Parameters

| | |
|---|---|
| reader | the reader to forget about. |

##### Throws

| | |
|---|---|
| UnsupportedOperationException | if this reader cannot be unpaired, for example a magstripe reader. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.getReader

abstract fun getReader(id: String): ReaderInfo?

Gets a specific ReaderInfo by its id. Returns `null` if no such reader is found.

##### Parameters

| | |
|---|---|
| id | the identifier of the reader to get. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.getReaders

abstract fun getReaders(): List&lt;ReaderInfo&gt;

Gets a snapshot of the current state of all known readers. The returned objects will *not* reflect changes to the readers' state after this method is called.

##### Return

a list of the momentary status of all known readers.

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.isPairingInProgress

abstract val isPairingInProgress: Boolean

Returns `true` if a Reader pairing is in progress, `false` otherwise.

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.pairReader

abstract fun pairReader(callback: Callback&lt;PairingResult&gt;): PairingHandle

Begins scanning for a new Bluetooth reader. The scan will terminate after a timeout, or after one new reader is identified, whether that reader is paired successfully or not.

See setReaderChangedCallback to receive notification about newly discovered readers, as well as about other changes to reader state and availability. See isPairingInProgress to check if it returns `false` before calling pairReader; doing otherwise might result in error.

It is invalid to attempt to pair a reader while still attempting to pair from a previous call. The original pairing attempt will continue unaffected but the second call will immediately trigger the pairing callback with PairingErrorCode.USAGE_ERROR. When the first pairing effort completes the callbacks will be made again, with the status of that perhaps-successful attempt.

##### Return

a PairingHandle which can be used for interaction with the just started reader pairing (e.g. canceling it)

##### Parameters

| | |
|---|---|
| callback | to be called when pairing completes. This callback is called once per call to pairReader, run on the application UI thread, and contains the result of that pairing: reader discovered, timeout, cancellation, or whatever error condition was found.<br>If pairing completes successfully, the Callback's success value is a boolean for whether a card reader paired or not. If `true`, a card reader was found, reported to the callback provided via setReaderChangedCallback, and added to the list of readers accessed via ReaderManager.getReaders. A successful result with `false` indicates a canceled pairing attempt. In case of failure, error description would contain a PairingErrorCode. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.readerSettings

abstract val readerSettings: ReaderSettings

Returns ReaderSettings, including firmware update preferences.

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.retryConnection

abstract fun retryConnection(reader: ReaderInfo): RetryConnectionResult

Attempts to retry the connection with Square's servers.

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.setReaderChangedCallback

abstract fun setReaderChangedCallback(callback: Callback&lt;ReaderChangedEvent&gt;): CallbackReference

Registers a callback to be called when a reader changes state. The supplied Callback will be called on the application UI thread at various perhaps-interesting moments, including when readers are discovered or lost, when cards are inserted or removed, etc. When ReaderChangedEvent.change is ReaderChangedEvent.Change.WARNING_RAISED, inspect ReaderChangedEvent.reader and its ReaderInfo.warnings promptly because warning history is cleared when the reader disconnects.

##### Return

a CallbackReference handle to remove the callback later.

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.tapToPaySettings

abstract val tapToPaySettings: TapToPaySettings

Returns TapToPaySettings that provides information about Tap to Pay on this device.

#### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.Companion

object Companion

Constants for the ReaderManager.

##### Properties

| Name | Summary |
|---|---|
| PAIRING_TIMEOUT_MILLIS | const val PAIRING_TIMEOUT_MILLIS: Int = 60000<br>Timeout duration for the pairReader operation, in milliseconds. |

##### com.squareup.sdk.mobilepayments.cardreader.ReaderManager.Companion.PAIRING_TIMEOUT_MILLIS

const val PAIRING_TIMEOUT_MILLIS: Int = 60000

Timeout duration for the pairReader operation, in milliseconds.

### com.squareup.sdk.mobilepayments.cardreader.ReaderSettings

interface ReaderSettings

Represents reader settings that apply to all readers.

#### Properties

| Name | Summary |
|---|---|
| isReducedChargingModeEnabled | abstract var isReducedChargingModeEnabled: Boolean<br>Whether reduced charging mode is enabled. When enabled, the reader will limit its charging to extend overall battery lifespan. |
| preferredFirmwareUpdateTime | abstract var preferredFirmwareUpdateTime: TimeOfDay?<br>The preferred time of day for firmware updates, represented as TimeOfDay. Setting this value allows scheduling firmware updates at a time that is least disruptive to the seller. A `null` value indicates no preference has been set. |

#### com.squareup.sdk.mobilepayments.cardreader.ReaderSettings.isReducedChargingModeEnabled

abstract var isReducedChargingModeEnabled: Boolean

Whether reduced charging mode is enabled. When enabled, the reader will limit its charging to extend overall battery lifespan.

#### com.squareup.sdk.mobilepayments.cardreader.ReaderSettings.preferredFirmwareUpdateTime

abstract var preferredFirmwareUpdateTime: TimeOfDay?

The preferred time of day for firmware updates, represented as TimeOfDay. Setting this value allows scheduling firmware updates at a time that is least disruptive to the seller. A `null` value indicates no preference has been set.

### com.squareup.sdk.mobilepayments.cardreader.RetryConnectionResult

enum RetryConnectionResult : Enum&lt;RetryConnectionResult&gt; 

Result of attempting to retry a connection to a card reader.

#### Entries

| | |
|---|---|
| STARTING_RECONNECTION | STARTING_RECONNECTION<br>Successfully initiated the reconnection process. |
| UNABLE_TO_RETRY | UNABLE_TO_RETRY<br>The reader's current state does not allow retrying the connection. This may be because the reader has an unrecoverable status (e.g. faulty hardware, non-retryable failure), or because the reader is not yet in a state where a retry is applicable (e.g. still connecting to the device). The developer may try again later or unpair and re-pair the reader. |
| READER_ALREADY_CONNECTING_TO_SQUARE | READER_ALREADY_CONNECTING_TO_SQUARE<br>The reader is already connecting to Square and cannot retry at this time. |
| READER_NOT_FOUND | READER_NOT_FOUND<br>The reader was not found. |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;RetryConnectionResult&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): RetryConnectionResult<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;RetryConnectionResult&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.cardreader.RetryConnectionResult.entries

val entries: EnumEntries&lt;RetryConnectionResult&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.cardreader.RetryConnectionResult.valueOf

fun valueOf(value: String): RetryConnectionResult

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.cardreader.RetryConnectionResult.values

fun values(): Array&lt;RetryConnectionResult&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.cardreader.TapToPaySettings

interface TapToPaySettings

#### Functions

| Name | Summary |
|---|---|
| isDeviceCapable | abstract fun isDeviceCapable(): Boolean<br>Does this device support Tap to Pay? In order to accept Tap to Pay on this device, the device must have: OS version 9 or higher Keymaster version 4 or higher NFC antenna available. |

#### com.squareup.sdk.mobilepayments.cardreader.TapToPaySettings.isDeviceCapable

abstract fun isDeviceCapable(): Boolean

Does this device support Tap to Pay? In order to accept Tap to Pay on this device, the device must have: OS version 9 or higher Keymaster version 4 or higher NFC antenna available.

Additionally, the device must not be rooted, and must have developer options turned off.

## com.squareup.sdk.mobilepayments.core

Core classes used by all the SDK components.

### com.squareup.sdk.mobilepayments.core.Callback

fun interface Callback&lt;R&gt;

Communicates the result of an asynchronous operation. onResult will be invoked exactly once per operation on the application's main (UI) thread.

#### Functions

| Name | Summary |
|---|---|
| onResult | abstract fun onResult(result: R)<br>Called when operation completes with the resulting object R. |

#### com.squareup.sdk.mobilepayments.core.Callback.onResult

abstract fun onResult(result: R)

Called when operation completes with the resulting object R.

### com.squareup.sdk.mobilepayments.core.CallbackReference

fun interface CallbackReference

A reference to a Mobile Payments SDK Callback that can be cleared to prevent memory leaks. It is recommended to clear the reference any time a lifecycle destroy event occurs (e.g. android.app.Activity.onDestroy or `ViewModel.onCleared()`). It can also be cleared when the Callback is no longer needed and should not be invoked.

#### Functions

| Name | Summary |
|---|---|
| clear | abstract fun clear()<br>Clears the reference to a Mobile Payments SDK Callback. After this method is called, the Callback will no longer be invoked. |

#### com.squareup.sdk.mobilepayments.core.CallbackReference.clear

abstract fun clear()

Clears the reference to a Mobile Payments SDK Callback. After this method is called, the Callback will no longer be invoked.

### com.squareup.sdk.mobilepayments.core.ErrorCode

interface ErrorCode

Implemented by error code enums that are returned as a result of Mobile Payments SDK operations.

#### Inheritors

| |
|---|
| AuthorizeErrorCode |
| PairingErrorCode |
| PaymentErrorCode |
| SettingsErrorCode |

#### Properties

| Name | Summary |
|---|---|
| isUsageError | abstract val isUsageError: Boolean<br>Returns `true` if the error is a usage error, `false` otherwise. |
| name | abstract val name: String<br>Returns the name of the error code. |

#### com.squareup.sdk.mobilepayments.core.ErrorCode.isUsageError

abstract val isUsageError: Boolean

Returns `true` if the error is a usage error, `false` otherwise.

Useful for writing shared handling of debug codes and messages across Mobile Payments SDK operations.

#### com.squareup.sdk.mobilepayments.core.ErrorCode.name

abstract val name: String

Returns the name of the error code.

### com.squareup.sdk.mobilepayments.core.ErrorDetails

class ErrorDetails(val category: String, val code: String, val detail: String, val field: String? = null)

Detailed errors to explain a failure. Typically these are returned from Square's Connect v2 REST APIs, and are documented [here](https://developer.squareup.com/reference/square/objects/Error). However, there may be conditions where an error is generated by the SDK itself, for example to explain errors that prevented server or cardreader communication.

#### Constructors

| | |
|---|---|
| ErrorDetails | constructor(category: String, code: String, detail: String, field: String? = null) |

#### Properties

| Name | Summary |
|---|---|
| category | val category: String<br>The high-level category of the error. |
| code | val code: String<br>The specific code of the error. |
| detail | val detail: String<br>A human-readable description of the error for debugging purposes. This will be localized to the device locale. |
| field | val field: String?<br>The name of the field provided in the original request, if any, that the error pertains to. |

#### com.squareup.sdk.mobilepayments.core.ErrorDetails.category

val category: String

The high-level category of the error.

#### com.squareup.sdk.mobilepayments.core.ErrorDetails.code

val code: String

The specific code of the error.

#### com.squareup.sdk.mobilepayments.core.ErrorDetails.detail

val detail: String

A human-readable description of the error for debugging purposes. This will be localized to the device locale.

#### com.squareup.sdk.mobilepayments.core.ErrorDetails.field

val field: String?

The name of the field provided in the original request, if any, that the error pertains to.

### com.squareup.sdk.mobilepayments.core.Result

sealed class Result&lt;S, C&gt;

The result of an asynchronous operation.

- If operation was successful the result will be represented as Success with value as a payload.
- If operation failed, result will be a Failure with the payload describing the failure.

Note that for idiomatic Kotlin you can use `when` expression to safely access value or errorCode and other methods like this:

```kotlin
when (result) {
  is Success -> println(result.value)
  is Failure ->
     println("${result.errorCode}: ${result.errorMessage}. Debug code: ${result.debugCode}")
}
```

From Java you can use one of helper methods: isSuccess() or isFailure() to define what kind of result you are dealing with. After that you can safely call value() or errorCode() to access the payload.

```kotlin
if (result.isSuccess()) {
  println(result.value())
} else if (result.isFailure()) {
  println(result.errorCode() + ": " + result.errorMessage() + ". Debug code: " + result.debugCode())
}
```

**Note:** an attempt to access failure payload on a success result or vice-versa will throw an IllegalStateException.

#### Parameters

| | |
|---|---|
| S | The success value if the operation was successful. |
| C | Error code type in the payload that provides insight about the failure. |

#### Inheritors

| |
|---|
| Success |
| Failure |

#### Types

| Name | Summary |
|---|---|
| Failure | class Failure&lt;S, C&gt;(val errorCode: C, val errorMessage: String, val details: List&lt;ErrorDetails&gt; = emptyList(), val debugCode: String, val debugMessage: String) : Result&lt;S, C&gt; <br>Failed operation result, containing detailed description of the cause. |
| Success | class Success&lt;S, C&gt;(val value: S) : Result&lt;S, C&gt; <br>Successful operation result, containing resulting object. |

#### Functions

| Name | Summary |
|---|---|
| debugCode | fun debugCode(): String<br>More detailed "debug" error code for troubleshooting the failure |
| debugMessage | fun debugMessage(): String<br>Human-readable message containing additional debug information related to the possible cause of the failure. |
| details | fun details(): List&lt;ErrorDetails&gt;<br>More detailed descriptions of the error(s) causing the failure, if available. In many cases these are the actual errors returned from a server call. It is possible for a failure to happen without more detail that provided by the other fields, and this will be an empty list in such cases. (For example, error code NOT_AUTHORIZED has no additional details, the developer simply needs to call AuthorizationManager.authorize() before using the failing Mobile Payments SDK method). |
| errorCode | fun errorCode(): C<br>Error code of an unsuccessful operation |
| errorMessage | fun errorMessage(): String<br>Displayable message that summarizes the possible cause of the failure. |
| isFailure | fun isFailure(): Boolean<br>`true` if the operation resulted in a failure. For details see errorCode, errorMessage, debugCode and debugMessage. |
| isSuccess | fun isSuccess(): Boolean<br>`true` if the operation was successful. See value for the result. |
| value | fun value(): S<br>Result of a successful operation. |

#### com.squareup.sdk.mobilepayments.core.Result.debugCode

fun debugCode(): String

More detailed "debug" error code for troubleshooting the failure

##### Throws

| | |
|---|---|
| IllegalStateException | if isFailure is `false`. |

#### com.squareup.sdk.mobilepayments.core.Result.debugMessage

fun debugMessage(): String

Human-readable message containing additional debug information related to the possible cause of the failure.

##### Throws

| | |
|---|---|
| IllegalStateException | if isFailure is `false`. |

#### com.squareup.sdk.mobilepayments.core.Result.details

fun details(): List&lt;ErrorDetails&gt;

More detailed descriptions of the error(s) causing the failure, if available. In many cases these are the actual errors returned from a server call. It is possible for a failure to happen without more detail that provided by the other fields, and this will be an empty list in such cases. (For example, error code NOT_AUTHORIZED has no additional details, the developer simply needs to call AuthorizationManager.authorize() before using the failing Mobile Payments SDK method).

##### Throws

| | |
|---|---|
| IllegalStateException | if isFailure is `false`. |

#### com.squareup.sdk.mobilepayments.core.Result.errorCode

fun errorCode(): C

Error code of an unsuccessful operation

##### Throws

| | |
|---|---|
| IllegalStateException | if isFailure is `false`. |

#### com.squareup.sdk.mobilepayments.core.Result.errorMessage

fun errorMessage(): String

Displayable message that summarizes the possible cause of the failure.

##### Throws

| | |
|---|---|
| IllegalStateException | if isFailure is `false`. |

#### com.squareup.sdk.mobilepayments.core.Result.isFailure

fun isFailure(): Boolean

`true` if the operation resulted in a failure. For details see errorCode, errorMessage, debugCode and debugMessage.

#### com.squareup.sdk.mobilepayments.core.Result.isSuccess

fun isSuccess(): Boolean

`true` if the operation was successful. See value for the result.

#### com.squareup.sdk.mobilepayments.core.Result.value

fun value(): S

Result of a successful operation.

##### Throws

| | |
|---|---|
| IllegalStateException | if isSuccess is `false`. |

#### com.squareup.sdk.mobilepayments.core.Result.Failure

class Failure&lt;S, C&gt;(val errorCode: C, val errorMessage: String, val details: List&lt;ErrorDetails&gt; = emptyList(), val debugCode: String, val debugMessage: String) : Result&lt;S, C&gt; 

Failed operation result, containing detailed description of the cause.

##### Parameters

| | |
|---|---|
| errorCode | Error code of an unsuccessful operation. Use this error code to appropriately handle the failure. |
| errorMessage | Error message with the cause of failure intended for end users. |
| details | More detailed descriptions of the error(s) causing the failure, if available. In many cases these are the actual errors returned from a server call. It is possible for a failure to happen without more detail that provided by the other fields, and this will be an empty list in such cases. (For example, error code NOT_AUTHORIZED has no additional details, the developer simply needs to call AuthorizationManager.authorize() before using the failing Mobile Payments SDK method). |
| debugCode | More detailed "debug" error code for troubleshooting the failure. Intended for developers only. |
| debugMessage | More detailed error message containing additional debug information related to the possible cause of the failure. Intended for developers only. |

##### Constructors

| | |
|---|---|
| Failure | constructor(errorCode: C, errorMessage: String, details: List&lt;ErrorDetails&gt; = emptyList(), debugCode: String, debugMessage: String) |

##### Properties

| Name | Summary |
|---|---|
| debugCode | val debugCode: String |
| debugMessage | val debugMessage: String |
| details | val details: List&lt;ErrorDetails&gt; |
| errorCode | val errorCode: C |
| errorMessage | val errorMessage: String |

##### Functions

| Name | Summary |
|---|---|
| debugCode | fun debugCode(): String<br>More detailed "debug" error code for troubleshooting the failure |
| debugMessage | fun debugMessage(): String<br>Human-readable message containing additional debug information related to the possible cause of the failure. |
| details | fun details(): List&lt;ErrorDetails&gt;<br>More detailed descriptions of the error(s) causing the failure, if available. In many cases these are the actual errors returned from a server call. It is possible for a failure to happen without more detail that provided by the other fields, and this will be an empty list in such cases. (For example, error code NOT_AUTHORIZED has no additional details, the developer simply needs to call AuthorizationManager.authorize() before using the failing Mobile Payments SDK method). |
| errorCode | fun errorCode(): C<br>Error code of an unsuccessful operation |
| errorMessage | fun errorMessage(): String<br>Displayable message that summarizes the possible cause of the failure. |
| isFailure | fun isFailure(): Boolean<br>`true` if the operation resulted in a failure. For details see errorCode, errorMessage, debugCode and debugMessage. |
| isSuccess | fun isSuccess(): Boolean<br>`true` if the operation was successful. See value for the result. |
| value | fun value(): S<br>Result of a successful operation. |

##### com.squareup.sdk.mobilepayments.core.Result.Failure.debugCode

val debugCode: String

###### Parameters

| | |
|---|---|
| debugCode | More detailed "debug" error code for troubleshooting the failure. Intended for developers only. |

##### com.squareup.sdk.mobilepayments.core.Result.Failure.debugMessage

val debugMessage: String

###### Parameters

| | |
|---|---|
| debugMessage | More detailed error message containing additional debug information related to the possible cause of the failure. Intended for developers only. |

##### com.squareup.sdk.mobilepayments.core.Result.Failure.details

val details: List&lt;ErrorDetails&gt;

###### Parameters

| | |
|---|---|
| details | More detailed descriptions of the error(s) causing the failure, if available. In many cases these are the actual errors returned from a server call. It is possible for a failure to happen without more detail that provided by the other fields, and this will be an empty list in such cases. (For example, error code NOT_AUTHORIZED has no additional details, the developer simply needs to call AuthorizationManager.authorize() before using the failing Mobile Payments SDK method). |

##### com.squareup.sdk.mobilepayments.core.Result.Failure.errorCode

val errorCode: C

###### Parameters

| | |
|---|---|
| errorCode | Error code of an unsuccessful operation. Use this error code to appropriately handle the failure. |

##### com.squareup.sdk.mobilepayments.core.Result.Failure.errorMessage

val errorMessage: String

###### Parameters

| | |
|---|---|
| errorMessage | Error message with the cause of failure intended for end users. |

#### com.squareup.sdk.mobilepayments.core.Result.Success

class Success&lt;S, C&gt;(val value: S) : Result&lt;S, C&gt; 

Successful operation result, containing resulting object.

##### Parameters

| | |
|---|---|
| value | Result of successful operation. |

##### Constructors

| | |
|---|---|
| Success | constructor(value: S) |

##### Properties

| Name | Summary |
|---|---|
| value | val value: S |

##### Functions

| Name | Summary |
|---|---|
| debugCode | fun debugCode(): String<br>More detailed "debug" error code for troubleshooting the failure |
| debugMessage | fun debugMessage(): String<br>Human-readable message containing additional debug information related to the possible cause of the failure. |
| details | fun details(): List&lt;ErrorDetails&gt;<br>More detailed descriptions of the error(s) causing the failure, if available. In many cases these are the actual errors returned from a server call. It is possible for a failure to happen without more detail that provided by the other fields, and this will be an empty list in such cases. (For example, error code NOT_AUTHORIZED has no additional details, the developer simply needs to call AuthorizationManager.authorize() before using the failing Mobile Payments SDK method). |
| errorCode | fun errorCode(): C<br>Error code of an unsuccessful operation |
| errorMessage | fun errorMessage(): String<br>Displayable message that summarizes the possible cause of the failure. |
| isFailure | fun isFailure(): Boolean<br>`true` if the operation resulted in a failure. For details see errorCode, errorMessage, debugCode and debugMessage. |
| isSuccess | fun isSuccess(): Boolean<br>`true` if the operation was successful. See value for the result. |
| value | fun value(): S<br>Result of a successful operation. |

##### com.squareup.sdk.mobilepayments.core.Result.Success.value

val value: S

###### Parameters

| | |
|---|---|
| value | Result of successful operation. |

### com.squareup.sdk.mobilepayments.core.TimeOfDay

data class TimeOfDay(val hour: Int, val minute: Int)

Represents a time of day with hour and minute components.

#### Constructors

| | |
|---|---|
| TimeOfDay | constructor(hour: Int, minute: Int) |

#### Properties

| Name | Summary |
|---|---|
| hour | val hour: Int<br>The hour component of the time, in 24-hour format (0-23). |
| minute | val minute: Int<br>The minute component of the time (0-59). |

## com.squareup.sdk.mobilepayments.extensions

Helpers for Kotlin idiomatic code.

### com.squareup.sdk.mobilepayments.extensions.AuthorizeResult

typealias AuthorizeResult = Result&lt;AuthorizedLocation, AuthorizeErrorCode&gt;

Type Alias for Authorization Result, used by AuthorizationManager.authorize.

### com.squareup.sdk.mobilepayments.extensions.GetAllIdempotencyKeysResult

typealias GetAllIdempotencyKeysResult = Result&lt;List&lt;PaymentManager.IdempotencyKeyData&gt;, PaymentErrorCode&gt;

Type Alias for the Result of PaymentManager.getAllIdempotencyKeys.

### com.squareup.sdk.mobilepayments.extensions.GetIdempotencyKeyResult

typealias GetIdempotencyKeyResult = Result&lt;String?, PaymentErrorCode&gt;

Type Alias for the Result of PaymentManager.getIdempotencyKey.

### com.squareup.sdk.mobilepayments.extensions.GetOfflinePaymentsResult

typealias GetOfflinePaymentsResult = Result&lt;List&lt;Payment.OfflinePayment&gt;, PaymentErrorCode&gt;

Type Alias for the Result of OfflinePaymentQueue.getPayments.

### com.squareup.sdk.mobilepayments.extensions.GetTotalStoredPaymentAmountResult

typealias GetTotalStoredPaymentAmountResult = Result&lt;Money, PaymentErrorCode&gt;

Type Alias for the Result of OfflinePaymentQueue.getTotalStoredPaymentAmount.

### com.squareup.sdk.mobilepayments.extensions.PairingResult

typealias PairingResult = Result&lt;Boolean, PairingErrorCode&gt;

Type Alias for Pairing Result, used by ReaderManager.pairReader.

### com.squareup.sdk.mobilepayments.extensions.PaymentResult

typealias PaymentResult = Result&lt;Payment, PaymentErrorCode&gt;

Type Alias for Payment Result, used by PaymentManager.startPaymentActivity.

### com.squareup.sdk.mobilepayments.extensions.SettingsResult

typealias SettingsResult = Result&lt;SettingsClosed, SettingsErrorCode&gt;

Type Alias for the Result of SettingsManager.showSettings.

## com.squareup.sdk.mobilepayments.payment

Classes to collect payments.

### com.squareup.sdk.mobilepayments.payment.AdditionalPaymentMethod

sealed class AdditionalPaymentMethod

A description of a payment method that is not via a card reader.

#### Inheritors

| |
|---|
| KeyedMethod |
| CashMethod |

#### Types

| Name | Summary |
|---|---|
| CashMethod | class CashMethod(label: Int, val trigger: () -&gt; Unit) : AdditionalPaymentMethod<br>Records a physical currency cash payment. This method records a payment that happened outside of Square's payment processing, in this case for cash tendered to the merchant. |
| Companion | object Companion<br>A list of all additional payment methods. |
| KeyedMethod | class KeyedMethod(label: Int, val trigger: () -&gt; Unit) : AdditionalPaymentMethod<br>A payment method requiring manual entry, for example of the PAN, expiration, CVV, and postcode for a credit card. Use of one of these methods will present the buyer with a form to fill out. |
| Type | enum Type : Enum&lt;AdditionalPaymentMethod.Type&gt; |

#### Properties

| Name | Summary |
|---|---|
| label | val label: Int<br>the resource id for the label of this method, suitable for display to users |
| type | val type: AdditionalPaymentMethod.Type<br>an identification of the method, suitable for programmatic comparison. |

#### com.squareup.sdk.mobilepayments.payment.AdditionalPaymentMethod.CashMethod

class CashMethod(label: Int, val trigger: () -&gt; Unit) : AdditionalPaymentMethod

Records a physical currency cash payment. This method records a payment that happened outside of Square's payment processing, in this case for cash tendered to the merchant.

The trigger method presents a UI to collect the amount of cash provided by the buyer.

##### Constructors

| | |
|---|---|
| CashMethod | constructor(label: Int, trigger: () -&gt; Unit) |

##### Properties

| Name | Summary |
|---|---|
| label | val label: Int<br>the resource id for the label of this method, suitable for display to users |
| trigger | val trigger: () -&gt; Unit |
| type | val type: AdditionalPaymentMethod.Type<br>an identification of the method, suitable for programmatic comparison. |

#### com.squareup.sdk.mobilepayments.payment.AdditionalPaymentMethod.Companion

object Companion

A list of all additional payment methods.

##### Properties

| Name | Summary |
|---|---|
| allPaymentMethods | val allPaymentMethods: List&lt;AdditionalPaymentMethod.Type&gt; |

#### com.squareup.sdk.mobilepayments.payment.AdditionalPaymentMethod.KeyedMethod

class KeyedMethod(label: Int, val trigger: () -&gt; Unit) : AdditionalPaymentMethod

A payment method requiring manual entry, for example of the PAN, expiration, CVV, and postcode for a credit card. Use of one of these methods will present the buyer with a form to fill out.

##### Constructors

| | |
|---|---|
| KeyedMethod | constructor(label: Int, trigger: () -&gt; Unit) |

##### Properties

| Name | Summary |
|---|---|
| label | val label: Int<br>the resource id for the label of this method, suitable for display to users |
| trigger | val trigger: () -&gt; Unit |
| type | val type: AdditionalPaymentMethod.Type<br>an identification of the method, suitable for programmatic comparison. |

#### com.squareup.sdk.mobilepayments.payment.AdditionalPaymentMethod.Type

enum Type : Enum&lt;AdditionalPaymentMethod.Type&gt;

##### Entries

| | |
|---|---|
| KEYED | KEYED |
| CASH | CASH |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;AdditionalPaymentMethod.Type&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): AdditionalPaymentMethod.Type<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;AdditionalPaymentMethod.Type&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.AdditionalPaymentMethod.Type.entries

val entries: EnumEntries&lt;AdditionalPaymentMethod.Type&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.AdditionalPaymentMethod.Type.valueOf

fun valueOf(value: String): AdditionalPaymentMethod.Type

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.AdditionalPaymentMethod.Type.values

fun values(): Array&lt;AdditionalPaymentMethod.Type&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.Card

class Card : Parcelable

Information about the card used in a purchase.

#### Parameters

| | |
|---|---|
| brand | The brand (for example, VISA or Mastercard) of a Card. |
| cardCoBrand | The co-brand (for example, an Afterpay virtual card would have a co-brand of AFTERPAY.) of a Card. |
| lastFourDigits | The last 4 digits of this card's number. |
| expirationMonth | The month of the expiration date of the card. This must be in range of 1-12 |
| expirationYear | The year of the expiration date of the card, 4 digits. |
| cardholderName | The cardholder's full name, if available. |
| id | The card identifier, if this card instance came from storing a card on file. |
| bin | The first six digits of the card number. |

#### Types

| Name | Summary |
|---|---|
| Brand | enum Brand : Enum&lt;Card.Brand&gt; <br>Card brand (e.g. Mastercard, VISA, etc). |
| Builder | class Builder(brand: Card.Brand, lastFourDigits: String)<br>Lets developers create and configure card data for automated testing. There is no need to reference this builder class outside of tests. |
| CoBrand | enum CoBrand : Enum&lt;Card.CoBrand&gt; <br>The card's co-brand if available. For example, an Afterpay virtual card would have a co-brand of AFTERPAY. |

#### Properties

| Name | Summary |
|---|---|
| bin | val bin: String? |
| brand | val brand: Card.Brand |
| cardCoBrand | val cardCoBrand: Card.CoBrand |
| cardholderName | val cardholderName: String? |
| expirationMonth | val expirationMonth: Int |
| expirationYear | val expirationYear: Int |
| id | val id: String? |
| lastFourDigits | val lastFourDigits: String |

#### Functions

| Name | Summary |
|---|---|
| buildUpon | fun buildUpon(): Card.Builder |
| describeContents | abstract fun describeContents(): Int |
| toString | open override fun toString(): String<br>Simply print "Card" because we don't want to accidentally log or otherwise leak card data. |
| writeToParcel | abstract fun writeToParcel(p0: Parcel, p1: Int) |

#### com.squareup.sdk.mobilepayments.payment.Card.bin

val bin: String?

##### Parameters

| | |
|---|---|
| bin | The first six digits of the card number. |

#### com.squareup.sdk.mobilepayments.payment.Card.brand

val brand: Card.Brand

##### Parameters

| | |
|---|---|
| brand | The brand (for example, VISA or Mastercard) of a Card. |

#### com.squareup.sdk.mobilepayments.payment.Card.cardCoBrand

val cardCoBrand: Card.CoBrand

##### Parameters

| | |
|---|---|
| cardCoBrand | The co-brand (for example, an Afterpay virtual card would have a co-brand of AFTERPAY.) of a Card. |

#### com.squareup.sdk.mobilepayments.payment.Card.cardholderName

val cardholderName: String?

##### Parameters

| | |
|---|---|
| cardholderName | The cardholder's full name, if available. |

#### com.squareup.sdk.mobilepayments.payment.Card.expirationMonth

val expirationMonth: Int

##### Parameters

| | |
|---|---|
| expirationMonth | The month of the expiration date of the card. This must be in range of 1-12 |

#### com.squareup.sdk.mobilepayments.payment.Card.expirationYear

val expirationYear: Int

##### Parameters

| | |
|---|---|
| expirationYear | The year of the expiration date of the card, 4 digits. |

#### com.squareup.sdk.mobilepayments.payment.Card.id

val id: String?

##### Parameters

| | |
|---|---|
| id | The card identifier, if this card instance came from storing a card on file. |

#### com.squareup.sdk.mobilepayments.payment.Card.lastFourDigits

val lastFourDigits: String

##### Parameters

| | |
|---|---|
| lastFourDigits | The last 4 digits of this card's number. |

#### com.squareup.sdk.mobilepayments.payment.Card.toString

open override fun toString(): String

Simply print "Card" because we don't want to accidentally log or otherwise leak card data.

#### com.squareup.sdk.mobilepayments.payment.Card.Brand

enum Brand : Enum&lt;Card.Brand&gt; 

Card brand (e.g. Mastercard, VISA, etc).

##### Entries

| | |
|---|---|
| OTHER_BRAND | OTHER_BRAND |
| VISA | VISA |
| MASTERCARD | MASTERCARD |
| AMERICAN_EXPRESS | AMERICAN_EXPRESS |
| DISCOVER | DISCOVER |
| DISCOVER_DINERS | DISCOVER_DINERS |
| EBT | EBT |
| JCB | JCB |
| CHINA_UNIONPAY | CHINA_UNIONPAY |
| SQUARE_GIFT_CARD | SQUARE_GIFT_CARD |
| EFTPOS | EFTPOS |
| FELICA | FELICA |
| INTERAC | INTERAC |
| SQUARE_CAPITAL_CARD | SQUARE_CAPITAL_CARD |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;Card.Brand&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): Card.Brand<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;Card.Brand&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.Card.Brand.entries

val entries: EnumEntries&lt;Card.Brand&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.Card.Brand.valueOf

fun valueOf(value: String): Card.Brand

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.Card.Brand.values

fun values(): Array&lt;Card.Brand&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

#### com.squareup.sdk.mobilepayments.payment.Card.Builder

class Builder(brand: Card.Brand, lastFourDigits: String)

Lets developers create and configure card data for automated testing. There is no need to reference this builder class outside of tests.

##### Return

A new Card builder instance.

##### Constructors

| | |
|---|---|
| Builder | constructor(brand: Card.Brand, lastFourDigits: String) |

##### Functions

| Name | Summary |
|---|---|
| bin | fun bin(bin: String): Card.Builder |
| brand | fun brand(brand: Card.Brand): Card.Builder |
| build | fun build(): Card |
| cardholderName | fun cardholderName(name: String): Card.Builder |
| coBrand | fun coBrand(coBrand: Card.CoBrand): Card.Builder |
| expirationMonth | fun expirationMonth(month: Int): Card.Builder |
| expirationYear | fun expirationYear(year: Int): Card.Builder |
| id | fun id(id: String): Card.Builder |
| last4Digits | fun last4Digits(last4Digits: String): Card.Builder |

#### com.squareup.sdk.mobilepayments.payment.Card.CoBrand

enum CoBrand : Enum&lt;Card.CoBrand&gt; 

The card's co-brand if available. For example, an Afterpay virtual card would have a co-brand of AFTERPAY.

##### Entries

| | |
|---|---|
| AFTERPAY | AFTERPAY<br>AFTERPAY is AfterPay's name in non-European markets. |
| CLEARPAY | CLEARPAY<br>CLEARPAY is AfterPay's name in European markets, after a trademark dispute. |
| NONE | NONE<br>NONE is used when v2/payments doesn't report any co-brand, which is the most common case. |
| UNKNOWN | UNKNOWN<br>UNKNOWN is used when v2/payments reports UNKNOWN... there *is* a co-brand, but Square doesn't recognize it. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;Card.CoBrand&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): Card.CoBrand<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;Card.CoBrand&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.Card.CoBrand.entries

val entries: EnumEntries&lt;Card.CoBrand&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.Card.CoBrand.valueOf

fun valueOf(value: String): Card.CoBrand

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.Card.CoBrand.values

fun values(): Array&lt;Card.CoBrand&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails

sealed class CardPaymentDetails

Details about a successful card payment.

#### Inheritors

| |
|---|
| OnlineCardPaymentDetails |
| OfflineCardPaymentDetails |

#### Types

| Name | Summary |
|---|---|
| CardSurchargeDetails | data class CardSurchargeDetails(val cardSurchargeMoney: Money, val taxOnSurchargeMoney: Money?)<br>Details of a card surcharge applied to a payment. |
| EntryMethod | enum EntryMethod : Enum&lt;CardPaymentDetails.EntryMethod&gt; <br>The entry method used to provide a card's details. |
| OfflineCardPaymentDetails | class OfflineCardPaymentDetails(val card: Card, val entryMethod: CardPaymentDetails.EntryMethod, val applicationId: String?, val applicationName: String?) : CardPaymentDetails<br>Details about a successful offline card payment. |
| OnlineCardPaymentDetails | class OnlineCardPaymentDetails : CardPaymentDetails<br>Details about a successful card payment. |
| Status | enum Status : Enum&lt;CardPaymentDetails.Status&gt; <br>Status of the card payment |
| VerificationMethod | enum VerificationMethod : Enum&lt;CardPaymentDetails.VerificationMethod&gt; <br>For EMV payments, the method used to verify the cardholder's identity. |
| VerificationResult | enum VerificationResult : Enum&lt;CardPaymentDetails.VerificationResult&gt; <br>For EMV payments, the results of the cardholder verification. |

#### Properties

| Name | Summary |
|---|---|
| card | abstract val card: Card<br>Details about the card used in this payment, including the brand and last four digits. |
| entryMethod | abstract val entryMethod: CardPaymentDetails.EntryMethod<br>The entry method used to provide a card's details. |

#### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.CardSurchargeDetails

data class CardSurchargeDetails(val cardSurchargeMoney: Money, val taxOnSurchargeMoney: Money?)

Details of a card surcharge applied to a payment.

##### Constructors

| | |
|---|---|
| CardSurchargeDetails | constructor(cardSurchargeMoney: Money, taxOnSurchargeMoney: Money?) |

##### Properties

| Name | Summary |
|---|---|
| cardSurchargeMoney | val cardSurchargeMoney: Money<br>The card surcharge amount applied to a card payment. This amount is automatically calculated using the merchant's configured surcharge percentage. This is the base surcharge amount and does not include any additional taxes that may apply to the surcharge. |
| taxOnSurchargeMoney | val taxOnSurchargeMoney: Money?<br>The tax amount applied on the surcharge. |
| totalSurchargeMoney | val totalSurchargeMoney: Money<br>Helper function to calculate the total surcharge amount. |

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.CardSurchargeDetails.totalSurchargeMoney

val totalSurchargeMoney: Money

Helper function to calculate the total surcharge amount.

#### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.EntryMethod

enum EntryMethod : Enum&lt;CardPaymentDetails.EntryMethod&gt; 

The entry method used to provide a card's details.

##### Entries

| | |
|---|---|
| KEYED | KEYED<br>Card details were manually entered. |
| SWIPED | SWIPED<br>Card details were obtained by swiping the card. |
| EMV | EMV<br>Card details were obtained by inserting the card into a chip reader. |
| CONTACTLESS | CONTACTLESS<br>Card details were obtained by tapping the card on a contactless reader. |
| ON_FILE | ON_FILE<br>Card details were obtained from a saved card on file. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;CardPaymentDetails.EntryMethod&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): CardPaymentDetails.EntryMethod<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;CardPaymentDetails.EntryMethod&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.EntryMethod.entries

val entries: EnumEntries&lt;CardPaymentDetails.EntryMethod&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.EntryMethod.valueOf

fun valueOf(value: String): CardPaymentDetails.EntryMethod

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.EntryMethod.values

fun values(): Array&lt;CardPaymentDetails.EntryMethod&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

#### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.OfflineCardPaymentDetails

class OfflineCardPaymentDetails(val card: Card, val entryMethod: CardPaymentDetails.EntryMethod, val applicationId: String?, val applicationName: String?) : CardPaymentDetails

Details about a successful offline card payment.

##### Constructors

| | |
|---|---|
| OfflineCardPaymentDetails | constructor(card: Card, entryMethod: CardPaymentDetails.EntryMethod, applicationId: String?, applicationName: String?) |

##### Properties

| Name | Summary |
|---|---|
| applicationId | val applicationId: String?<br>EMV application identifier, for the selected application for the payment. |
| applicationName | val applicationName: String?<br>EMV application name, for the selected application for the payment. |
| card | open override val card: Card<br>Details about the card used in this payment, including the brand and last four digits. |
| entryMethod | open override val entryMethod: CardPaymentDetails.EntryMethod<br>The entry method used to provide a card's details. |

#### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.OnlineCardPaymentDetails

class OnlineCardPaymentDetails : CardPaymentDetails

Details about a successful card payment.

##### Types

| Name | Summary |
|---|---|
| Builder | class Builder(status: CardPaymentDetails.Status, entryMethod: CardPaymentDetails.EntryMethod, card: Card)<br>Lets developers create and configure card data for automated testing. |

##### Properties

| Name | Summary |
|---|---|
| applicationId | val applicationId: String?<br>EMV application identifier, for the application on the card. |
| applicationName | val applicationName: String?<br>EMV application name, for the application on the card. |
| appliedCardSurchargeDetails | val appliedCardSurchargeDetails: CardPaymentDetails.CardSurchargeDetails?<br>Information about a card surcharge applied on the payment. |
| authorizationCode | val authorizationCode: String?<br>EMV tag 8A, returned by the issuer to identify the authorization of the payment. |
| card | open override val card: Card<br>Details about the card used in this payment, including the brand and last four digits. |
| entryMethod | open override val entryMethod: CardPaymentDetails.EntryMethod<br>The entry method used to provide a card's details. |
| status | val status: CardPaymentDetails.Status<br>The status of the card payment. |
| verificationMethod | val verificationMethod: CardPaymentDetails.VerificationMethod?<br>For EMV payments, the method used to verify the cardholder's identity. |
| verificationResults | val verificationResults: CardPaymentDetails.VerificationResult?<br>For EMV payments, the results of the cardholder verification. |

##### Functions

| Name | Summary |
|---|---|
| buildUpon | fun buildUpon(): CardPaymentDetails.OnlineCardPaymentDetails.Builder |

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.OnlineCardPaymentDetails.Builder

class Builder(status: CardPaymentDetails.Status, entryMethod: CardPaymentDetails.EntryMethod, card: Card)

Lets developers create and configure card data for automated testing.

There is no need to reference this builder class outside of tests.

###### Return

A new Card builder instance.

###### See also

| |
|---|
| CardPaymentDetails.OnlineCardPaymentDetails |

###### Constructors

| | |
|---|---|
| Builder | constructor(status: CardPaymentDetails.Status, entryMethod: CardPaymentDetails.EntryMethod, card: Card) |

###### Functions

| Name | Summary |
|---|---|
| applicationId | fun applicationId(applicationId: String): CardPaymentDetails.OnlineCardPaymentDetails.Builder |
| applicationName | fun applicationName(applicationName: String): CardPaymentDetails.OnlineCardPaymentDetails.Builder |
| appliedCardSurchargeDetails | fun appliedCardSurchargeDetails(appliedCardSurchargeDetails: CardPaymentDetails.CardSurchargeDetails?): CardPaymentDetails.OnlineCardPaymentDetails.Builder |
| authorizationCode | fun authorizationCode(authorizationCode: String): CardPaymentDetails.OnlineCardPaymentDetails.Builder |
| build | fun build(): CardPaymentDetails.OnlineCardPaymentDetails |
| card | fun card(card: Card): CardPaymentDetails.OnlineCardPaymentDetails.Builder |
| entryMethod | fun entryMethod(entryMethod: CardPaymentDetails.EntryMethod): CardPaymentDetails.OnlineCardPaymentDetails.Builder |
| status | fun status(status: CardPaymentDetails.Status): CardPaymentDetails.OnlineCardPaymentDetails.Builder |
| verificationMethod | fun verificationMethod(verificationMethod: CardPaymentDetails.VerificationMethod?): CardPaymentDetails.OnlineCardPaymentDetails.Builder |
| verificationResults | fun verificationResults(verificationResults: CardPaymentDetails.VerificationResult?): CardPaymentDetails.OnlineCardPaymentDetails.Builder |

#### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.Status

enum Status : Enum&lt;CardPaymentDetails.Status&gt; 

Status of the card payment

##### Entries

| | |
|---|---|
| AUTHORIZED | AUTHORIZED<br>The card transaction has been authorized but not yet captured. |
| CAPTURED | CAPTURED<br>The card transaction was authorized and subsequently captured (i.e., completed). |
| VOIDED | VOIDED<br>The card transaction was authorized and subsequently voided (i.e., canceled). |
| FAILED | FAILED<br>The card transaction failed. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;CardPaymentDetails.Status&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): CardPaymentDetails.Status<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;CardPaymentDetails.Status&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.Status.entries

val entries: EnumEntries&lt;CardPaymentDetails.Status&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.Status.valueOf

fun valueOf(value: String): CardPaymentDetails.Status

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.Status.values

fun values(): Array&lt;CardPaymentDetails.Status&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

#### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.VerificationMethod

enum VerificationMethod : Enum&lt;CardPaymentDetails.VerificationMethod&gt; 

For EMV payments, the method used to verify the cardholder's identity.

##### Entries

| | |
|---|---|
| PIN | PIN<br>The cardholder entered a PIN. |
| SIGNATURE | SIGNATURE<br>The cardholder provided a signature. |
| PIN_AND_SIGNATURE | PIN_AND_SIGNATURE<br>The cardholder provided both a PIN and a signature. |
| ON_DEVICE | ON_DEVICE<br>The cardholder was verified by the device. |
| NONE | NONE<br>No verification method was used. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;CardPaymentDetails.VerificationMethod&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): CardPaymentDetails.VerificationMethod<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;CardPaymentDetails.VerificationMethod&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.VerificationMethod.entries

val entries: EnumEntries&lt;CardPaymentDetails.VerificationMethod&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.VerificationMethod.valueOf

fun valueOf(value: String): CardPaymentDetails.VerificationMethod

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.VerificationMethod.values

fun values(): Array&lt;CardPaymentDetails.VerificationMethod&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

#### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.VerificationResult

enum VerificationResult : Enum&lt;CardPaymentDetails.VerificationResult&gt; 

For EMV payments, the results of the cardholder verification.

##### Entries

| | |
|---|---|
| SUCCESS | SUCCESS<br>The cardholder was successfully verified. |
| FAILURE | FAILURE<br>The cardholder was not successfully verified. |
| UNKNOWN | UNKNOWN<br>The cardholder verification status is unknown. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;CardPaymentDetails.VerificationResult&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): CardPaymentDetails.VerificationResult<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;CardPaymentDetails.VerificationResult&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.VerificationResult.entries

val entries: EnumEntries&lt;CardPaymentDetails.VerificationResult&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.VerificationResult.valueOf

fun valueOf(value: String): CardPaymentDetails.VerificationResult

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.CardPaymentDetails.VerificationResult.values

fun values(): Array&lt;CardPaymentDetails.VerificationResult&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.CashPaymentDetails

class CashPaymentDetails(val buyerSuppliedMoney: Money, val changeBackMoney: Money)

Details about a successful cash payment.

#### Constructors

| | |
|---|---|
| CashPaymentDetails | constructor(buyerSuppliedMoney: Money, changeBackMoney: Money) |

#### Types

| Name | Summary |
|---|---|
| Builder | class Builder(buyerSuppliedMoney: Money, changeBackMoney: Money)<br>Lets developers create and configure cash details for automated testing. |

#### Properties

| Name | Summary |
|---|---|
| buyerSuppliedMoney | val buyerSuppliedMoney: Money<br>The amount and currency of the money supplied by the buyer. |
| changeBackMoney | val changeBackMoney: Money<br>The amount of change due back from the buyer. changeBackMoney should not be set by the developer directly, it's set from the server response following a successful payment. |

#### com.squareup.sdk.mobilepayments.payment.CashPaymentDetails.Builder

class Builder(buyerSuppliedMoney: Money, changeBackMoney: Money)

Lets developers create and configure cash details for automated testing.

There is no need to reference this builder class outside of tests.

##### Return

A new CashPaymentDetails builder instance.

##### Constructors

| | |
|---|---|
| Builder | constructor(buyerSuppliedMoney: Money, changeBackMoney: Money) |

##### Functions

| Name | Summary |
|---|---|
| build | fun build(): CashPaymentDetails |

### com.squareup.sdk.mobilepayments.payment.CurrencyCode

enum CurrencyCode : Enum&lt;CurrencyCode&gt; 

Represents a currency. Currencies are identified by their ISO 4217 currency codes.

Only the currencies of the markets Square operates in are listed here; a payment in any other currency is rejected by the Square backend.

#### Entries

| | |
|---|---|
| AUD | AUD |
| CAD | CAD |
| EUR | EUR |
| GBP | GBP |
| JPY | JPY |
| USD | USD |

#### Properties

| Name | Summary |
|---|---|
| code | val code: Int |
| entries | val entries: EnumEntries&lt;CurrencyCode&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |
| symbol | val symbol: Char |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): CurrencyCode<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;CurrencyCode&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.payment.CurrencyCode.entries

val entries: EnumEntries&lt;CurrencyCode&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.payment.CurrencyCode.valueOf

fun valueOf(value: String): CurrencyCode

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.payment.CurrencyCode.values

fun values(): Array&lt;CurrencyCode&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.DelayAction

enum DelayAction : Enum&lt;DelayAction&gt; 

Actions possible when an authorized payment is neither canceled nor completed in time.

#### Entries

| | |
|---|---|
| CANCEL | CANCEL<br>The authorized payment is canceled and payment is not taken from the buyer. |
| COMPLETE | COMPLETE<br>The authorized payment is completed, taking payment from the buyer. |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;DelayAction&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): DelayAction<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;DelayAction&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.payment.DelayAction.entries

val entries: EnumEntries&lt;DelayAction&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.payment.DelayAction.valueOf

fun valueOf(value: String): DelayAction

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.payment.DelayAction.values

fun values(): Array&lt;DelayAction&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.Money

class Money(val amount: Long, val currencyCode: CurrencyCode)

A representation of a specific amount of money.

#### Parameters

| | |
|---|---|
| amount | in the smallest unit of the given currencyCode (e.g. 100 = $1.00). |
| currencyCode | Currency of the amount. See CurrencyCode for the supported currencies. |

#### Constructors

| | |
|---|---|
| Money | constructor(amount: Long, currencyCode: CurrencyCode) |

#### Properties

| Name | Summary |
|---|---|
| amount | val amount: Long |
| currencyCode | val currencyCode: CurrencyCode |

#### com.squareup.sdk.mobilepayments.payment.Money.amount

val amount: Long

##### Parameters

| | |
|---|---|
| amount | in the smallest unit of the given currencyCode (e.g. 100 = $1.00). |

#### com.squareup.sdk.mobilepayments.payment.Money.currencyCode

val currencyCode: CurrencyCode

##### Parameters

| | |
|---|---|
| currencyCode | Currency of the amount. See CurrencyCode for the supported currencies. |

### com.squareup.sdk.mobilepayments.payment.OfflinePaymentQueue

interface OfflinePaymentQueue

A queue of offline payments taken on this device that have not yet been uploaded to the Square server.

#### Functions

| Name | Summary |
|---|---|
| getPayments | abstract fun getPayments(callback: Callback&lt;GetOfflinePaymentsResult&gt;): CallbackReference<br>Fetches all offline payments from local storage. If the fetch is successful, the provided callback is called with the result - a list of OfflinePayment. In case of failure, an error message is provided. |
| getTotalStoredPaymentAmount | abstract fun getTotalStoredPaymentAmount(): GetTotalStoredPaymentAmountResult<br>Returns the sum of all stored (and not uploaded yet) offline payments with the same location as the current one. If amount is `-1`, then there was an issue getting the amount from the database. |

#### com.squareup.sdk.mobilepayments.payment.OfflinePaymentQueue.getPayments

abstract fun getPayments(callback: Callback&lt;GetOfflinePaymentsResult&gt;): CallbackReference

Fetches all offline payments from local storage. If the fetch is successful, the provided callback is called with the result - a list of OfflinePayment. In case of failure, an error message is provided.

#### com.squareup.sdk.mobilepayments.payment.OfflinePaymentQueue.getTotalStoredPaymentAmount

abstract fun getTotalStoredPaymentAmount(): GetTotalStoredPaymentAmountResult

Returns the sum of all stored (and not uploaded yet) offline payments with the same location as the current one. If amount is `-1`, then there was an issue getting the amount from the database.

### com.squareup.sdk.mobilepayments.payment.Payment

sealed class Payment

The description of a completed payment, returned in the success value of Payment Result. All currency amounts are specified in the smallest denomination of the applicable currency. For example, US dollar amounts are specified in cents.

#### Inheritors

| |
|---|
| OnlinePayment |
| OfflinePayment |

#### Types

| Name | Summary |
|---|---|
| Capabilities | data class Capabilities(val allCapabilities: Set&lt;String&gt;)<br>Actions that can be performed on a payment, e.g. modifying the tip amount up or down. |
| OfflinePayment | class OfflinePayment : Payment<br>The description of a completed payment, that was taken while Offline. All currency amounts are specified in the smallest denomination of the applicable currency. For example, US dollar amounts are specified in cents. |
| OfflineStatus | enum OfflineStatus : Enum&lt;Payment.OfflineStatus&gt; <br>The status of the offline payment. |
| OnlinePayment | class OnlinePayment : Payment<br>The description of a completed payment, returned in the success value of Payment Result. All currency amounts are specified in the smallest denomination of the applicable currency. For example, US dollar amounts are specified in cents. |
| SourceType | enum SourceType : Enum&lt;Payment.SourceType&gt; <br>The source type of the payment. |
| Status | enum Status : Enum&lt;Payment.Status&gt; <br>The status of the payment. |

#### Properties

| Name | Summary |
|---|---|
| amountMoney | abstract val amountMoney: Money<br>The base amount of money processed for this payment. This amount does not include tip. If a card surcharge was applied to this payment, the surcharge and tax on the surcharge will be included in this amount. Details on the surcharge can be found in CardPaymentDetails. |
| appFeeMoney | abstract val appFeeMoney: Money?<br>The amount taken by the developer as a fee, not more than 90% of totalMoney. |
| cardDetails | abstract val cardDetails: CardPaymentDetails?<br>Details about a card payment. These details are only populated if the sourceType is SourceType.CARD. For an online payment, this will be of type OnlineCardPaymentDetails; for an offline payment, this will be of type OfflineCardPaymentDetails. |
| cashDetails | abstract val cashDetails: CashPaymentDetails?<br>Details about a cash payment. These details are only populated if the sourceType is SourceType.CASH. |
| createdAt | abstract val createdAt: Date<br>Timestamp of when the payment was created. |
| locationId | abstract val locationId: String<br>The ID of the location associated with the payment, if available. |
| orderId | abstract val orderId: String?<br>The ID of the order associated with this payment. |
| referenceId | abstract val referenceId: String?<br>An optional ID that associates this payment with an entity in another system. |
| sourceType | abstract val sourceType: Payment.SourceType<br>The source type of the payment (card, cash, etc). |
| tipMoney | abstract val tipMoney: Money?<br>The portion of totalMoney that is designated as a tip. |
| totalMoney | val totalMoney: Money<br>Total money is defined as base amount plus any tip; it doesn't need its own storage allocated, and *definitely* doesn't need an independent setter. |
| updatedAt | abstract val updatedAt: Date<br>Timestamp when the payment was last updated. |

#### Functions

| Name | Summary |
|---|---|
| asOfflinePayment | fun asOfflinePayment(): Payment.OfflinePayment |
| asOnlinePayment | fun asOnlinePayment(): Payment.OnlinePayment |
| isOfflinePayment | fun isOfflinePayment(): Boolean |
| isOnlinePayment | fun isOnlinePayment(): Boolean |

#### com.squareup.sdk.mobilepayments.payment.Payment.totalMoney

val totalMoney: Money

Total money is defined as base amount plus any tip; it doesn't need its own storage allocated, and *definitely* doesn't need an independent setter.

#### com.squareup.sdk.mobilepayments.payment.Payment.Capabilities

data class Capabilities(val allCapabilities: Set&lt;String&gt;)

Actions that can be performed on a payment, e.g. modifying the tip amount up or down.

- Use `canCapabilityName` methods for convenient `true`/`false` check for capability, e.g. canEditTipUp.
- Use allCapabilities property to get all capabilities of a Payment.

##### Constructors

| | |
|---|---|
| Capabilities | constructor(allCapabilities: Set&lt;String&gt;) |

##### Types

| Name | Summary |
|---|---|
| Companion | object Companion<br>Constants for capability names. |

##### Properties

| Name | Summary |
|---|---|
| allCapabilities | val allCapabilities: Set&lt;String&gt; |

##### Functions

| Name | Summary |
|---|---|
| canEditTipDown | fun canEditTipDown(): Boolean<br>The tip amount can be edited down. |
| canEditTipUp | fun canEditTipUp(): Boolean<br>The tip amount can be edited up. |

##### com.squareup.sdk.mobilepayments.payment.Payment.Capabilities.canEditTipDown

fun canEditTipDown(): Boolean

The tip amount can be edited down.

##### com.squareup.sdk.mobilepayments.payment.Payment.Capabilities.canEditTipUp

fun canEditTipUp(): Boolean

The tip amount can be edited up.

##### com.squareup.sdk.mobilepayments.payment.Payment.Capabilities.Companion

object Companion

Constants for capability names.

###### Properties

| Name | Summary |
|---|---|
| EDIT_AMOUNT_DOWN | const val EDIT_AMOUNT_DOWN: String |
| EDIT_AMOUNT_UP | const val EDIT_AMOUNT_UP: String |
| EDIT_TIP_AMOUNT_DOWN | const val EDIT_TIP_AMOUNT_DOWN: String |
| EDIT_TIP_AMOUNT_UP | const val EDIT_TIP_AMOUNT_UP: String |

#### com.squareup.sdk.mobilepayments.payment.Payment.OfflinePayment

class OfflinePayment : Payment

The description of a completed payment, that was taken while Offline. All currency amounts are specified in the smallest denomination of the applicable currency. For example, US dollar amounts are specified in cents.

##### Types

| Name | Summary |
|---|---|
| Builder | class Builder(localId: String, amountMoney: Money, status: Payment.OfflineStatus, locationId: String, sourceType: Payment.SourceType)<br>Builder class for constructing OfflinePayment objects. |

##### Properties

| Name | Summary |
|---|---|
| amountMoney | open override val amountMoney: Money<br>The base amount of money processed for this payment. This amount does not include tip. If a card surcharge was applied to this payment, the surcharge and tax on the surcharge will be included in this amount. Details on the surcharge can be found in CardPaymentDetails. |
| appFeeMoney | open override val appFeeMoney: Money?<br>The amount taken by the developer as a fee, not more than 90% of totalMoney. |
| cardDetails | open override val cardDetails: CardPaymentDetails.OfflineCardPaymentDetails?<br>Details about a card payment. These details are only populated if the sourceType is SourceType.CARD. For an online payment, this will be of type OnlineCardPaymentDetails; for an offline payment, this will be of type OfflineCardPaymentDetails. |
| cashDetails | open override val cashDetails: CashPaymentDetails?<br>Details about a cash payment. These details are only populated if the sourceType is SourceType.CASH. |
| createdAt | open override val createdAt: Date<br>Timestamp of when the payment was created. |
| id | val id: String?<br>Unique ID for this payment, assigned by Square. Value stays `null` until payment is uploaded and gets a server-side ID. |
| localId | val localId: String<br>Unique ID for this payment, generated when device is offline. Can be used to identify this Payment until it is uploaded to server and id becomes available. |
| locationId | open override val locationId: String<br>The ID of the location associated with the payment, if available. |
| orderId | open override val orderId: String?<br>The ID of the order associated with this payment. |
| referenceId | open override val referenceId: String?<br>An optional ID that associates this payment with an entity in another system. |
| sourceType | open override val sourceType: Payment.SourceType<br>The source type of the payment (card, cash, etc). |
| status | val status: Payment.OfflineStatus<br>Indicates the OfflineStatus of the payment. |
| tipMoney | open override val tipMoney: Money?<br>The portion of totalMoney that is designated as a tip. |
| totalMoney | val totalMoney: Money<br>Total money is defined as base amount plus any tip; it doesn't need its own storage allocated, and *definitely* doesn't need an independent setter. |
| updatedAt | open override val updatedAt: Date<br>Timestamp when the payment was last updated. |
| uploadedAt | val uploadedAt: Date?<br>Timestamp of when the payment was uploaded for processing. |

##### Functions

| Name | Summary |
|---|---|
| asOfflinePayment | fun asOfflinePayment(): Payment.OfflinePayment |
| asOnlinePayment | fun asOnlinePayment(): Payment.OnlinePayment |
| buildUpon | fun buildUpon(): Payment.OfflinePayment.Builder |
| isOfflinePayment | fun isOfflinePayment(): Boolean |
| isOnlinePayment | fun isOnlinePayment(): Boolean |

##### com.squareup.sdk.mobilepayments.payment.Payment.OfflinePayment.Builder

class Builder(localId: String, amountMoney: Money, status: Payment.OfflineStatus, locationId: String, sourceType: Payment.SourceType)

Builder class for constructing OfflinePayment objects.

This class is provided for testing purposes.

###### Constructors

| | |
|---|---|
| Builder | constructor(localId: String, amountMoney: Money, status: Payment.OfflineStatus, locationId: String, sourceType: Payment.SourceType) |

###### Functions

| Name | Summary |
|---|---|
| amount | fun amount(amountMoney: Money): Payment.OfflinePayment.Builder |
| appFeeMoney | fun appFeeMoney(appFeeMoney: Money): Payment.OfflinePayment.Builder |
| build | fun build(): Payment.OfflinePayment |
| cardDetails | fun cardDetails(cardDetails: CardPaymentDetails.OfflineCardPaymentDetails): Payment.OfflinePayment.Builder |
| cashDetails | fun cashDetails(cashDetails: CashPaymentDetails): Payment.OfflinePayment.Builder |
| createdAt | fun createdAt(createdAt: Date): Payment.OfflinePayment.Builder |
| id | fun id(id: String?): Payment.OfflinePayment.Builder |
| localId | fun localId(id: String): Payment.OfflinePayment.Builder |
| locationId | fun locationId(locationId: String): Payment.OfflinePayment.Builder |
| orderId | fun orderId(orderId: String?): Payment.OfflinePayment.Builder |
| referenceId | fun referenceId(referenceId: String?): Payment.OfflinePayment.Builder |
| status | fun status(status: Payment.OfflineStatus): Payment.OfflinePayment.Builder |
| tipMoney | fun tipMoney(tipMoney: Money): Payment.OfflinePayment.Builder |
| updatedAt | fun updatedAt(updatedAt: Date): Payment.OfflinePayment.Builder |
| uploadedAt | fun uploadedAt(uploadedAt: Date?): Payment.OfflinePayment.Builder |

#### com.squareup.sdk.mobilepayments.payment.Payment.OfflineStatus

enum OfflineStatus : Enum&lt;Payment.OfflineStatus&gt; 

The status of the offline payment.

##### Entries

| | |
|---|---|
| QUEUED | QUEUED<br>Payment is on your device only but Mobile Payments SDK will attempt to upload it soon. |
| UPLOADED | UPLOADED<br>Payment has been uploaded to the Square Server. Your money is safe now! |
| FAILED_TO_UPLOAD | FAILED_TO_UPLOAD<br>Payment could not be uploaded, due to the unrecoverable error. |
| FAILED_TO_PROCESS | FAILED_TO_PROCESS<br>Square Server couldn't process your offline payment, maybe the card was declined or something. |
| PROCESSED | PROCESSED<br>Square Server processed your offline payment successfully, you can now see it in your merchant dashboard. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;Payment.OfflineStatus&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): Payment.OfflineStatus<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;Payment.OfflineStatus&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.Payment.OfflineStatus.entries

val entries: EnumEntries&lt;Payment.OfflineStatus&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.Payment.OfflineStatus.valueOf

fun valueOf(value: String): Payment.OfflineStatus

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.Payment.OfflineStatus.values

fun values(): Array&lt;Payment.OfflineStatus&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

#### com.squareup.sdk.mobilepayments.payment.Payment.OnlinePayment

class OnlinePayment : Payment

The description of a completed payment, returned in the success value of Payment Result. All currency amounts are specified in the smallest denomination of the applicable currency. For example, US dollar amounts are specified in cents.

##### Types

| Name | Summary |
|---|---|
| Builder | class Builder(id: String, amountMoney: Money, status: Payment.Status, locationId: String, sourceType: Payment.SourceType)<br>Builder class for constructing OnlinePayment objects. |

##### Properties

| Name | Summary |
|---|---|
| amountMoney | open override val amountMoney: Money<br>The base amount of money processed for this payment. This amount does not include tip. If a card surcharge was applied to this payment, the surcharge and tax on the surcharge will be included in this amount. Details on the surcharge can be found in CardPaymentDetails. |
| appFeeMoney | open override val appFeeMoney: Money?<br>The amount taken by the developer as a fee, not more than 90% of totalMoney. |
| capabilities | val capabilities: Payment.Capabilities<br>Actions that can be performed on this payment. |
| cardDetails | open override val cardDetails: CardPaymentDetails.OnlineCardPaymentDetails?<br>Details about a card payment. These details are only populated if the sourceType is SourceType.CARD. For an online payment, this will be of type OnlineCardPaymentDetails; for an offline payment, this will be of type OfflineCardPaymentDetails. |
| cashDetails | open override val cashDetails: CashPaymentDetails?<br>Details about a cash payment. These details are only populated if the sourceType is SourceType.CASH. |
| createdAt | open override val createdAt: Date<br>Timestamp of when the payment was created. |
| customerId | val customerId: String?<br>An optional customer_id to be entered by the developer when creating a payment. |
| id | val id: String<br>Unique ID for this payment, assigned by Square. |
| locationId | open override val locationId: String<br>The ID of the location associated with the payment, if available. |
| note | val note: String?<br>An optional note to include when creating a payment. |
| orderId | open override val orderId: String?<br>The ID of the order associated with this payment. |
| processingFee | val processingFee: List&lt;PaymentProcessingFee&gt;<br>Processing fees and fee adjustments assessed by Square on this payment. |
| receiptNumber | val receiptNumber: String?<br>An optional receipt number associated with this payment, assigned by Square. The field is missing if the payment is Payment.Status.CANCELED. |
| receiptUrl | val receiptUrl: String?<br>The URL for the payment's receipt, generated by Square. The field is only populated for COMPLETED payments. |
| referenceId | open override val referenceId: String?<br>An optional ID that associates this payment with an entity in another system. |
| sourceType | open override val sourceType: Payment.SourceType<br>The source type of the payment (card, cash, etc). |
| statementDescription | val statementDescription: String?<br>An override of the description line on the buyer's statement. Will be prefixed with Square's "SQ*" prefix, and may be truncated by the bank during generation. |
| status | val status: Payment.Status<br>Indicates whether the payment is Status.APPROVED, Status.COMPLETED, Status.CANCELED, or Status.FAILED. |
| teamMemberId | val teamMemberId: String?<br>An optional ID of the team member associated with taking the payment. |
| tipMoney | open override val tipMoney: Money?<br>The portion of totalMoney that is designated as a tip. |
| totalMoney | val totalMoney: Money<br>Total money is defined as base amount plus any tip; it doesn't need its own storage allocated, and *definitely* doesn't need an independent setter. |
| updatedAt | open override val updatedAt: Date<br>Timestamp when the payment was last updated. |

##### Functions

| Name | Summary |
|---|---|
| asOfflinePayment | fun asOfflinePayment(): Payment.OfflinePayment |
| asOnlinePayment | fun asOnlinePayment(): Payment.OnlinePayment |
| buildUpon | fun buildUpon(): Payment.OnlinePayment.Builder |
| isOfflinePayment | fun isOfflinePayment(): Boolean |
| isOnlinePayment | fun isOnlinePayment(): Boolean |

##### com.squareup.sdk.mobilepayments.payment.Payment.OnlinePayment.Builder

class Builder(id: String, amountMoney: Money, status: Payment.Status, locationId: String, sourceType: Payment.SourceType)

Builder class for constructing OnlinePayment objects.

This class is provided for testing purposes.

###### Constructors

| | |
|---|---|
| Builder | constructor(id: String, amountMoney: Money, status: Payment.Status, locationId: String, sourceType: Payment.SourceType) |

###### Functions

| Name | Summary |
|---|---|
| addProcessingFee | fun addProcessingFee(processingFee: PaymentProcessingFee): Payment.OnlinePayment.Builder |
| amount | fun amount(amountMoney: Money): Payment.OnlinePayment.Builder |
| appFeeMoney | fun appFeeMoney(appFeeMoney: Money?): Payment.OnlinePayment.Builder |
| build | fun build(): Payment.OnlinePayment |
| capabilities | fun capabilities(capabilities: Payment.Capabilities): Payment.OnlinePayment.Builder |
| cardDetails | fun cardDetails(cardDetails: CardPaymentDetails.OnlineCardPaymentDetails): Payment.OnlinePayment.Builder |
| cashDetails | fun cashDetails(cashDetails: CashPaymentDetails): Payment.OnlinePayment.Builder |
| createdAt | fun createdAt(createdAt: Date): Payment.OnlinePayment.Builder |
| customerId | fun customerId(customerId: String): Payment.OnlinePayment.Builder |
| id | fun id(id: String): Payment.OnlinePayment.Builder |
| locationId | fun locationId(locationId: String): Payment.OnlinePayment.Builder |
| note | fun note(note: String): Payment.OnlinePayment.Builder |
| orderId | fun orderId(orderId: String): Payment.OnlinePayment.Builder |
| receiptNumber | fun receiptNumber(receiptNumber: String?): Payment.OnlinePayment.Builder |
| receiptUrl | fun receiptUrl(receiptUrl: String?): Payment.OnlinePayment.Builder |
| referenceId | fun referenceId(referenceId: String): Payment.OnlinePayment.Builder |
| statementDescription | fun statementDescription(statementDescription: String?): Payment.OnlinePayment.Builder |
| status | fun status(status: Payment.Status): Payment.OnlinePayment.Builder |
| teamMemberId | fun teamMemberId(teamMemberId: String?): Payment.OnlinePayment.Builder |
| tipMoney | fun tipMoney(tipMoney: Money?): Payment.OnlinePayment.Builder |
| updatedAt | fun updatedAt(updatedAt: Date): Payment.OnlinePayment.Builder |

#### com.squareup.sdk.mobilepayments.payment.Payment.SourceType

enum SourceType : Enum&lt;Payment.SourceType&gt; 

The source type of the payment.

##### Entries

| | |
|---|---|
| CARD | CARD<br>The payment was made with a credit or debit card. |
| CASH | CASH<br>The payment was made with cash. |
| EXTERNAL | EXTERNAL<br>The payment was made with an external payment method. |
| WALLET | WALLET<br>The payment was made with a digital wallet. |
| BANK_ACCOUNT | BANK_ACCOUNT<br>An ACH bank account payment. |
| CARD_ON_FILE | CARD_ON_FILE<br>A payment made with a saved Card on File. |
| SQUARE_ACCOUNT | SQUARE_ACCOUNT<br>A payment made with a Square Account. |
| UNKNOWN | UNKNOWN<br>/v2/payment reported this payment with a source type not known to this version of Mobile Payments SDK. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;Payment.SourceType&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): Payment.SourceType<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;Payment.SourceType&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.Payment.SourceType.entries

val entries: EnumEntries&lt;Payment.SourceType&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.Payment.SourceType.valueOf

fun valueOf(value: String): Payment.SourceType

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.Payment.SourceType.values

fun values(): Array&lt;Payment.SourceType&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

#### com.squareup.sdk.mobilepayments.payment.Payment.Status

enum Status : Enum&lt;Payment.Status&gt; 

The status of the payment.

##### Entries

| | |
|---|---|
| APPROVED | APPROVED<br>The card transaction has been approved, and funds reserved, but not yet completed. |
| COMPLETED | COMPLETED<br>The card transaction was approved and subsequently completed. |
| CANCELED | CANCELED<br>The card transaction was approved and subsequently voided. |
| FAILED | FAILED<br>The card transaction failed. |
| UNKNOWN | UNKNOWN<br>/v2/payment reported this payment in a status not known to this version of Mobile Payments SDK. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;Payment.Status&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): Payment.Status<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;Payment.Status&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.Payment.Status.entries

val entries: EnumEntries&lt;Payment.Status&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.Payment.Status.valueOf

fun valueOf(value: String): Payment.Status

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.Payment.Status.values

fun values(): Array&lt;Payment.Status&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.PaymentErrorCode

enum PaymentErrorCode : ErrorCode, Enum&lt;PaymentErrorCode&gt; 

Error conditions that arise during payments. Like other categories of error codes, these are separated between "usage errors" which a careful developer could and should have avoided, and regular errors which cannot be prevented during normal operation. For example, NOT_AUTHORIZED is not a usage error, because user might be force-logged out during payment process and server will then return error 401. However, developers should be checking that Mobile Payments SDK has been authorized and, if not, disabling the controls that lead to a call to PaymentManager.startPaymentActivity; TIMEOUT is a regular, non-usage error because network conditions are unpredictable and might be severed in the middle of a transaction; even with the best of developers' care, timeouts sometimes just happen.

#### Entries

| | |
|---|---|
| CANCELED | CANCELED<br>Payment canceled. |
| NOT_AUTHORIZED | NOT_AUTHORIZED<br>Payment attempted before authorization. |
| OBSOLETE_SDK | OBSOLETE_SDK<br>SDK version is obsolete and no longer supported. |
| TIMEOUT | TIMEOUT<br>The contactless and chip reader timed out. |
| LOCATION_SERVICES_DISABLED | LOCATION_SERVICES_DISABLED<br>Locations services are turned off. |
| DEVICE_CLOCK_SKEWED | DEVICE_CLOCK_SKEWED<br>The device clock is skewed and not matching the server time. |
| CONSENT_NOT_PROVIDED | CONSENT_NOT_PROVIDED<br>Merchant is in a market that requires consent for analytics and consent has not been provided |
| USAGE_ERROR | USAGE_ERROR<br>PaymentManager.startPaymentActivity was used in an unexpected or unsupported way. See the debug code and debug message for more information. |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;PaymentErrorCode&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| isUsageError | open override val isUsageError: Boolean<br>Returns `true` if the error is a usage error, `false` otherwise. |
| name | val name: String<br>Returns the name of the error code. |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): PaymentErrorCode<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;PaymentErrorCode&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.payment.PaymentErrorCode.entries

val entries: EnumEntries&lt;PaymentErrorCode&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.payment.PaymentErrorCode.isUsageError

open override val isUsageError: Boolean

Returns `true` if the error is a usage error, `false` otherwise.

Useful for writing shared handling of debug codes and messages across Mobile Payments SDK operations.

#### com.squareup.sdk.mobilepayments.payment.PaymentErrorCode.valueOf

fun valueOf(value: String): PaymentErrorCode

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.payment.PaymentErrorCode.values

fun values(): Array&lt;PaymentErrorCode&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.PaymentHandle

interface PaymentHandle

Representation of a payment process available immediately from PaymentManager.startPaymentActivity. Provides a way to interact with an ongoing payment, e.g. cancel it or select additionalPaymentMethods.

#### Types

| Name | Summary |
|---|---|
| CancelResult | enum CancelResult : Enum&lt;PaymentHandle.CancelResult&gt; <br>Return values from PaymentHandle.cancel. |

#### Properties

| Name | Summary |
|---|---|
| additionalPaymentMethods | abstract val additionalPaymentMethods: List&lt;AdditionalPaymentMethod&gt;<br>Provides access to non-cardreader payment methods. |
| paymentParameters | abstract val paymentParameters: PaymentParameters?<br>Provides access to the PaymentParameters passed to PaymentManager.startPaymentActivity for this payment. |
| totalMoneyWithProposedCardSurcharge | abstract val totalMoneyWithProposedCardSurcharge: Money?<br>Provides access to the total amount, including tip and a proposed card surcharge, if applicable. If the merchant sets a card surcharge for this location and the buyer pays with a card subject to surcharge, this will be the total amount authorized. This value can be used to display the amount with surcharge on a custom payment prompt screen. If tax is applied to the surcharge, this value also includes that tax. This value will be null if a card surcharge is not applicable. Example: |

#### Functions

| Name | Summary |
|---|---|
| cancel | abstract fun cancel(): PaymentHandle.CancelResult<br>Cancels a pending payment, if one exists and can be canceled. In this case, the method returns CancelResult.CANCELED and the payment callbacks will be called with PaymentErrorCode.CANCELED to indicate the cancellation. |
| findMethod | abstract fun findMethod(type: AdditionalPaymentMethod.Type): AdditionalPaymentMethod?<br>Searches for a specific additional payment method by its type. |

#### com.squareup.sdk.mobilepayments.payment.PaymentHandle.additionalPaymentMethods

abstract val additionalPaymentMethods: List&lt;AdditionalPaymentMethod&gt;

Provides access to non-cardreader payment methods.

If you start a payment with PromptMode.CUSTOM, you can switch to a different payment method by invoking the `trigger` method on the returned AdditionalPaymentMethod. If you start a payment with PromptMode.DEFAULT, you will also see the payment methods, but their `trigger` methods will become no-ops.

Typical usage would be to display a list of buttons, and connect each button to the "trigger" method of one of these AdditionalPaymentMethod. Most of the payment methods have zero-argument triggers, but a few require specific inputs and must be handled specifically.

#### com.squareup.sdk.mobilepayments.payment.PaymentHandle.cancel

abstract fun cancel(): PaymentHandle.CancelResult

Cancels a pending payment, if one exists and can be canceled. In this case, the method returns CancelResult.CANCELED and the payment callbacks will be called with PaymentErrorCode.CANCELED to indicate the cancellation.

Otherwise, this method will return CancelResult.NO_PAYMENT_IN_PROGRESS if there is no payment to be canceled, or CancelResult.NOT_CANCELABLE if there is a payment but it cannot be canceled.

#### com.squareup.sdk.mobilepayments.payment.PaymentHandle.findMethod

abstract fun findMethod(type: AdditionalPaymentMethod.Type): AdditionalPaymentMethod?

Searches for a specific additional payment method by its type.

##### Return

the chosen method, or `null` if that method is not available.

##### See also

| |
|---|
| PaymentHandle.additionalPaymentMethods |

#### com.squareup.sdk.mobilepayments.payment.PaymentHandle.paymentParameters

abstract val paymentParameters: PaymentParameters?

Provides access to the PaymentParameters passed to PaymentManager.startPaymentActivity for this payment.

#### com.squareup.sdk.mobilepayments.payment.PaymentHandle.totalMoneyWithProposedCardSurcharge

abstract val totalMoneyWithProposedCardSurcharge: Money?

Provides access to the total amount, including tip and a proposed card surcharge, if applicable. If the merchant sets a card surcharge for this location and the buyer pays with a card subject to surcharge, this will be the total amount authorized. This value can be used to display the amount with surcharge on a custom payment prompt screen. If tax is applied to the surcharge, this value also includes that tax. This value will be null if a card surcharge is not applicable. Example:

- PaymentParameters.amountMoney = $10.00
- PaymentParameters.tipMoney = $2.00
- 3% card surcharge with 4% tax = 
   
   $0.30 (3% of $
   
   10) + 
   
   $0.01 (4% of $
   
   0.30 with Banker's Rounding) = $0.31
- totalMoneyWithProposedCardSurcharge = $12.31

#### com.squareup.sdk.mobilepayments.payment.PaymentHandle.CancelResult

enum CancelResult : Enum&lt;PaymentHandle.CancelResult&gt; 

Return values from PaymentHandle.cancel.

##### Entries

| | |
|---|---|
| NO_PAYMENT_IN_PROGRESS | NO_PAYMENT_IN_PROGRESS<br>Error result when no payment exists to be canceled. |
| CANCELED | CANCELED<br>Successfully canceled the payment that was in progress. |
| NOT_CANCELABLE | NOT_CANCELABLE<br>A payment is still in progress, but is too far along for cancellation. It is only possible to cancel a payment while waiting for input to a card reader. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;PaymentHandle.CancelResult&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): PaymentHandle.CancelResult<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;PaymentHandle.CancelResult&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.PaymentHandle.CancelResult.entries

val entries: EnumEntries&lt;PaymentHandle.CancelResult&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.PaymentHandle.CancelResult.valueOf

fun valueOf(value: String): PaymentHandle.CancelResult

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.PaymentHandle.CancelResult.values

fun values(): Array&lt;PaymentHandle.CancelResult&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.PaymentManager

interface PaymentManager

Processes payments for Mobile Payments SDK.

`PaymentManager` is a singleton instance, retrieved from MobilePaymentsSdk.paymentManager like the other managers. Use it by starting a payment with startPaymentActivity.

When calling startPaymentActivity, the developer has an option to either use the default payment prompt screen or provide a custom one (see PromptMode). This screen is where the customer is asked to swipe, insert, or tap a card.

If the custom screen is used, the Mobile Payments SDK will take control over UI, once the customer interacts with the card reader.

During the payment flow, Mobile Payments SDK will show screens (for example, to collect PIN numbers, and to confirm the completed transaction to the user), which will be dismissed by the time the payment completion callback is called.

#### Types

| Name | Summary |
|---|---|
| IdempotencyKeyData | data class IdempotencyKeyData(val updatedAt: Date, val paymentAttemptId: String, val idempotencyKey: String)<br>Data retrieved from PaymentManager.getAllIdempotencyKeys. |

#### Properties

| Name | Summary |
|---|---|
| currentPaymentHandle | abstract val currentPaymentHandle: PaymentHandle?<br>A PaymentHandle for interacting with the currently active payment, or null if no payment is in progress. |

#### Functions

| Name | Summary |
|---|---|
| completePayment | abstract fun completePayment(paymentId: String, callback: Callback&lt;PaymentResult&gt;): PaymentHandle<br>Completes a previously-authorized payment. |
| getAllIdempotencyKeys | abstract fun getAllIdempotencyKeys(callback: Callback&lt;GetAllIdempotencyKeysResult&gt;): CallbackReference<br>Retrieves all payment attempt IDs and their respective idempotency keys from local storage. |
| getAvailableCardEntryMethods | abstract fun getAvailableCardEntryMethods(): Set&lt;CardEntryMethod&gt;<br>Retrieves the possible card entry methods to take a payment. This is the union of all the several card readers' supported card entry methods. |
| getIdempotencyKey | abstract fun getIdempotencyKey(paymentAttemptId: String): GetIdempotencyKeyResult<br>Retrieves the idempotency key used in the payment request associated with the given paymentAttemptId, if the paymentAttemptId was used in the last 24 hours. The returned idempotency key can be used to a cancel a payment via the Square Payments API: https://developer.squareup.com/reference/square/payments-api/cancel-payment-by-idempotency-key |
| getOfflinePaymentQueue | abstract fun getOfflinePaymentQueue(): OfflinePaymentQueue<br>Returns an OfflinePaymentQueue interface, used to interact with offline payments. |
| setAvailableCardEntryMethodChangedCallback | abstract fun setAvailableCardEntryMethodChangedCallback(callback: Callback&lt;Set&lt;CardEntryMethod&gt;&gt;): CallbackReference<br>Registers a callback to notify the application when the set of available card entry methods changes. For example, as a magstripe reader is inserted or removed, this callback will be called to reflect the availability of the SWIPED card entry method. |
| startPaymentActivity | abstract fun startPaymentActivity(paymentParameters: PaymentParameters, promptParameters: PromptParameters, callback: Callback&lt;PaymentResult&gt;): PaymentHandle<br>Begins a payment, using the provided paymentParameters to set the payment information. |

#### com.squareup.sdk.mobilepayments.payment.PaymentManager.completePayment

abstract fun completePayment(paymentId: String, callback: Callback&lt;PaymentResult&gt;): PaymentHandle

Completes a previously-authorized payment.

##### Parameters

| | |
|---|---|
| paymentId | the server-assigned identifier of the payment to complete. The payment should be in AUTHORIZED state for completion to be meaningful. |
| callback | a callback used to notify the application of the result |

#### com.squareup.sdk.mobilepayments.payment.PaymentManager.currentPaymentHandle

abstract val currentPaymentHandle: PaymentHandle?

A PaymentHandle for interacting with the currently active payment, or null if no payment is in progress.

#### com.squareup.sdk.mobilepayments.payment.PaymentManager.getAllIdempotencyKeys

abstract fun getAllIdempotencyKeys(callback: Callback&lt;GetAllIdempotencyKeysResult&gt;): CallbackReference

Retrieves all payment attempt IDs and their respective idempotency keys from local storage.

##### Return

map of payment attempt IDs and idempotency keys, or an error if the merchant is not authorized.

##### Parameters

| | |
|---|---|
| callback | a callback to handle the result of fetching all idempotency keys. |

#### com.squareup.sdk.mobilepayments.payment.PaymentManager.getAvailableCardEntryMethods

abstract fun getAvailableCardEntryMethods(): Set&lt;CardEntryMethod&gt;

Retrieves the possible card entry methods to take a payment. This is the union of all the several card readers' supported card entry methods.

##### Return

the currently-available set of card entry methods, based on the current state of the cardreaders.

#### com.squareup.sdk.mobilepayments.payment.PaymentManager.getIdempotencyKey

abstract fun getIdempotencyKey(paymentAttemptId: String): GetIdempotencyKeyResult

Retrieves the idempotency key used in the payment request associated with the given paymentAttemptId, if the paymentAttemptId was used in the last 24 hours. The returned idempotency key can be used to a cancel a payment via the Square Payments API: https://developer.squareup.com/reference/square/payments-api/cancel-payment-by-idempotency-key

##### Return

the idempotency key associated with the paymentAttemptId, null if not found, or an error if the merchant is not authorized.

##### Parameters

| | |
|---|---|
| paymentAttemptId | the unique identifier for the payment attempt. |

#### com.squareup.sdk.mobilepayments.payment.PaymentManager.getOfflinePaymentQueue

abstract fun getOfflinePaymentQueue(): OfflinePaymentQueue

Returns an OfflinePaymentQueue interface, used to interact with offline payments.

#### com.squareup.sdk.mobilepayments.payment.PaymentManager.setAvailableCardEntryMethodChangedCallback

abstract fun setAvailableCardEntryMethodChangedCallback(callback: Callback&lt;Set&lt;CardEntryMethod&gt;&gt;): CallbackReference

Registers a callback to notify the application when the set of available card entry methods changes. For example, as a magstripe reader is inserted or removed, this callback will be called to reflect the availability of the SWIPED card entry method.

##### Parameters

| | |
|---|---|
| callback | The callback used to notify the app, probably for the purpose of updating a custom prompt UI, when the set of available card entry methods changes. |

#### com.squareup.sdk.mobilepayments.payment.PaymentManager.startPaymentActivity

abstract fun startPaymentActivity(paymentParameters: PaymentParameters, promptParameters: PromptParameters, callback: Callback&lt;PaymentResult&gt;): PaymentHandle

Begins a payment, using the provided paymentParameters to set the payment information.

The promptParameters allow the developer to customize the payment prompt UI and other aspects of the payment flow. See PromptParameters for more information.

A callback is used to notify the application of the completion (whether success or failure). If the payment was successful, meaning that funds were actually paid, the success value is a Payment describing the payment. In case of failure, error description would contain a PaymentErrorCode.

Only one payment may be in progress at a given moment. Making a second call to startPaymentActivity before the first call has triggered the payment callbacks will fail immediately, calling the payment callbacks with PaymentErrorCode.USAGE_ERROR. The first call will continue, however.

##### Return

PaymentHandle can be used for interaction with the just-started payment and for canceling it.

##### Parameters

| | |
|---|---|
| paymentParameters | a description of the payment to be taken |
| promptParameters | a description of how to prompt the user for the payment (e.g. whether the application will draw its own prompt or wants the SDK's default, and what additional methods other than cardreaders should be offered) |
| callback | a callback to handle results of the payment. |

#### com.squareup.sdk.mobilepayments.payment.PaymentManager.IdempotencyKeyData

data class IdempotencyKeyData(val updatedAt: Date, val paymentAttemptId: String, val idempotencyKey: String)

Data retrieved from PaymentManager.getAllIdempotencyKeys.

##### Constructors

| | |
|---|---|
| IdempotencyKeyData | constructor(updatedAt: Date, paymentAttemptId: String, idempotencyKey: String) |

##### Properties

| Name | Summary |
|---|---|
| idempotencyKey | val idempotencyKey: String<br>the idempotency key generated for the payment request associated with the given paymentAttemptId. |
| paymentAttemptId | val paymentAttemptId: String<br>the unique ID of the payment attempt, provided by the developer. |
| updatedAt | val updatedAt: Date<br>the date and time at which the idempotency key was last updated for the given paymentAttemptId. |

### com.squareup.sdk.mobilepayments.payment.PaymentParameters

class PaymentParameters

Parameters to describe a single payment made using Mobile Payments SDK. Use Builder to create and configure payment parameters, for example:

```kotlin
val paymentParameters = PaymentParameters.Builder(
   amount = Money(350, USD),
   processingMode = AUTO_DETECT,
   allowCardSurcharge = true,
   paymentAttemptId = "SK95TM0",
)
   .autocomplete(true)
   .orderId("YZ2319D")
   .tipMoney(Money(100, USD))
   .referenceId("1314387")
   .build()
```

#### Types

| Name | Summary |
|---|---|
| Builder | class Builder(amount: Money, processingMode: ProcessingMode, allowCardSurcharge: Boolean, paymentAttemptId: String)<br>The builder used to create PaymentParameters. An amount of money, processingMode, allowCardSurcharge, and paymentAttemptId are all required to build PaymentParameters. |

#### Properties

| Name | Summary |
|---|---|
| acceptPartialAuthorization | val acceptPartialAuthorization: Boolean<br>Allows successful authorization of a part of the requested amountMoney. Defaults to false. It is necessary to check the returned Payment object to determine the actual amount authorized. |
| allowCardSurcharge | val allowCardSurcharge: Boolean<br>Enable or disable card surcharges for this payment. If `false`, no surcharge is applied to this payment, even if the merchant has configured a card surcharge in the Square Dashboard. If `true`, the card surcharge settings in the Dashboard (if configured) are applied to this payment. |
| amountMoney | val amountMoney: Money<br>The amount of money to accept for this payment, not including tipMoney, but including any appFeeMoney. |
| appFeeMoney | val appFeeMoney: Money?<br>appFeeMoney is an amount of money paid to a marketplace or application developer instead of the selling merchant, as a fee for processing the payment. Square takes the specified portion of the amount from the payment and deposits it in the developer account balance. For payments (including tip) greater than or equal to <br>$5.00, the maximum application fee percentage is 90%. For amounts below $<br>5 the maximum application fee percentage is 60%. |
| autocomplete | val autocomplete: Boolean<br>If set to `true`, this payment will be completed when possible. If set to `false`, this payment is held in an approved state until either explicitly completed or canceled. |
| customerId | val customerId: String?<br>Optionally set to the customer Id of the purchaser. |
| delayAction | val delayAction: DelayAction?<br>The DelayAction to be applied to the payment when the delayDuration has elapsed. Like delayDuration, card payments with autocomplete=true and non-card payments ignore this parameter. |
| delayDuration | val delayDuration: Long?<br>The duration of time after the payment's creation when Square either completes or cancels the payment automatically depending on the delayAction field value, expressed in milliseconds here and truncated to minutes in the payment request. |
| locationId | val locationId: String?<br>Optionally override the location provided when authenticating to Mobile Payments SDK. |
| note | val note: String?<br>An optional note to annotate a payment. |
| orderId | val orderId: String?<br>The order associated with this purchase, or `null` if there is no order. Orders can be manipulated with the Orders API, and associate a transaction with the specific line items purchased in that transaction. |
| paymentAttemptId | val paymentAttemptId: String<br>A unique identifier for the payment attempted with PaymentManager.startPaymentActivity. When provided, Mobile Payments SDK generates a unique idempotency key for the payment request and stores it with the payment attempt ID. If multiple payment requests are made for the same payment attempt (e.g. due to Strong Customer Authentication (SCA) requirements in Europe), the SDK generates a new idempotency key for each request and replaces the stored idempotency key for the payment attempt ID. |
| processingMode | val processingMode: ProcessingMode<br>The processingMode parameter determines whether the current payment needs to be processed online or offline. By default, this will be AUTO_DETECT unless explicitly set. |
| referenceId | val referenceId: String?<br>Optional value that can be used to associate a reference to some external system with this payment. The value is not used by Square. The same value is returned in a successful Payment response. |
| statementDescription | val statementDescription: String?<br>An override of the description line on the buyer's statement. Will be prefixed with Square's "SQ*" prefix, and may be truncated by the bank during generation. |
| teamMemberId | val teamMemberId: String?<br>Optional team member to associate with the payment. |
| tipMoney | val tipMoney: Money?<br>The amount charged as a tip, in addition to amountMoney. |

#### Functions

| Name | Summary |
|---|---|
| buildUpon | fun buildUpon(): PaymentParameters.Builder |

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.acceptPartialAuthorization

val acceptPartialAuthorization: Boolean

Allows successful authorization of a part of the requested amountMoney. Defaults to false. It is necessary to check the returned Payment object to determine the actual amount authorized.

This is typically used for gift cards, in which a 

$20 purchase might be paid for with a $

12 gift card and a second, $8 transaction.

Only one of autocomplete and acceptPartialAuthorization can be true. They can NOT both be true.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.allowCardSurcharge

val allowCardSurcharge: Boolean

Enable or disable card surcharges for this payment. If `false`, no surcharge is applied to this payment, even if the merchant has configured a card surcharge in the Square Dashboard. If `true`, the card surcharge settings in the Dashboard (if configured) are applied to this payment.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.amountMoney

val amountMoney: Money

The amount of money to accept for this payment, not including tipMoney, but including any appFeeMoney.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.appFeeMoney

val appFeeMoney: Money?

appFeeMoney is an amount of money paid to a marketplace or application developer instead of the selling merchant, as a fee for processing the payment. Square takes the specified portion of the amount from the payment and deposits it in the developer account balance. For payments (including tip) greater than or equal to 

$5.00, the maximum application fee percentage is 90%. For amounts below $

5 the maximum application fee percentage is 60%.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.autocomplete

val autocomplete: Boolean

If set to `true`, this payment will be completed when possible. If set to `false`, this payment is held in an approved state until either explicitly completed or canceled.

When set to `false` for card payments, the delayAction and delayDuration fields can be used to configure automatic completion or cancellation of the payment after a specified duration.

Payments can also be completed using PaymentManager.completePayment or canceled using the Square Payments API. See [Cancel payment](https://developer.squareup.com/reference/square/payments-api/cancel-payment).

Only one of autocomplete and acceptPartialAuthorization can be true. They can NOT both be true.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.customerId

val customerId: String?

Optionally set to the customer Id of the purchaser.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.delayAction

val delayAction: DelayAction?

The DelayAction to be applied to the payment when the delayDuration has elapsed. Like delayDuration, card payments with autocomplete=true and non-card payments ignore this parameter.

Default: DelayAction.CANCEL

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.delayDuration

val delayDuration: Long?

The duration of time after the payment's creation when Square either completes or cancels the payment automatically depending on the delayAction field value, expressed in milliseconds here and truncated to minutes in the payment request.

Note: This feature is only supported for card payments. This parameter can only be set for a delayed capture payment (autocomplete=false). If autocomplete=true or a non-card payment (e.g. cash) is attempted, this parameter is ignored.

Default:

- Card-present payments: 36 hours from the creation time.
- Card-not-present payments: 7 days from the creation time.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.locationId

val locationId: String?

Optionally override the location provided when authenticating to Mobile Payments SDK.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.note

val note: String?

An optional note to annotate a payment.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.orderId

val orderId: String?

The order associated with this purchase, or `null` if there is no order. Orders can be manipulated with the Orders API, and associate a transaction with the specific line items purchased in that transaction.

The default value is `null`.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.paymentAttemptId

val paymentAttemptId: String

A unique identifier for the payment attempted with PaymentManager.startPaymentActivity. When provided, Mobile Payments SDK generates a unique idempotency key for the payment request and stores it with the payment attempt ID. If multiple payment requests are made for the same payment attempt (e.g. due to Strong Customer Authentication (SCA) requirements in Europe), the SDK generates a new idempotency key for each request and replaces the stored idempotency key for the payment attempt ID.

To retrieve the final idempotency key used in a payment attempt, refer to PaymentManager.getIdempotencyKey.

This field must be non-empty.If an empty string is provided an IllegalArgumentException will be thrown.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.processingMode

val processingMode: ProcessingMode

The processingMode parameter determines whether the current payment needs to be processed online or offline. By default, this will be AUTO_DETECT unless explicitly set.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.referenceId

val referenceId: String?

Optional value that can be used to associate a reference to some external system with this payment. The value is not used by Square. The same value is returned in a successful Payment response.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.statementDescription

val statementDescription: String?

An override of the description line on the buyer's statement. Will be prefixed with Square's "SQ*" prefix, and may be truncated by the bank during generation.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.teamMemberId

val teamMemberId: String?

Optional team member to associate with the payment.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.tipMoney

val tipMoney: Money?

The amount charged as a tip, in addition to amountMoney.

#### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder

class Builder(amount: Money, processingMode: ProcessingMode, allowCardSurcharge: Boolean, paymentAttemptId: String)

The builder used to create PaymentParameters. An amount of money, processingMode, allowCardSurcharge, and paymentAttemptId are all required to build PaymentParameters.

##### Constructors

| | |
|---|---|
| Builder | constructor(amount: Money, processingMode: ProcessingMode, allowCardSurcharge: Boolean, paymentAttemptId: String) |

##### Functions

| Name | Summary |
|---|---|
| acceptPartialAuthorization | fun acceptPartialAuthorization(acceptPartialAuthorization: Boolean): PaymentParameters.Builder<br>Allows successful authorization of a part of the requested amountMoney. Defaults to false. |
| appFeeMoney | fun appFeeMoney(amount: Money?): PaymentParameters.Builder<br>Records a fee to the app developer, taken from amountMoney. |
| autocomplete | fun autocomplete(autoComplete: Boolean): PaymentParameters.Builder<br>Controls whether this payment will, when made, be completed (`true`) or only authorized (`false`). Payments that are only authorized need to be either completed or canceled later, using the Connect v2 CompletePayment API and passing the `payment_id` returned from authorization. |
| build | fun build(): PaymentParameters |
| customerId | fun customerId(customerId: String?): PaymentParameters.Builder<br>Associates a customer to the payment being constructed by this builder. |
| delayAction | fun delayAction(delayAction: DelayAction?): PaymentParameters.Builder<br>Sets the action taken, for payments with autocomplete equal to false, after the payment's delayDuration has expired. Default is DelayAction.CANCEL if not explicitly set. |
| delayDuration | fun delayDuration(delayDuration: Long?): PaymentParameters.Builder<br>Sets the duration between payment creation and automatic cancellation, for payments with autocomplete equal to false. |
| locationId | fun locationId(locationId: String?): PaymentParameters.Builder<br>Sets the location ID of the location taking this payment. Defaults to the location id from authorization. |
| note | fun note(note: String?): PaymentParameters.Builder<br>Sets an arbitrary note onto the payment. |
| orderId | fun orderId(orderId: String?): PaymentParameters.Builder<br>Associates an order to the payment being constructed by this builder. |
| referenceId | fun referenceId(referenceId: String?): PaymentParameters.Builder<br>Associates an arbitrary reference to the payment being constructed by this builder. |
| statementDescription | fun statementDescription(description: String?): PaymentParameters.Builder<br>Assigns a statement description string. |
| teamMemberId | fun teamMemberId(teamMemberId: String?): PaymentParameters.Builder<br>Sets the TeamMember ID to associate with this payment. |
| tipMoney | fun tipMoney(amount: Money?): PaymentParameters.Builder<br>Adds a tip amount to the builder, an amount in addition to amountMoney treated as a tip. |

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.acceptPartialAuthorization

fun acceptPartialAuthorization(acceptPartialAuthorization: Boolean): PaymentParameters.Builder

Allows successful authorization of a part of the requested amountMoney. Defaults to false.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.appFeeMoney

fun appFeeMoney(amount: Money?): PaymentParameters.Builder

Records a fee to the app developer, taken from amountMoney.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.autocomplete

fun autocomplete(autoComplete: Boolean): PaymentParameters.Builder

Controls whether this payment will, when made, be completed (`true`) or only authorized (`false`). Payments that are only authorized need to be either completed or canceled later, using the Connect v2 CompletePayment API and passing the `payment_id` returned from authorization.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.customerId

fun customerId(customerId: String?): PaymentParameters.Builder

Associates a customer to the payment being constructed by this builder.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.delayAction

fun delayAction(delayAction: DelayAction?): PaymentParameters.Builder

Sets the action taken, for payments with autocomplete equal to false, after the payment's delayDuration has expired. Default is DelayAction.CANCEL if not explicitly set.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.delayDuration

fun delayDuration(delayDuration: Long?): PaymentParameters.Builder

Sets the duration between payment creation and automatic cancellation, for payments with autocomplete equal to false.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.locationId

fun locationId(locationId: String?): PaymentParameters.Builder

Sets the location ID of the location taking this payment. Defaults to the location id from authorization.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.note

fun note(note: String?): PaymentParameters.Builder

Sets an arbitrary note onto the payment.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.orderId

fun orderId(orderId: String?): PaymentParameters.Builder

Associates an order to the payment being constructed by this builder.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.referenceId

fun referenceId(referenceId: String?): PaymentParameters.Builder

Associates an arbitrary reference to the payment being constructed by this builder.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.statementDescription

fun statementDescription(description: String?): PaymentParameters.Builder

Assigns a statement description string.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.teamMemberId

fun teamMemberId(teamMemberId: String?): PaymentParameters.Builder

Sets the TeamMember ID to associate with this payment.

##### com.squareup.sdk.mobilepayments.payment.PaymentParameters.Builder.tipMoney

fun tipMoney(amount: Money?): PaymentParameters.Builder

Adds a tip amount to the builder, an amount in addition to amountMoney treated as a tip.

### com.squareup.sdk.mobilepayments.payment.PaymentProcessingFee

class PaymentProcessingFee(val effectiveAt: Date, val type: PaymentProcessingFee.Type, val amountMoney: Money)

Processing fees and fee adjustments assessed by Square on this payment.

#### Parameters

| | |
|---|---|
| effectiveAt | The date and time when the fee takes effect, in Date format. |
| type | Type of the fee. |
| amountMoney | Amount of the fee in Money format. |

#### Constructors

| | |
|---|---|
| PaymentProcessingFee | constructor(effectiveAt: Date, type: PaymentProcessingFee.Type, amountMoney: Money) |

#### Types

| Name | Summary |
|---|---|
| Type | enum Type : Enum&lt;PaymentProcessingFee.Type&gt; |

#### Properties

| Name | Summary |
|---|---|
| amountMoney | val amountMoney: Money |
| effectiveAt | val effectiveAt: Date |
| type | val type: PaymentProcessingFee.Type |

#### com.squareup.sdk.mobilepayments.payment.PaymentProcessingFee.amountMoney

val amountMoney: Money

##### Parameters

| | |
|---|---|
| amountMoney | Amount of the fee in Money format. |

#### com.squareup.sdk.mobilepayments.payment.PaymentProcessingFee.effectiveAt

val effectiveAt: Date

##### Parameters

| | |
|---|---|
| effectiveAt | The date and time when the fee takes effect, in Date format. |

#### com.squareup.sdk.mobilepayments.payment.PaymentProcessingFee.type

val type: PaymentProcessingFee.Type

##### Parameters

| | |
|---|---|
| type | Type of the fee. |

#### com.squareup.sdk.mobilepayments.payment.PaymentProcessingFee.Type

enum Type : Enum&lt;PaymentProcessingFee.Type&gt;

##### Entries

| | |
|---|---|
| INITIAL | INITIAL<br>Initial fee assessed. |
| ADJUSTMENT | ADJUSTMENT<br>Fee adjustment, if any. |

##### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;PaymentProcessingFee.Type&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

##### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): PaymentProcessingFee.Type<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;PaymentProcessingFee.Type&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

##### com.squareup.sdk.mobilepayments.payment.PaymentProcessingFee.Type.entries

val entries: EnumEntries&lt;PaymentProcessingFee.Type&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

##### com.squareup.sdk.mobilepayments.payment.PaymentProcessingFee.Type.valueOf

fun valueOf(value: String): PaymentProcessingFee.Type

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

###### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

##### com.squareup.sdk.mobilepayments.payment.PaymentProcessingFee.Type.values

fun values(): Array&lt;PaymentProcessingFee.Type&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.PaymentSettings

data class PaymentSettings(val isOfflineProcessingAllowed: Boolean, val offlineTransactionAmountLimit: Money?, val offlineTotalStoredAmountLimit: Money?)

Read-only settings that provide payment settings based on the current authenticated seller.

#### Constructors

| | |
|---|---|
| PaymentSettings | constructor(isOfflineProcessingAllowed: Boolean, offlineTransactionAmountLimit: Money?, offlineTotalStoredAmountLimit: Money?) |

#### Properties

| Name | Summary |
|---|---|
| isOfflineProcessingAllowed | val isOfflineProcessingAllowed: Boolean<br>Whether taking payments offline is allowed for the current seller. |
| offlineTotalStoredAmountLimit | val offlineTotalStoredAmountLimit: Money?<br>The total allowable amount of all offline payments combined on this device. A payment that would exceed the total limit will be ineligible for offline processing. This will be `null` if offline processing is not allowed. |
| offlineTransactionAmountLimit | val offlineTransactionAmountLimit: Money?<br>The maximum amount that can be processed in a single offline transaction. A payment that exceeds this limit will be ineligible for offline processing. This will be `null` if offline processing is not allowed. |

#### com.squareup.sdk.mobilepayments.payment.PaymentSettings.isOfflineProcessingAllowed

val isOfflineProcessingAllowed: Boolean

Whether taking payments offline is allowed for the current seller.

#### com.squareup.sdk.mobilepayments.payment.PaymentSettings.offlineTotalStoredAmountLimit

val offlineTotalStoredAmountLimit: Money?

The total allowable amount of all offline payments combined on this device. A payment that would exceed the total limit will be ineligible for offline processing. This will be `null` if offline processing is not allowed.

#### com.squareup.sdk.mobilepayments.payment.PaymentSettings.offlineTransactionAmountLimit

val offlineTransactionAmountLimit: Money?

The maximum amount that can be processed in a single offline transaction. A payment that exceeds this limit will be ineligible for offline processing. This will be `null` if offline processing is not allowed.

### com.squareup.sdk.mobilepayments.payment.ProcessingMode

enum ProcessingMode : Enum&lt;ProcessingMode&gt; 

PaymentParameters "processingMode" parameter will determine whether the current payment needs to be processed online or offline.

#### Entries

| | |
|---|---|
| ONLINE_ONLY | ONLINE_ONLY<br>In ONLINE_ONLY mode, the payment can only be processed via network call. In most usage, this option is discouraged because it is fragile to network and server problems. It is appropriate, however, if a developer's application cannot support Payment.OfflinePayment or if it is more important to secure confirmed success than to support resiliency, for example by using AUTO_DETECT instead. |
| OFFLINE_ONLY | OFFLINE_ONLY<br>In OFFLINE_ONLY mode, the payment will be stored in the database, even if connectivity is OK. This can offer a faster user experience, but is riskier because the customer will probably have left the shop and disappeared before the bank can approve or deny the offline payment. |
| AUTO_DETECT | AUTO_DETECT<br>In AUTO_DETECT mode, we will verify the status of the network and Square systems health before processing the payment and determine whether it needs to be processed online or offline. This is the preferred processing mode. If the systems are healthy, or if the merchant settings or payment amount require online processing, that will be used as if ONLINE_ONLY had been provided. However, assuming settings and amount allow it, network or server issues will instead trigger offline processing as if by OFFLINE_ONLY. |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;ProcessingMode&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): ProcessingMode<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;ProcessingMode&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.payment.ProcessingMode.entries

val entries: EnumEntries&lt;ProcessingMode&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.payment.ProcessingMode.valueOf

fun valueOf(value: String): ProcessingMode

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.payment.ProcessingMode.values

fun values(): Array&lt;ProcessingMode&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.PromptMode

enum PromptMode : Enum&lt;PromptMode&gt; 

Specifies whether to display the DEFAULT Square-provided payment prompt UI or a CUSTOM UI provided by the developer.

#### Entries

| | |
|---|---|
| DEFAULT | DEFAULT |
| CUSTOM | CUSTOM |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;PromptMode&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): PromptMode<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;PromptMode&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.payment.PromptMode.entries

val entries: EnumEntries&lt;PromptMode&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.payment.PromptMode.valueOf

fun valueOf(value: String): PromptMode

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.payment.PromptMode.values

fun values(): Array&lt;PromptMode&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.payment.PromptParameters

class PromptParameters(val mode: PromptMode = PromptMode.DEFAULT, val additionalPaymentMethods: List&lt;AdditionalPaymentMethod.Type&gt; = AdditionalPaymentMethod.allPaymentMethods)

Parameters for configuring the payment prompt UI. Includes:

#### Constructors

| | |
|---|---|
| PromptParameters | constructor(mode: PromptMode = PromptMode.DEFAULT, additionalPaymentMethods: List&lt;AdditionalPaymentMethod.Type&gt; = AdditionalPaymentMethod.allPaymentMethods) |

#### Properties

| Name | Summary |
|---|---|
| additionalPaymentMethods | val additionalPaymentMethods: List&lt;AdditionalPaymentMethod.Type&gt;<br>A list of additional payment methods that the buyer can use to pay, besides card payments. It's not guaranteed that the payment prompt will have these methods, but it's guaranteed that there will be no additional methods not in this list. These methods will be included in the PaymentHandle.additionalPaymentMethods. Default is all available payment methods - see AdditionalPaymentMethod.allPaymentMethods. |
| mode | val mode: PromptMode<br>The mode of the payment prompt UI. When set to PromptMode.DEFAULT, Mobile Payments SDK will immediately "take over" screen display (as another Android activity) to display a payment prompt screen. If set to PromptMode.CUSTOM, the developer's provided payment prompt screen will be displayed, and Mobile Payment SDK will "take over" screen display after the buyer has initiated a payment (e.g. inserting a card). Default is PromptMode.DEFAULT. |

## com.squareup.sdk.mobilepayments.settings

Classes to manage Mobile Payments SDK settings.

### com.squareup.sdk.mobilepayments.settings.Environment

enum Environment : Enum&lt;Environment&gt; 

The environment that SDK has been initialized in.

This value indicates the environment of the SDK based on the Square application ID used during SDK initialization - PRODUCTION for a production ID and SANDBOX for a sandbox ID.

#### Entries

| | |
|---|---|
| PRODUCTION | PRODUCTION |
| SANDBOX | SANDBOX |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;Environment&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): Environment<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;Environment&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.settings.Environment.entries

val entries: EnumEntries&lt;Environment&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.settings.Environment.valueOf

fun valueOf(value: String): Environment

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.settings.Environment.values

fun values(): Array&lt;Environment&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.settings.SdkSettings

data class SdkSettings(val sdkVersion: String, val sdkEnvironment: Environment, val securityComplianceVersion: String, val mpocVersion: String)

#### Parameters

| | |
|---|---|
| sdkVersion | Mobile Payments SDK version. |
| sdkEnvironment | Mobile Payments SDK environment. |
| securityComplianceVersion | the current security compliance version of Mobile Payments SDK |
| mpocVersion | the current MPoC version of Mobile Payments SDK |

#### Constructors

| | |
|---|---|
| SdkSettings | constructor(sdkVersion: String, sdkEnvironment: Environment, securityComplianceVersion: String, mpocVersion: String) |

#### Properties

| Name | Summary |
|---|---|
| mpocVersion | val mpocVersion: String |
| sdkEnvironment | val sdkEnvironment: Environment |
| sdkVersion | val sdkVersion: String |
| securityComplianceVersion | val securityComplianceVersion: String |

#### com.squareup.sdk.mobilepayments.settings.SdkSettings.mpocVersion

val mpocVersion: String

##### Parameters

| | |
|---|---|
| mpocVersion | the current MPoC version of Mobile Payments SDK |

#### com.squareup.sdk.mobilepayments.settings.SdkSettings.sdkEnvironment

val sdkEnvironment: Environment

##### Parameters

| | |
|---|---|
| sdkEnvironment | Mobile Payments SDK environment. |

#### com.squareup.sdk.mobilepayments.settings.SdkSettings.sdkVersion

val sdkVersion: String

##### Parameters

| | |
|---|---|
| sdkVersion | Mobile Payments SDK version. |

#### com.squareup.sdk.mobilepayments.settings.SdkSettings.securityComplianceVersion

val securityComplianceVersion: String

##### Parameters

| | |
|---|---|
| securityComplianceVersion | the current security compliance version of Mobile Payments SDK |

### com.squareup.sdk.mobilepayments.settings.SettingsClosed

data object SettingsClosed

Indicates that the settings screen has been closed.

### com.squareup.sdk.mobilepayments.settings.SettingsErrorCode

enum SettingsErrorCode : ErrorCode, Enum&lt;SettingsErrorCode&gt;

#### Entries

| | |
|---|---|
| USAGE_ERROR | USAGE_ERROR<br>MobilePaymentsSdk.showSettings was used in an unexpected or unsupported way. See the debug code and debug message for more information. |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;SettingsErrorCode&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| isUsageError | open override val isUsageError: Boolean<br>Returns `true` if the error is a usage error, `false` otherwise. |
| name | val name: String<br>Returns the name of the error code. |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): SettingsErrorCode<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;SettingsErrorCode&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.settings.SettingsErrorCode.entries

val entries: EnumEntries&lt;SettingsErrorCode&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.settings.SettingsErrorCode.isUsageError

open override val isUsageError: Boolean

Returns `true` if the error is a usage error, `false` otherwise.

Useful for writing shared handling of debug codes and messages across Mobile Payments SDK operations.

#### com.squareup.sdk.mobilepayments.settings.SettingsErrorCode.valueOf

fun valueOf(value: String): SettingsErrorCode

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.settings.SettingsErrorCode.values

fun values(): Array&lt;SettingsErrorCode&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

### com.squareup.sdk.mobilepayments.settings.SettingsManager

interface SettingsManager

Provides information about the Mobile Payments SDK, such as the SDK version and environment. Also provides access to the payment settings, such as if offline processing is allowed. Additionally, you can display the Square-provided settings screen.

#### Properties

| Name | Summary |
|---|---|
| trackingConsentState | abstract val trackingConsentState: TrackingConsentState<br>The current state of user consent for analytics and performance tracking. This field is changed when consent is updated, either through updateTrackingConsent or through the SDK's built-in consent request (shown when users first visit the payment or settings screen, if no consent was previously provided via API). |

#### Functions

| Name | Summary |
|---|---|
| closeSettings | abstract fun closeSettings(): Boolean<br>Programmatically closes the settings screen if it is currently being displayed. |
| getPaymentSettings | abstract fun getPaymentSettings(): PaymentSettings<br>Returns a PaymentSettings, used to determine if offline processing is allowed. |
| getSdkSettings | abstract fun getSdkSettings(): SdkSettings<br>Returns a SdkSettings, used to determine the SDK version and environment. |
| isShowingSettings | abstract fun isShowingSettings(): Boolean<br>Returns `true` if the settings screen is currently being displayed. |
| showSettings | abstract fun showSettings(onResult: (SettingsResult) -&gt; Unit)<br>Used to display the Mobile Payments SDK settings screen. |
| updateTrackingConsent | abstract fun updateTrackingConsent(granted: Boolean)<br>Enables or disables analytics and performance tracking for the Mobile Payments SDK based on user consent. When granted is set to `true`, the SDK will collect data to monitor metrics and performance. |

#### com.squareup.sdk.mobilepayments.settings.SettingsManager.closeSettings

abstract fun closeSettings(): Boolean

Programmatically closes the settings screen if it is currently being displayed.

Returns `true` if the settings screen was open and has been closed, or `false` if the settings screen was not open.

This is useful for scenarios where the host app needs to dismiss the settings screen programmatically, for example when re-entering kiosk mode or responding to external events. The showSettings`onResult` callback will still be invoked with a success result when the settings screen is closed via this method.

#### com.squareup.sdk.mobilepayments.settings.SettingsManager.getPaymentSettings

abstract fun getPaymentSettings(): PaymentSettings

Returns a PaymentSettings, used to determine if offline processing is allowed.

#### com.squareup.sdk.mobilepayments.settings.SettingsManager.getSdkSettings

abstract fun getSdkSettings(): SdkSettings

Returns a SdkSettings, used to determine the SDK version and environment.

#### com.squareup.sdk.mobilepayments.settings.SettingsManager.isShowingSettings

abstract fun isShowingSettings(): Boolean

Returns `true` if the settings screen is currently being displayed.

This can be used to check whether the settings screen is visible before attempting to show it again, or to coordinate app UI state with the settings screen lifecycle.

#### com.squareup.sdk.mobilepayments.settings.SettingsManager.showSettings

abstract fun showSettings(onResult: (SettingsResult) -&gt; Unit)

Used to display the Mobile Payments SDK settings screen.

##### Parameters

| | |
|---|---|
| onResult | Callback to receive the result of the settings screen. If successful then the settings screen was closed, if not successful then an error occurred while attempting to show the settings screen. |

#### com.squareup.sdk.mobilepayments.settings.SettingsManager.trackingConsentState

abstract val trackingConsentState: TrackingConsentState

The current state of user consent for analytics and performance tracking. This field is changed when consent is updated, either through updateTrackingConsent or through the SDK's built-in consent request (shown when users first visit the payment or settings screen, if no consent was previously provided via API).

#### com.squareup.sdk.mobilepayments.settings.SettingsManager.updateTrackingConsent

abstract fun updateTrackingConsent(granted: Boolean)

Enables or disables analytics and performance tracking for the Mobile Payments SDK based on user consent. When granted is set to `true`, the SDK will collect data to monitor metrics and performance.

Note: this consent mechanism only applies in countries where user consent required for analytics tracking.

### com.squareup.sdk.mobilepayments.settings.TrackingConsentState

enum TrackingConsentState : Enum&lt;TrackingConsentState&gt; 

Tracks user consent for analytics and data collection.

#### Entries

| | |
|---|---|
| PENDING | PENDING<br>Initial state indicating that consent has not been requested from the user. |
| GRANTED | GRANTED<br>The user has granted consent. Logging and data collection are allowed. |
| DENIED | DENIED<br>The user has denied consent. Logging and data collection are prohibited. |
| NOT_REQUIRED | NOT_REQUIRED<br>Consent is not required, typically because the user is not in a jurisdiction where consent is mandatory for data collection. |

#### Properties

| Name | Summary |
|---|---|
| entries | val entries: EnumEntries&lt;TrackingConsentState&gt;<br>Returns a representation of an immutable list of all enum entries, in the order they're declared. |
| name | val name: String |
| ordinal | val ordinal: Int |

#### Functions

| Name | Summary |
|---|---|
| valueOf | fun valueOf(value: String): TrackingConsentState<br>Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.) |
| values | fun values(): Array&lt;TrackingConsentState&gt;<br>Returns an array containing the constants of this enum type, in the order they're declared. |

#### com.squareup.sdk.mobilepayments.settings.TrackingConsentState.entries

val entries: EnumEntries&lt;TrackingConsentState&gt;

Returns a representation of an immutable list of all enum entries, in the order they're declared.

This method may be used to iterate over the enum entries.

#### com.squareup.sdk.mobilepayments.settings.TrackingConsentState.valueOf

fun valueOf(value: String): TrackingConsentState

Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)

##### Throws

| | |
|---|---|
| IllegalArgumentException | if this enum type has no constant with the specified name |

#### com.squareup.sdk.mobilepayments.settings.TrackingConsentState.values

fun values(): Array&lt;TrackingConsentState&gt;

Returns an array containing the constants of this enum type, in the order they're declared.

This method may be used to iterate over the constants.

