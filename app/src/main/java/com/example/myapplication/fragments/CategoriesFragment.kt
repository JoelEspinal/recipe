package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.CategoryAdapter
import com.example.myapplication.repositories.CategoryRepository
import com.example.myapplication.viewmodels.CategoriesViewModel

class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = CategoriesViewModel(CategoryRepository())
        val layout = inflater.inflate(R.layout.fragment_first, container, false)
        val recyclerView = layout.findViewById<RecyclerView>(R.id.recycler_view_categories)
        val adapter = CategoryAdapter(viewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(activity, 2)

        activity?.let {
            viewModel.categories().observe(it){ category ->
                category.let {
                    adapter.submitList(category)
                }
            }
        }

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}