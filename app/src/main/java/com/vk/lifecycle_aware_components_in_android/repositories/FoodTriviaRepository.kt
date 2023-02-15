package com.vk.lifecycle_aware_components_in_android.repositories

import com.vk.lifecycle_aware_components_in_android.repositories.models.FoodTriviaApiState
import kotlinx.coroutines.flow.Flow

interface FoodTriviaRepository {

    fun getRandomFoodTrivia(): Flow<FoodTriviaApiState>
}