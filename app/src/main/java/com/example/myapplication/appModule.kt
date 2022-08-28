package com.example.myapplication

import com.example.myapplication.data.remote.RecipeApi
import com.example.myapplication.fragments.CategoriesFragment
import com.example.myapplication.repositories.CategoryRepository
import com.example.myapplication.repositories.CategoryRepositoryImpl
import com.example.myapplication.viewmodels.CategoriesViewModel
import io.reactivex.Single
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<RecipeApi> {
        val retrofit: Retrofit = get()
        retrofit.create(RecipeApi::class.java)
    }

    factory<CategoryRepository>{ CategoryRepositoryImpl(get())}

    single { CategoriesViewModel(get()) }

    factory { CategoriesFragment() }
}