package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.responses.CategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface RecipeService {

    @GET("api/json/v1/1/categories.php")
   fun getCategories(): Call<CategoriesResponse>
}