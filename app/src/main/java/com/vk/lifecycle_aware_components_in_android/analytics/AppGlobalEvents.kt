package com.vk.lifecycle_aware_components_in_android.analytics

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import javax.inject.Inject

class AppGlobalEvents @Inject constructor(
    private val analyticsEvents: AnalyticsEvents
) : DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        onAppToForeground()
    }

    override fun onStop(owner: LifecycleOwner) {
        onAppToBackground()
    }

    private fun onAppToForeground() {
        analyticsEvents.trackAppEvent("foreground")
    }

    private fun onAppToBackground() {
        analyticsEvents.trackAppEvent("background")
    }
}