package com.vk.lifecycle_aware_components_in_android

import android.app.Application
import com.vk.lifecycle_aware_components_in_android.analytics.AppGlobalEvents
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class RecipesApplication : Application() {

    @Inject
    lateinit var appGlobalEvents: AppGlobalEvents

    override fun onCreate() {
        super.onCreate()

    }
}