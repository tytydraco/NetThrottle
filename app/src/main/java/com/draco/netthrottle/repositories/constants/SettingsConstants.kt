package com.draco.netthrottle.repositories.constants

object SettingsConstants {
    object Global {
        const val DATA_ACTIVITY_TIMEOUT_WIFI =                      "data_activity_timeout_wifi"
        const val WIFI_BADGING_THRESHOLDS =                         "wifi_badging_thresholds"
        const val WIFI_FRAMEWORK_SCAN_INTERVAL_MS =                 "wifi_framework_scan_interval_ms"
        const val WIFI_IDLE_MS =                                    "wifi_idle_ms"
        const val SPEED_LABEL_CACHE_EVICTION_AGE_MILLIS =           "speed_label_cache_eviction_age_millis"
        const val WIFI_SUPPLICANT_SCAN_INTERVAL_MS =                "wifi_supplicant_scan_interval_ms"
        const val WIFI_WATCHDOG_POOR_NETWORK_TEST_ENABLED =         "wifi_watchdog_poor_network_test_enabled"
        const val WIFI_MAX_DHCP_RETRY_COUNT =                       "wifi_max_dhcp_retry_count"
        const val WIFI_EPHEMERAL_OUT_OF_RANGE_TIMEOUT_MS =          "wifi_ephemeral_out_of_range_timeout_ms"
        const val WIFI_BOUNCE_DELAY_OVERRIDE_MS =                   "wifi_bounce_delay_override_ms"

        const val DATA_ACTIVITY_TIMEOUT_MOBILE =                    "data_activity_timeout_mobile"
        const val WIFI_MOBILE_DATA_TRANSITION_WAKELOCK_TIMEOUT_MS = "wifi_mobile_data_transition_wakelock_timeout_ms"
        const val MDC_INITIAL_MAX_RETRY =                           "mdc_initial_max_retry"
        const val PDP_WATCHDOG_POLL_INTERVAL_MS =                   "pdp_watchdog_poll_interval_ms"
        const val PDP_WATCHDOG_LONG_POLL_INTERVAL_MS =              "pdp_watchdog_long_poll_interval_ms"
        const val PDP_WATCHDOG_ERROR_POLL_INTERVAL_MS =             "pdp_watchdog_error_poll_interval_ms"
        const val PDP_WATCHDOG_TRIGGER_PACKET_COUNT =               "pdp_watchdog_trigger_packet_count"
        const val PDP_WATCHDOG_ERROR_POLL_COUNT =                   "pdp_watchdog_error_poll_count"
        const val PDP_WATCHDOG_MAX_PDP_RESET_FAIL_COUNT =           "pdp_watchdog_max_pdp_reset_fail_count"
        const val DATA_STALL_ALARM_NON_AGGRESSIVE_DELAY_IN_MS =     "data_stall_alarm_non_aggressive_delay_in_ms"
        const val DATA_STALL_ALARM_AGGRESSIVE_DELAY_IN_MS =         "data_stall_alarm_aggressive_delay_in_ms"
        const val DATA_STALL_RECOVERY_ON_BAD_NETWORK =              "data_stall_recovery_on_bad_network"
        const val MIN_DURATION_BETWEEN_RECOVERY_STEPS_IN_MS =       "min_duration_between_recovery_steps"
        const val PROVISIONING_APN_ALARM_DELAY_IN_MS =              "provisioning_apn_alarm_delay_in_ms"
        const val GPRS_REGISTER_CHECK_PERIOD_MS =                   "gprs_register_check_period_ms"

        const val NETSTATS_ENABLED =                                "netstats_enabled"
        const val NETPOLICY_QUOTA_ENABLED =                         "netpolicy_quota_enabled"
        const val TCP_DEFAULT_INIT_RWND =                           "tcp_default_init_rwnd"
        const val NSD_ON =                                          "nsd_on"
        const val INET_CONDITION_DEBOUNCE_UP_DELAY =                "inet_condition_debounce_up_delay"
        const val INET_CONDITION_DEBOUNCE_DOWN_DELAY =              "inet_condition_debounce_down_delay"
        const val EPHEMERAL_COOKIE_MAX_SIZE_BYTES =                 "ephemeral_cookie_max_size_bytes"
        const val SYNC_MAX_RETRY_DELAY_IN_SECONDS =                 "sync_max_retry_delay_in_seconds"
        const val CONNECTIVITY_SAMPLING_INTERVAL_IN_SECONDS =       "connectivity_sampling_interval_in_seconds"
        const val NETWORK_ACCESS_TIMEOUT_MS =                       "network_access_timeout_ms"

        const val LOCATION_BACKGROUND_THROTTLE_INTERVAL_MS =        "location_background_throttle_interval_ms"
        const val LOCATION_BACKGROUND_THROTTLE_PROXIMITY_ALERT_INTERVAL_MS =    "location_background_throttle_proximity_alert_interval_ms"

        const val ENABLE_RADIO_BUG_DETECTION =                      "enable_radio_bug_detection"
    }

    object Secure {
        const val LOCATION_ACCESS_CHECK_INTERVAL_MILLIS =           "location_access_check_interval_millis"
        const val LOCATION_ACCESS_CHECK_DELAY_MILLIS =              "location_access_check_delay_millis"
    }
}