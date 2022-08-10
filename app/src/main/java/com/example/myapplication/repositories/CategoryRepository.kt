package com.example.myapplication.repositories

import android.util.Log
import com.example.myapplication.data.remote.recipeService
import com.example.myapplication.data.remote.responses.CategoriesResponse
import com.example.myapplication.models.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryRepository {

    fun categories() : List<Category> {
        val response = recipeService.getCategories().execute()
        return if (response.isSuccessful) {
            val body = response.body()!!
            body.categories
        } else {
            listOf()
        }
    }
}