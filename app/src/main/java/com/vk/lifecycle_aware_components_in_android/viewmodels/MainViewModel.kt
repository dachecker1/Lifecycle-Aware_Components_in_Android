package com.vk.lifecycle_aware_components_in_android.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.lifecycle_aware_components_in_android.repositories.RecipeRepository
import com.vk.lifecycle_aware_components_in_android.repositories.models.RecipeApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private val _recipeState = MutableLiveData<RecipeApiState>()
    val recipeState: LiveData<RecipeApiState>
        get() {
            return _recipeState
        }

    fun getRandomRecipe() {
        viewModelScope.launch {
            recipeRepository.getRandomRecipe().collect { result ->
                _recipeState.value = result
            }
        }
    }
}