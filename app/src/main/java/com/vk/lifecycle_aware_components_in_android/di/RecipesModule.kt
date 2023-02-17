package com.vk.lifecycle_aware_components_in_android.di

import com.vk.lifecycle_aware_components_in_android.network.RecipesService
import com.vk.lifecycle_aware_components_in_android.repositories.FoodTriviaRepository
import com.vk.lifecycle_aware_components_in_android.repositories.FoodTriviaRepositoryImpl
import com.vk.lifecycle_aware_components_in_android.repositories.RecipeRepository
import com.vk.lifecycle_aware_components_in_android.repositories.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val API_KEY = "YOUR_API   "

@Module
@InstallIn(SingletonComponent::class)
object RecipesModule {

    @Provides
    @Singleton
    fun providesRetrofitService(): RecipesService {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val url = chain.request().url().newBuilder()
                    .addQueryParameter("apiKey", API_KEY)
                    .build()

                val requestBuilder = chain.request().newBuilder().url(url)
                chain.proceed(requestBuilder.build())
            }
            .build()

        val builder = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())

        return builder.build().create(RecipesService::class.java)
    }

    @Provides
    @Singleton
    fun providesRecipeRepository(recipesService: RecipesService): RecipeRepository {
        return RecipeRepositoryImpl(recipesService)
    }

    @Provides
    @Singleton
    fun providesTriviaRepository(recipesService: RecipesService): FoodTriviaRepository {
        return FoodTriviaRepositoryImpl(recipesService)
    }
}