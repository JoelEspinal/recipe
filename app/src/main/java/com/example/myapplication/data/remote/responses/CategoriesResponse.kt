package com.example.myapplication.data.remote.responses

import com.example.myapplication.models.Category
import com.google.gson.annotations.SerializedName

class CategoriesResponse {
   @SerializedName("categories")
   val categories = listOf<Category>()
}