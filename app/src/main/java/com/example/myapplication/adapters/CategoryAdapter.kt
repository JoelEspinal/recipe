package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Category
import com.example.myapplication.viewmodels.CategoriesViewModel

class CategoryAdapter(private val categoryViewModel: CategoriesViewModel) : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CATEGORY_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder.create(parent, categoryViewModel)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        val currentCategory = getItem(position)
        holder.bind(currentCategory, categoryViewModel)

    }

    class CategoryViewHolder(itemView: View, viewModel: CategoriesViewModel) : RecyclerView.ViewHolder(itemView) {
        private val categoryImageView: ImageView = itemView.findViewById(R.id.category_img)
        private val categoryTitle: TextView = itemView.findViewById(R.id.category_title)

        fun bind(category: Category?, categoriesViewModel: CategoriesViewModel) {
//            categoryImageView.setImageResource(category?.strCategoryThumb)
            categoryTitle.text = category?.strCategory
            // TODO Redirect to category selected fragment acording to user click
        }

        companion object {
            fun create(parent: ViewGroup, categoriesViewModel: CategoriesViewModel): CategoryViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycleview_category_item, parent, false)
                return CategoryViewHolder(view, categoriesViewModel)
            }
        }
    }

    companion object {
        private val CATEGORY_COMPARATOR = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(old: Category, new: Category): Boolean {
                return old == new
            }

            override fun areContentsTheSame(old: Category, new: Category): Boolean {
                return (old.idCategory == new.idCategory
                        && old.strCategory == new.strCategory
                        && old.strCategoryThumb == new.strCategoryThumb)
            }
        }
    }
}