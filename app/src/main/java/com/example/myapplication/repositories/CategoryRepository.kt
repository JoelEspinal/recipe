package com.example.myapplication.repositories

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.models.Category

class CategoryRepository {

    private val mockedCategories = listOf<Category>(
        Category(idCategory = "1", strCategory = "soup", "image"),
        Category("2", strCategory = "pasta", "image")
    )

    fun categories():  MutableLiveData<List<Category?>> {
       val liveData =  MutableLiveData<List<Category?>>()
        liveData.value = mockedCategories
        return liveData
    }
}