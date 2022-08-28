package com.example.myapplication.repositories

import com.example.myapplication.data.remote.RecipeApi
import com.example.myapplication.models.Category

class CategoryRepositoryImpl(private val recipeApi: RecipeApi): CategoryRepository {

    override fun categories() : List<Category> {
        val response = recipeApi.getCategories().execute()
        return if (response.isSuccessful) {
            val body = response.body()!!
            body.categories
        } else {
            listOf()
        }
    }
}