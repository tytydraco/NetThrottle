package com.draco.netthrottle.fragments

import android.content.*
import android.net.Uri
import android.os.Bundle
import androidx.preference.*
import com.draco.netthrottle.R
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.google.android.material.snackbar.Snackbar

class MainPreferenceFragment : PreferenceFragmentCompat() {
    private lateinit var dataActivityTimeoutWifi: EditTextPreference
    private lateinit var wifiBadgingThresholds: EditTextPreference
    private lateinit var wifiFrameworkScanIntervalMs: EditTextPreference
    private lateinit var wifiIdleMs: EditTextPreference
    private lateinit var speedLabelCacheEvictionAgeMillis: EditTextPreference
    private lateinit var wifiSupplicantScanIntervalMs: EditTextPreference
    private lateinit var wifiWatchdogPoorNetworkTestEnabled: SwitchPreference
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
    private lateinit var dataStallRecoveryOnBadNetwork: SwitchPreference
    private lateinit var minDurationBetweenRecoverySteps: EditTextPreference
    private lateinit var provisioningApnAlarmDelayInMs: EditTextPreference
    private lateinit var gprsRegisterCheckPeriodMs: EditTextPreference

    private lateinit var netStatsEnabled: SwitchPreference
    private lateinit var netPolicyQuotaEnabled: SwitchPreference
    private lateinit var tcpDefaultInitRWND: EditTextPreference
    private lateinit var nsdOn: SwitchPreference
    private lateinit var inetConditionDebounceUpDelay: EditTextPreference
    private lateinit var inetConditionDebounceDownDelay: EditTextPreference
    private lateinit var ephemeralCookieMaxSizeBytes: EditTextPreference
    private lateinit var syncMaxRetryDelayInSeconds: EditTextPreference
    private lateinit var connectivitySamplingIntervalInSeconds: EditTextPreference
    private lateinit var networkAccessTimeoutMs: EditTextPreference

    private lateinit var bleScanAlwaysEnabled: SwitchPreference

    private lateinit var locationBackgroundThrottleIntervalMs: EditTextPreference
    private lateinit var locationBackgroundThrottleProximityAlertIntervalMs: EditTextPreference
    private lateinit var locationGlobalKillSwitch: SwitchPreference
    private lateinit var locationAccessCheckIntervalMillis: EditTextPreference
    private lateinit var locationAccessCheckDelayMillis: EditTextPreference

    private lateinit var enableRadioBugDetection: SwitchPreference

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

        bleScanAlwaysEnabled = findPreference(getString(R.string.pref_profile_key_ble_scan_always_enabled))!!

        locationBackgroundThrottleIntervalMs = findPreference(getString(R.string.pref_profile_key_location_background_throttle_interval_ms))!!
        locationBackgroundThrottleProximityAlertIntervalMs = findPreference(getString(R.string.pref_profile_key_location_background_throttle_proximity_alert_interval_ms))!!
        locationGlobalKillSwitch = findPreference(getString(R.string.pref_profile_key_location_global_kill_switch))!!
        locationAccessCheckIntervalMillis = findPreference(getString(R.string.pref_profile_key_location_access_check_interval_millis))!!
        locationAccessCheckDelayMillis = findPreference(getString(R.string.pref_profile_key_location_access_check_delay_millis))!!

        enableRadioBugDetection = findPreference(getString(R.string.pref_profile_key_enable_radio_bug_detection))!!
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
}