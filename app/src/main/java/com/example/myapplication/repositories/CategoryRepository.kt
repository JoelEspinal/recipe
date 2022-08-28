package com.example.myapplication.repositories

import com.example.myapplication.models.Category

interface CategoryRepository {
    fun categories() : List<Category>
}