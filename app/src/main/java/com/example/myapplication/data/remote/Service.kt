package com.example.myapplication.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var recipeService: RecipeService = retrofit.create(RecipeService::class.java)