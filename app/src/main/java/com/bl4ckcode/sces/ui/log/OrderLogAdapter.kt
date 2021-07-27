package com.bl4ckcode.sces.ui.log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.models.Pedido

class OrderLogAdapter(
    private val orders: ArrayList<Pedido>,
) : RecyclerView.Adapter<OrderLogAdapter.OrderLogAdapterViewHolder>() {

    inner class OrderLogAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderNumber: TextView = itemView.findViewById(R.id.order_id)
        val orderClientName: TextView = itemView.findViewById(R.id.order_client_name)
        val orderDate: TextView = itemView.findViewById(R.id.order_date)
        val orderProducts: TextView = itemView.findViewById(R.id.order_products)
        val orderPrice: TextView = itemView.findViewById(R.id.order_products_price)

        fun bind(order: Pedido) {
            orderNumber.text = "#${order.codigoPedido}"
            orderClientName.text = order.clientes.nome
            orderDate.text = order.dataPedido
            orderProducts.text = order.clientes.endereco
            orderPrice.text = "R$ ${order.clientes.telefone}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderLogAdapterViewHolder {
        return OrderLogAdapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_order_log, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OrderLogAdapterViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    fun updateData(orders: ArrayList<Pedido>) {
        this.orders.clear()
        this.orders.addAll(orders)
        notifyDataSetChanged()
    }
}