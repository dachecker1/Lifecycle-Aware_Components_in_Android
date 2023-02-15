package com.vk.lifecycle_aware_components_in_android.repositories

import com.vk.lifecycle_aware_components_in_android.repositories.models.RecipeApiState
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    fun getRandomRecipe(): Flow<RecipeApiState>
}