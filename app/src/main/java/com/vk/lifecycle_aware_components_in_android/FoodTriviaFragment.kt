package com.vk.lifecycle_aware_components_in_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.vk.lifecycle_aware_components_in_android.databinding.FragmentFoodTriviaBinding
import com.vk.lifecycle_aware_components_in_android.repositories.models.FoodTriviaApiState
import com.vk.lifecycle_aware_components_in_android.viewmodels.FoodTriviaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodTriviaFragment : Fragment() {

    private val viewModel: FoodTriviaViewModel by viewModels()

    private var binding: FragmentFoodTriviaBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFoodTriviaBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding?.apply {
            getFoodTriviaButton.setOnClickListener {
                viewModel.getRandomFoodTrivia()
            }
        }

        viewModel.getRandomFoodTrivia()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun handleFoodTriviaApiState(foodTriviaApiState: FoodTriviaApiState) {
        when (foodTriviaApiState) {
            is FoodTriviaApiState.Result -> binding?.foodTriviaTextView?.text = foodTriviaApiState.trivia
            FoodTriviaApiState.Error -> showError()
        }
    }

    private fun showError() {
        binding?.let {
            Snackbar.make(it.root, getString(R.string.trivia_error), Snackbar.LENGTH_SHORT)
                .apply {
                    view.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.purple_500))
                    show()
                }
        }
    }
}