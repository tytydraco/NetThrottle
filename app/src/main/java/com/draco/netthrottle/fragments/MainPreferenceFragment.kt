package com.draco.netthrottle.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.ColorFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.draco.netthrottle.R
import com.draco.netthrottle.repositories.constants.SettingsConstants
import com.draco.netthrottle.repositories.constants.SettingsNamespaces
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.google.android.material.snackbar.Snackbar

class MainPreferenceFragment : PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {
    private lateinit var dataActivityTimeoutWifi: EditTextPreference
    private lateinit var wifiBadgingThresholds: EditTextPreference
    private lateinit var wifiFrameworkScanIntervalMs: EditTextPreference
    private lateinit var wifiIdleMs: EditTextPreference
    private lateinit var speedLabelCacheEvictionAgeMillis: EditTextPreference
    private lateinit var wifiSupplicantScanIntervalMs: EditTextPreference
    private lateinit var wifiWatchdogPoorNetworkTestEnabled: EditTextPreference
    private lateinit var wifiMaxDHCPRetryCount: EditTextPreference
    private lateinit var wifiEphemeralOutOfRangeTimeoutMs: EditTextPreference
    private lateinit var wifiBounceDelayOverrideMs: EditTextPreference

    private lateinit var dataActivityTimeoutMobile: EditTextPreference
    private lateinit var wifiMobileDataTransitionWakelockTimeoutMs: EditTextPreference
    private lateinit var mdcInitialMaxRetry: EditTextPreference
    private lateinit var pdpWatchdogPollIntervalMs: EditTextPreference
    private lateinit var pdpWatchdogLongPollIntervalMs: EditTextPreference
    private lateinit var pdpWatchdogErrorPollIntervalMs: EditTextPreference
    private lateinit var pdpWatchdogTriggerPacketCount: EditTextPreference
    private lateinit var pdpWatchdogErrorPollCount: EditTextPreference
    private lateinit var pdpWatchdogMaxPdpResetFailCount: EditTextPreference
    private lateinit var dataStallAlarmNonAggressiveDelayInMs: EditTextPreference
    private lateinit var dataStallAlarmAggressiveDelayInMs: EditTextPreference
    private lateinit var dataStallRecoveryOnBadNetwork: EditTextPreference
    private lateinit var minDurationBetweenRecoverySteps: EditTextPreference
    private lateinit var provisioningApnAlarmDelayInMs: EditTextPreference
    private lateinit var gprsRegisterCheckPeriodMs: EditTextPreference

    private lateinit var netStatsEnabled: EditTextPreference
    private lateinit var netPolicyQuotaEnabled: EditTextPreference
    private lateinit var tcpDefaultInitRWND: EditTextPreference
    private lateinit var nsdOn: EditTextPreference
    private lateinit var inetConditionDebounceUpDelay: EditTextPreference
    private lateinit var inetConditionDebounceDownDelay: EditTextPreference
    private lateinit var ephemeralCookieMaxSizeBytes: EditTextPreference
    private lateinit var syncMaxRetryDelayInSeconds: EditTextPreference
    private lateinit var connectivitySamplingIntervalInSeconds: EditTextPreference
    private lateinit var networkAccessTimeoutMs: EditTextPreference

    private lateinit var locationBackgroundThrottleIntervalMs: EditTextPreference
    private lateinit var locationBackgroundThrottleProximityAlertIntervalMs: EditTextPreference
    private lateinit var locationAccessCheckIntervalMillis: EditTextPreference
    private lateinit var locationAccessCheckDelayMillis: EditTextPreference

    private lateinit var enableRadioBugDetection: EditTextPreference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.main, rootKey)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dataActivityTimeoutWifi = findPreference(getString(R.string.pref_profile_key_data_activity_timeout_wifi))!!
        wifiBadgingThresholds = findPreference(getString(R.string.pref_profile_key_wifi_badging_thresholds))!!
        wifiFrameworkScanIntervalMs = findPreference(getString(R.string.pref_profile_key_wifi_framework_scan_interval_ms))!!
        wifiIdleMs = findPreference(getString(R.string.pref_profile_key_wifi_idle_ms))!!
        speedLabelCacheEvictionAgeMillis = findPreference(getString(R.string.pref_profile_key_speed_label_cache_eviction_age_millis))!!
        wifiSupplicantScanIntervalMs = findPreference(getString(R.string.pref_profile_key_wifi_supplicant_scan_interval_ms))!!
        wifiWatchdogPoorNetworkTestEnabled = findPreference(getString(R.string.pref_profile_key_wifi_watchdog_poor_network_test_enabled))!!
        wifiMaxDHCPRetryCount = findPreference(getString(R.string.pref_profile_key_wifi_max_dhcp_retry_count))!!
        wifiEphemeralOutOfRangeTimeoutMs = findPreference(getString(R.string.pref_profile_key_wifi_ephemeral_out_of_range_timeout_ms))!!
        wifiBounceDelayOverrideMs = findPreference(getString(R.string.pref_profile_key_wifi_bounce_delay_override_ms))!!

        dataActivityTimeoutMobile = findPreference(getString(R.string.pref_profile_key_data_activity_timeout_mobile))!!
        wifiMobileDataTransitionWakelockTimeoutMs = findPreference(getString(R.string.pref_profile_key_wifi_mobile_data_transition_wakelock_timeout_ms))!!
        mdcInitialMaxRetry = findPreference(getString(R.string.pref_profile_key_mdc_initial_max_retry))!!
        pdpWatchdogPollIntervalMs = findPreference(getString(R.string.pref_profile_key_pdp_watchdog_poll_interval_ms))!!
        pdpWatchdogLongPollIntervalMs = findPreference(getString(R.string.pref_profile_key_pdp_watchdog_long_poll_interval_ms))!!
        pdpWatchdogErrorPollIntervalMs = findPreference(getString(R.string.pref_profile_key_pdp_watchdog_error_poll_interval_ms))!!
        pdpWatchdogTriggerPacketCount = findPreference(getString(R.string.pref_profile_key_pdp_watchdog_trigger_packet_count))!!
        pdpWatchdogErrorPollCount = findPreference(getString(R.string.pref_profile_key_pdp_watchdog_error_poll_count))!!
        pdpWatchdogMaxPdpResetFailCount = findPreference(getString(R.string.pref_profile_key_pdp_watchdog_max_pdp_reset_fail_count))!!
        dataStallAlarmNonAggressiveDelayInMs = findPreference(getString(R.string.pref_profile_key_data_stall_alarm_non_aggressive_delay_in_ms))!!
        dataStallAlarmAggressiveDelayInMs = findPreference(getString(R.string.pref_profile_key_data_stall_alarm_aggressive_delay_in_ms))!!
        dataStallRecoveryOnBadNetwork = findPreference(getString(R.string.pref_profile_key_data_stall_recovery_on_bad_network))!!
        minDurationBetweenRecoverySteps = findPreference(getString(R.string.pref_profile_key_min_duration_between_recovery_steps))!!
        provisioningApnAlarmDelayInMs = findPreference(getString(R.string.pref_profile_key_provisioning_apn_alarm_delay_in_ms))!!
        gprsRegisterCheckPeriodMs = findPreference(getString(R.string.pref_profile_key_gprs_register_check_period_ms))!!

        netStatsEnabled = findPreference(getString(R.string.pref_profile_key_netstats_enabled))!!
        netPolicyQuotaEnabled = findPreference(getString(R.string.pref_profile_key_netpolicy_quota_enabled))!!
        tcpDefaultInitRWND = findPreference(getString(R.string.pref_profile_key_tcp_default_init_rwnd))!!
        nsdOn = findPreference(getString(R.string.pref_profile_key_nsd_on))!!
        inetConditionDebounceUpDelay = findPreference(getString(R.string.pref_profile_key_inet_condition_debounce_up_delay))!!
        inetConditionDebounceDownDelay = findPreference(getString(R.string.pref_profile_key_inet_condition_debounce_down_delay))!!
        ephemeralCookieMaxSizeBytes = findPreference(getString(R.string.pref_profile_key_ephemeral_cookie_max_size_bytes))!!
        syncMaxRetryDelayInSeconds = findPreference(getString(R.string.pref_profile_key_sync_max_retry_delay_in_seconds))!!
        connectivitySamplingIntervalInSeconds = findPreference(getString(R.string.pref_profile_key_connectivity_sampling_interval_in_seconds))!!
        networkAccessTimeoutMs = findPreference(getString(R.string.pref_profile_key_network_access_timeout_ms))!!

        locationBackgroundThrottleIntervalMs = findPreference(getString(R.string.pref_profile_key_location_background_throttle_interval_ms))!!
        locationBackgroundThrottleProximityAlertIntervalMs = findPreference(getString(R.string.pref_profile_key_location_background_throttle_proximity_alert_interval_ms))!!
        locationAccessCheckIntervalMillis = findPreference(getString(R.string.pref_profile_key_location_access_check_interval_millis))!!
        locationAccessCheckDelayMillis = findPreference(getString(R.string.pref_profile_key_location_access_check_delay_millis))!!

        enableRadioBugDetection = findPreference(getString(R.string.pref_profile_key_enable_radio_bug_detection))!!

        refreshSettings()
        lockSettings()
    }

    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        when (preference.key) {
            getString(R.string.pref_developer_key) -> openURL(getString(R.string.developer_url))
            getString(R.string.pref_source_key) -> openURL(getString(R.string.source_url))
            getString(R.string.pref_contact_key) -> openURL(getString(R.string.contact_url))
            getString(R.string.pref_licenses_key) -> {
                val intent = Intent(requireContext(), OssLicensesMenuActivity::class.java)
                startActivity(intent)
            }
            else -> return super.onPreferenceTreeClick(preference)
        }
        return true
    }

    /**
     * Lock specific settings if the Android version does not support it
     */
    private fun lockSettings() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            dataStallRecoveryOnBadNetwork.isVisible = false
            minDurationBetweenRecoverySteps.isVisible = false
            enableRadioBugDetection.isVisible = false
            locationAccessCheckIntervalMillis.isVisible = false
            locationAccessCheckDelayMillis.isVisible = false
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P)
            netPolicyQuotaEnabled.isVisible = false

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O_MR1)
            speedLabelCacheEvictionAgeMillis.isVisible = false
    }

    /**
     * Open a URL for the user
     */
    private fun openURL(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        try {
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
            Snackbar.make(requireView(), getString(R.string.snackbar_intent_failed), Snackbar.LENGTH_SHORT).show()
        }
    }

    /**
     * Update the icon beside the setting to alert the user if this is set or not
     */
    private fun updateSettingUnsetTag(setting: EditTextPreference) {
        setting.icon.colorFilter = if (setting.text.isNullOrBlank())
            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                Color.GRAY,
                BlendModeCompat.SRC_ATOP
            )
        else null
    }

    /**
     * Helper for fetching current setting
     */
    private fun refreshSettingViaConstant(setting: EditTextPreference, constant: String, namespace: Int) {
        val contentResolver = requireContext().contentResolver

        val constValue = when (namespace) {
            SettingsNamespaces.GLOBAL -> Settings.Global.getString(contentResolver, constant)
            SettingsNamespaces.SYSTEM -> Settings.System.getString(contentResolver, constant)
            SettingsNamespaces.SECURE -> Settings.Secure.getString(contentResolver, constant)
            else -> null
        }

        setting.text = constValue
        updateSettingUnsetTag(setting)
    }

    /**
     * Helper for applying current setting
     */
    private fun applySettingViaConstant(setting: EditTextPreference, constant: String, namespace: Int) {
        val contentResolver = requireContext().contentResolver

        updateSettingUnsetTag(setting)

        val constVal = setting.text ?: return
        try {
            when (namespace) {
                SettingsNamespaces.GLOBAL -> Settings.Global.putString(contentResolver, constant, constVal)
                SettingsNamespaces.SYSTEM -> Settings.System.putString(contentResolver, constant, constVal)
                SettingsNamespaces.SECURE -> Settings.Secure.putString(contentResolver, constant, constVal)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Snackbar.make(requireView(), getString(R.string.snackbar_failed_to_apply), Snackbar.LENGTH_SHORT).show()
        }
    }

    /**
     * Update the UI to show the new constants
     */
    private fun refreshSettings() {
        refreshSettingViaConstant(dataActivityTimeoutWifi, SettingsConstants.Global.DATA_ACTIVITY_TIMEOUT_WIFI, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(wifiBadgingThresholds, SettingsConstants.Global.WIFI_BADGING_THRESHOLDS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(wifiFrameworkScanIntervalMs, SettingsConstants.Global.WIFI_FRAMEWORK_SCAN_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(wifiIdleMs, SettingsConstants.Global.WIFI_IDLE_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(speedLabelCacheEvictionAgeMillis, SettingsConstants.Global.SPEED_LABEL_CACHE_EVICTION_AGE_MILLIS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(wifiSupplicantScanIntervalMs, SettingsConstants.Global.WIFI_SUPPLICANT_SCAN_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(wifiWatchdogPoorNetworkTestEnabled, SettingsConstants.Global.WIFI_WATCHDOG_POOR_NETWORK_TEST_ENABLED, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(wifiMaxDHCPRetryCount, SettingsConstants.Global.WIFI_MAX_DHCP_RETRY_COUNT, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(wifiEphemeralOutOfRangeTimeoutMs, SettingsConstants.Global.WIFI_EPHEMERAL_OUT_OF_RANGE_TIMEOUT_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(wifiBounceDelayOverrideMs, SettingsConstants.Global.WIFI_BOUNCE_DELAY_OVERRIDE_MS, SettingsNamespaces.GLOBAL)

        refreshSettingViaConstant(dataActivityTimeoutMobile, SettingsConstants.Global.DATA_ACTIVITY_TIMEOUT_MOBILE, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(wifiMobileDataTransitionWakelockTimeoutMs, SettingsConstants.Global.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(mdcInitialMaxRetry, SettingsConstants.Global.MDC_INITIAL_MAX_RETRY, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(pdpWatchdogPollIntervalMs, SettingsConstants.Global.PDP_WATCHDOG_POLL_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(pdpWatchdogLongPollIntervalMs, SettingsConstants.Global.PDP_WATCHDOG_LONG_POLL_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(pdpWatchdogErrorPollIntervalMs, SettingsConstants.Global.PDP_WATCHDOG_ERROR_POLL_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(pdpWatchdogTriggerPacketCount, SettingsConstants.Global.PDP_WATCHDOG_TRIGGER_PACKET_COUNT, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(pdpWatchdogErrorPollCount, SettingsConstants.Global.PDP_WATCHDOG_ERROR_POLL_COUNT, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(pdpWatchdogMaxPdpResetFailCount, SettingsConstants.Global.PDP_WATCHDOG_MAX_PDP_RESET_FAIL_COUNT, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(dataStallAlarmNonAggressiveDelayInMs, SettingsConstants.Global.DATA_STALL_ALARM_NON_AGGRESSIVE_DELAY_IN_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(dataStallAlarmAggressiveDelayInMs, SettingsConstants.Global.DATA_STALL_ALARM_AGGRESSIVE_DELAY_IN_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(dataStallRecoveryOnBadNetwork, SettingsConstants.Global.DATA_STALL_RECOVERY_ON_BAD_NETWORK, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(minDurationBetweenRecoverySteps, SettingsConstants.Global.MIN_DURATION_BETWEEN_RECOVERY_STEPS_IN_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(provisioningApnAlarmDelayInMs, SettingsConstants.Global.PROVISIONING_APN_ALARM_DELAY_IN_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(gprsRegisterCheckPeriodMs, SettingsConstants.Global.GPRS_REGISTER_CHECK_PERIOD_MS, SettingsNamespaces.GLOBAL)

        refreshSettingViaConstant(netStatsEnabled, SettingsConstants.Global.NETSTATS_ENABLED, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(netPolicyQuotaEnabled, SettingsConstants.Global.NETPOLICY_QUOTA_ENABLED, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(tcpDefaultInitRWND, SettingsConstants.Global.TCP_DEFAULT_INIT_RWND, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(nsdOn, SettingsConstants.Global.NSD_ON, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(inetConditionDebounceUpDelay, SettingsConstants.Global.INET_CONDITION_DEBOUNCE_UP_DELAY, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(inetConditionDebounceDownDelay, SettingsConstants.Global.INET_CONDITION_DEBOUNCE_DOWN_DELAY, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(ephemeralCookieMaxSizeBytes, SettingsConstants.Global.EPHEMERAL_COOKIE_MAX_SIZE_BYTES, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(syncMaxRetryDelayInSeconds, SettingsConstants.Global.SYNC_MAX_RETRY_DELAY_IN_SECONDS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(connectivitySamplingIntervalInSeconds, SettingsConstants.Global.CONNECTIVITY_SAMPLING_INTERVAL_IN_SECONDS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(networkAccessTimeoutMs, SettingsConstants.Global.NETWORK_ACCESS_TIMEOUT_MS, SettingsNamespaces.GLOBAL)

        refreshSettingViaConstant(locationBackgroundThrottleIntervalMs, SettingsConstants.Global.LOCATION_BACKGROUND_THROTTLE_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(locationBackgroundThrottleProximityAlertIntervalMs, SettingsConstants.Global.LOCATION_BACKGROUND_THROTTLE_PROXIMITY_ALERT_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        refreshSettingViaConstant(locationAccessCheckIntervalMillis, SettingsConstants.Secure.LOCATION_ACCESS_CHECK_INTERVAL_MILLIS, SettingsNamespaces.SECURE)
        refreshSettingViaConstant(locationAccessCheckDelayMillis, SettingsConstants.Secure.LOCATION_ACCESS_CHECK_DELAY_MILLIS, SettingsNamespaces.SECURE)

        refreshSettingViaConstant(enableRadioBugDetection, SettingsConstants.Global.ENABLE_RADIO_BUG_DETECTION, SettingsNamespaces.GLOBAL)
    }

    /**
     * Take the UI settings and apply them as constants
     */
    private fun applySettings() {
        applySettingViaConstant(dataActivityTimeoutWifi, SettingsConstants.Global.DATA_ACTIVITY_TIMEOUT_WIFI, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(wifiBadgingThresholds, SettingsConstants.Global.WIFI_BADGING_THRESHOLDS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(wifiFrameworkScanIntervalMs, SettingsConstants.Global.WIFI_FRAMEWORK_SCAN_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(wifiIdleMs, SettingsConstants.Global.WIFI_IDLE_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(speedLabelCacheEvictionAgeMillis, SettingsConstants.Global.SPEED_LABEL_CACHE_EVICTION_AGE_MILLIS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(wifiSupplicantScanIntervalMs, SettingsConstants.Global.WIFI_SUPPLICANT_SCAN_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(wifiWatchdogPoorNetworkTestEnabled, SettingsConstants.Global.WIFI_WATCHDOG_POOR_NETWORK_TEST_ENABLED, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(wifiMaxDHCPRetryCount, SettingsConstants.Global.WIFI_MAX_DHCP_RETRY_COUNT, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(wifiEphemeralOutOfRangeTimeoutMs, SettingsConstants.Global.WIFI_EPHEMERAL_OUT_OF_RANGE_TIMEOUT_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(wifiBounceDelayOverrideMs, SettingsConstants.Global.WIFI_BOUNCE_DELAY_OVERRIDE_MS, SettingsNamespaces.GLOBAL)

        applySettingViaConstant(dataActivityTimeoutMobile, SettingsConstants.Global.DATA_ACTIVITY_TIMEOUT_MOBILE, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(wifiMobileDataTransitionWakelockTimeoutMs, SettingsConstants.Global.WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(mdcInitialMaxRetry, SettingsConstants.Global.MDC_INITIAL_MAX_RETRY, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(pdpWatchdogPollIntervalMs, SettingsConstants.Global.PDP_WATCHDOG_POLL_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(pdpWatchdogLongPollIntervalMs, SettingsConstants.Global.PDP_WATCHDOG_LONG_POLL_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(pdpWatchdogErrorPollIntervalMs, SettingsConstants.Global.PDP_WATCHDOG_ERROR_POLL_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(pdpWatchdogTriggerPacketCount, SettingsConstants.Global.PDP_WATCHDOG_TRIGGER_PACKET_COUNT, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(pdpWatchdogErrorPollCount, SettingsConstants.Global.PDP_WATCHDOG_ERROR_POLL_COUNT, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(pdpWatchdogMaxPdpResetFailCount, SettingsConstants.Global.PDP_WATCHDOG_MAX_PDP_RESET_FAIL_COUNT, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(dataStallAlarmNonAggressiveDelayInMs, SettingsConstants.Global.DATA_STALL_ALARM_NON_AGGRESSIVE_DELAY_IN_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(dataStallAlarmAggressiveDelayInMs, SettingsConstants.Global.DATA_STALL_ALARM_AGGRESSIVE_DELAY_IN_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(dataStallRecoveryOnBadNetwork, SettingsConstants.Global.DATA_STALL_RECOVERY_ON_BAD_NETWORK, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(minDurationBetweenRecoverySteps, SettingsConstants.Global.MIN_DURATION_BETWEEN_RECOVERY_STEPS_IN_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(provisioningApnAlarmDelayInMs, SettingsConstants.Global.PROVISIONING_APN_ALARM_DELAY_IN_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(gprsRegisterCheckPeriodMs, SettingsConstants.Global.GPRS_REGISTER_CHECK_PERIOD_MS, SettingsNamespaces.GLOBAL)

        applySettingViaConstant(netStatsEnabled, SettingsConstants.Global.NETSTATS_ENABLED, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(netPolicyQuotaEnabled, SettingsConstants.Global.NETPOLICY_QUOTA_ENABLED, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(tcpDefaultInitRWND, SettingsConstants.Global.TCP_DEFAULT_INIT_RWND, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(nsdOn, SettingsConstants.Global.NSD_ON, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(inetConditionDebounceUpDelay, SettingsConstants.Global.INET_CONDITION_DEBOUNCE_UP_DELAY, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(inetConditionDebounceDownDelay, SettingsConstants.Global.INET_CONDITION_DEBOUNCE_DOWN_DELAY, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(ephemeralCookieMaxSizeBytes, SettingsConstants.Global.EPHEMERAL_COOKIE_MAX_SIZE_BYTES, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(syncMaxRetryDelayInSeconds, SettingsConstants.Global.SYNC_MAX_RETRY_DELAY_IN_SECONDS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(connectivitySamplingIntervalInSeconds, SettingsConstants.Global.CONNECTIVITY_SAMPLING_INTERVAL_IN_SECONDS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(networkAccessTimeoutMs, SettingsConstants.Global.NETWORK_ACCESS_TIMEOUT_MS, SettingsNamespaces.GLOBAL)

        applySettingViaConstant(locationBackgroundThrottleIntervalMs, SettingsConstants.Global.LOCATION_BACKGROUND_THROTTLE_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(locationBackgroundThrottleProximityAlertIntervalMs, SettingsConstants.Global.LOCATION_BACKGROUND_THROTTLE_PROXIMITY_ALERT_INTERVAL_MS, SettingsNamespaces.GLOBAL)
        applySettingViaConstant(locationAccessCheckIntervalMillis, SettingsConstants.Secure.LOCATION_ACCESS_CHECK_INTERVAL_MILLIS, SettingsNamespaces.SECURE)
        applySettingViaConstant(locationAccessCheckDelayMillis, SettingsConstants.Secure.LOCATION_ACCESS_CHECK_DELAY_MILLIS, SettingsNamespaces.SECURE)

        applySettingViaConstant(enableRadioBugDetection, SettingsConstants.Global.ENABLE_RADIO_BUG_DETECTION, SettingsNamespaces.GLOBAL)
    }

    override fun onResume() {
        super.onResume()
        preferenceManager.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceManager.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    /**
     * When settings are changed, apply the new config
     */
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        applySettings()
    }
}