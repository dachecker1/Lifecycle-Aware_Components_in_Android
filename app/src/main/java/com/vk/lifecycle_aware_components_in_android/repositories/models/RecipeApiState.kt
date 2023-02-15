package com.vk.lifecycle_aware_components_in_android.repositories.models

import com.vk.lifecycle_aware_components_in_android.data.Recipe

sealed class RecipeApiState {
    object Error : RecipeApiState()
    data class Result(val recipe: Recipe) : RecipeApiState()
}