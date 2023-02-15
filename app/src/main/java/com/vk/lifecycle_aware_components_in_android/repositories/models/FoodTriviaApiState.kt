package com.vk.lifecycle_aware_components_in_android.repositories.models

sealed class FoodTriviaApiState {
    object Error : FoodTriviaApiState()
    data class Result(val trivia: String) : FoodTriviaApiState()
}