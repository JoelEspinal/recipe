package com.example.myapplication.repositories

import android.util.Log
import com.example.myapplication.data.remote.recipeService
import com.example.myapplication.data.remote.responses.CategoriesResponse
import com.example.myapplication.models.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryRepository {

    fun categories(): List<Category> {
        var categories = listOf<Category>()

       val call = recipeService.getCategories()

        call.enqueue(
            object : Callback<CategoriesResponse> {
                override fun onResponse(
                    call: Call<CategoriesResponse>,
                    response: Response<CategoriesResponse>
                ) {
                    response.body()?.let { categories = it?.categories!! }

                }

                override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )

        return categories
    }
}