package com.vk.lifecycle_aware_components_in_android.data

data class Ingredient(
    val id: Int,
    val image: String,
    val name: String,
    val amount: Double,
    val unit: String
) {
    val imageUrl: String
        get() {
            return "https://spoonacular.com/cdn/ingredients_100x100/$image"
        }
}