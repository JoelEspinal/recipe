package com.example.myapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.Category
import com.example.myapplication.repositories.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesViewModel(private val repository: CategoryRepository): ViewModel(){

    fun categories(): MutableLiveData<List<Category?>> {
        val liveData =  MutableLiveData<List<Category?>>()
//        viewModelScope.launch(Dispatchers.Main) {
            liveData.value = repository.categories()
//        }

        return liveData
    }
}