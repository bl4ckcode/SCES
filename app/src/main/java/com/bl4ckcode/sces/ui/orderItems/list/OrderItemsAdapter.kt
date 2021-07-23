package com.bl4ckcode.sces.ui.orderItems.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.models.ItensPedido

class OrderItemsAdapter(
    private val orderItens: List<ItensPedido>,
    private val orderItensAdapterListener: OrderItemsAdapterAdapterListener
) : RecyclerView.Adapter<OrderItemsAdapter.OrderItemsAdapterAdapterAdapterViewHolder>() {
    interface OrderItemsAdapterAdapterListener {
        fun orderItemClicked(orderItem: ItensPedido)
    }

    inner class OrderItemsAdapterAdapterAdapterViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val orderId: TextView = itemView.findViewById(R.id.order_id)
        val productIdName: TextView = itemView.findViewById(R.id.product_id_name)

        @SuppressLint("SetTextI18n")
        fun bind(orderItem: ItensPedido) {
            orderId.text = "Item Pedido #${orderItem.pedido.codigoPedido}"
            productIdName.text = "${orderItem.produto.codigoProduto} - ${orderItem.produto.nome}"
            itemView.setOnClickListener { orderItensAdapterListener.orderItemClicked(orderItem) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderItemsAdapterAdapterAdapterViewHolder {
        return OrderItemsAdapterAdapterAdapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_item_order_items, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: OrderItemsAdapterAdapterAdapterViewHolder,
        position: Int
    ) {
        holder.bind(orderItens[position])
    }

    override fun getItemCount(): Int {
        return orderItens.size
    }
}