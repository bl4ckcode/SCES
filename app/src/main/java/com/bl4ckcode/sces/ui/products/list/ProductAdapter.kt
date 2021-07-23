package com.bl4ckcode.sces.ui.products.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.models.Produto


class ProductAdapter(
    private val products: ArrayList<Produto>,
    private val productAdapterListener: ProductAdapterListener
) : RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder>() {
    interface ProductAdapterListener {
        fun productClicked(product: Produto)
    }

    inner class ProductAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productName: TextView = itemView.findViewById(R.id.name_product)
        private val productPrice: TextView = itemView.findViewById(R.id.price_product)
        private val productDesc: TextView = itemView.findViewById(R.id.desc_product)

        @SuppressLint("SetTextI18n")
        fun bind(product: Produto) {
            productName.text = product.nome
            productPrice.text = "R$ ${product.preco}"
            productDesc.text = "Quantidade: ${product.quantidadeEstoque}"

            itemView.setOnClickListener { productAdapterListener.productClicked(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
        return ProductAdapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun updateData(products: ArrayList<Produto>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }
}