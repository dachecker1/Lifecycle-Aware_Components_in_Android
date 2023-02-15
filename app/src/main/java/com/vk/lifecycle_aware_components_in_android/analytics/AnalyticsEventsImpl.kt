package com.vk.lifecycle_aware_components_in_android.analytics

import android.util.Log
import javax.inject.Inject

class AnalyticsEventsImpl @Inject constructor() : AnalyticsEvents {

    companion object {
        private const val TAG = "APP_LOGGER"
    }

    override fun trackAppEvent(event: String) {
        Log.i(TAG, "App is going to $event")
    }
}