package com.bl4ckcode.sces.ui.products.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.models.Categoria

class CategoryAdapter(
    private val categories: ArrayList<Categoria>,
    private val productAdapterListener: CategoryAdapterListener
) : RecyclerView.Adapter<CategoryAdapter.CategoryAdapterViewHolder>() {
    interface CategoryAdapterListener {
        fun categoryClicked(categoria: Categoria)
    }

    inner class CategoryAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.name_category)

        fun bind(categoria: Categoria) {
            productName.text = categoria.nome

            itemView.setOnClickListener { productAdapterListener.categoryClicked(categoria) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapterViewHolder {
        return CategoryAdapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryAdapterViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun updateData(categories: ArrayList<Categoria>) {
        this.categories.clear()
        this.categories.addAll(categories)
        notifyDataSetChanged()
    }
}