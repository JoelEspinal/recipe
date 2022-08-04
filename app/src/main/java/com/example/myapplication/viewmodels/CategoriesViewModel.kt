package com.example.myapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.Category
import com.example.myapplication.repositories.CategoryRepository

class CategoriesViewModel(private val repository: CategoryRepository): ViewModel(){

    fun categories(): MutableLiveData<List<Category?>> {
        val liveData =  MutableLiveData<List<Category?>>()
        liveData.value = repository.categories()
        return liveData
    }
}