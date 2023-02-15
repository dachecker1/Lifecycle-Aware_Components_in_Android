package com.vk.lifecycle_aware_components_in_android.di

import com.vk.lifecycle_aware_components_in_android.analytics.AnalyticsEvents
import com.vk.lifecycle_aware_components_in_android.analytics.AnalyticsEventsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyticsEventsModule {

    @Binds
    @Singleton
    abstract fun bindAnalyticsEvents(analyticsEventsImpl: AnalyticsEventsImpl): AnalyticsEvents
}