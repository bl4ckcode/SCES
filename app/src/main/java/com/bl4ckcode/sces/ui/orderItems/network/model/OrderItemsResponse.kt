package com.bl4ckcode.sces.ui.orderItems.network.model

import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.models.ItensPedido
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OrderItemsResponse(itensPedido: ItensPedido) {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("pedido")
    @Expose
    var pedido: String? = null

    @SerializedName("produto")
    @Expose
    var produto: String? = null

    @SerializedName("preco_produto")
    @Expose
    var precoProduto: String? = null

    @SerializedName("nome_produto")
    @Expose
    var nomeProduto: String? = null

    @SerializedName("quantidade")
    @Expose
    var quantidade: String? = null

    init {
        this.id = itensPedido.id
        this.pedido = itensPedido.pedido.codigoPedido
        this.produto = itensPedido.produto.codigoProduto
        this.quantidade = itensPedido.quantidade.toString()
    }

    fun asItensPedido(): ItensPedido {
        val itensPedido = EcommerceposFactory.eINSTANCE.createItensPedido()
        val pedido = EcommerceposFactory.eINSTANCE.createPedido()
        val produto = EcommerceposFactory.eINSTANCE.createProduto()

        pedido.codigoPedido = this.pedido
        produto.codigoProduto = this.produto
        produto.nome = nomeProduto
        produto.preco = precoProduto?.toDouble() ?: run { 0.0 }

        itensPedido.id = id ?: run { 0 }
        itensPedido.pedido = pedido
        itensPedido.produto = produto
        itensPedido.quantidade = quantidade?.toDouble() ?: run { 0.0 }

        return itensPedido
    }
}