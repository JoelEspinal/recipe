package com.example.myapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.Category
import com.example.myapplication.repositories.CategoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesViewModel(private val repository: CategoryRepository): ViewModel(){

    private val liveData =  MutableLiveData<List<Category?>>()

    fun categories() : MutableLiveData<List<Category?>> {
        CoroutineScope(Dispatchers.IO).launch {
            liveData.postValue(repository.categories())
        }

        return liveData;
    }
}