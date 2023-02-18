package com.vk.lifecycle_aware_components_in_android.monitor

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnavailableConnectionLifecycleOwner @Inject constructor() : LifecycleOwner {

    private val lifecycleRegistry : LifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    fun onConnectionAvailable(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    fun onConnectionLost(){
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }

    fun addObserver(lifecycleObserver: LifecycleObserver) {
        lifecycleRegistry.addObserver(lifecycleObserver)
    }
}