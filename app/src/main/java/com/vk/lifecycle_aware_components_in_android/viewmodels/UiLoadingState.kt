package com.vk.lifecycle_aware_components_in_android.viewmodels

sealed class UiLoadingState {
    object Loading : UiLoadingState()
    object NotLoading : UiLoadingState()
}