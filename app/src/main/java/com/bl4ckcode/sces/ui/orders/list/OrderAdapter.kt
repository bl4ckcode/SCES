package com.bl4ckcode.sces.ui.orders.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.models.Pedido

class OrderAdapter(
    private val orders: List<Pedido>,
    private val orderAdapterListener: OrderAdapterListener
) : RecyclerView.Adapter<OrderAdapter.OrderAdapterViewHolder>() {
    interface OrderAdapterListener {
        fun orderClicked(order: Pedido)
    }

    inner class OrderAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderNumber: TextView = itemView.findViewById(R.id.order_title)
        val orderProducts: TextView = itemView.findViewById(R.id.order_subtitle)

        fun bind(order: Pedido) {
            orderNumber.text = "Pedido #" + order.codigoPedido
            orderProducts.text = order.dataPedido
            itemView.setOnClickListener { orderAdapterListener.orderClicked(order) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderAdapterViewHolder {
        return OrderAdapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_item_order, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OrderAdapterViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount(): Int {
        return orders.size
    }
}