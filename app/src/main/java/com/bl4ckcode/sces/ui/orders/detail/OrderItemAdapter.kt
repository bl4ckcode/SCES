package com.bl4ckcode.sces.ui.orders.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.util.toCurrency

class OrderItemAdapter(
    private val orderItens: List<ItensPedido>
) : RecyclerView.Adapter<OrderItemAdapter.OrderItemAdapterAdapterViewHolder>() {

    inner class OrderItemAdapterAdapterViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.product_name)
        val productPrice: TextView = itemView.findViewById(R.id.product_price)

        @SuppressLint("SetTextI18n")
        fun bind(orderItem: ItensPedido) {
            productName.text = orderItem.produto.nome
            productPrice.text = orderItem.produto.preco.toCurrency()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderItemAdapterAdapterViewHolder {
        return OrderItemAdapterAdapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_item_order_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OrderItemAdapterAdapterViewHolder, position: Int) {
        holder.bind(orderItens[position])
    }

    override fun getItemCount(): Int {
        return orderItens.size
    }
}