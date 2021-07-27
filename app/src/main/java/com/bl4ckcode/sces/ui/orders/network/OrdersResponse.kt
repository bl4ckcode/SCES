package com.bl4ckcode.sces.ui.orders.network

import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.ui.orderItems.network.model.OrderItemsResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OrdersResponse(pedido: Pedido) {
    @SerializedName("codigo_pedido")
    @Expose
    var codigoPedido: String? = null

    @SerializedName("cliente")
    @Expose
    var cliente: String? = null

    @SerializedName("nome_cliente")
    @Expose
    var nomeCliente: String? = null

    @SerializedName("data_pedido")
    @Expose
    var dataPedido: String? = null

    @SerializedName("produtos")
    @Expose
    var itensPedido: ArrayList<OrderItemsResponse?> = ArrayList()

    init {
        codigoPedido = pedido.codigoPedido
        dataPedido = pedido.dataPedido
        cliente = pedido.clientes.id.toString()
        nomeCliente = pedido.clientes.nome
        pedido.itens_do_pedido.forEach {
            itensPedido.add(OrderItemsResponse(it))
        }
    }
}