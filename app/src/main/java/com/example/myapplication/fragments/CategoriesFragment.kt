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
import com.example.myapplication.viewmodels.CategoriesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoriesFragment : Fragment() {

    private val categoriesViewModel : CategoriesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_categories)
        val adapter = activity?.let { CategoryAdapter(it, categoriesViewModel) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        activity?.let {
            categoriesViewModel.categories().observe(it) {
                adapter?.submitList(it)
            }
        }
    }
}