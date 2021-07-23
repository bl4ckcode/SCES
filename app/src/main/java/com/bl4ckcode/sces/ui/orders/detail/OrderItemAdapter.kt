package com.bl4ckcode.sces.ui.orders.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.models.ItensPedido

class OrderItemAdapter(
    private val orderItens: List<ItensPedido>
) : RecyclerView.Adapter<OrderItemAdapter.OrderItemAdapterAdapterViewHolder>() {

    inner class OrderItemAdapterAdapterViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val orderId: TextView = itemView.findViewById(R.id.order_id)
        val productName: TextView = itemView.findViewById(R.id.product_name)

        @SuppressLint("SetTextI18n")
        fun bind(orderItem: ItensPedido) {
            orderId.text = "Pedido #${orderItem.pedido.codigoPedido}"
            productName.text = orderItem.produto.nome
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