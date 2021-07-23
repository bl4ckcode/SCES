package com.bl4ckcode.sces.ui.products.network

import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.models.Produto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductResponse(produto: Produto) {
    @SerializedName("codigo_produto")
    @Expose
    var codigoProduto: String? = null

    @SerializedName("nome_produto")
    @Expose
    var nome: String? = null

    @SerializedName("preco_produto")
    @Expose
    var preco: String? = null

    @SerializedName("quantidade_estoque")
    @Expose
    var quantidadeEstoque: String? = null

    @SerializedName("categoria")
    @Expose
    var codigoCategoria: String? = null

    @SerializedName("nome_categoria")
    @Expose
    var nomeCategoria: String? = null

    init {
        codigoProduto = produto.codigoProduto
        nome = produto.nome
        preco = produto.preco.toString()
        quantidadeEstoque = produto.quantidadeEstoque.toString()
        produto.cetgorias?.let {
            codigoCategoria = it.codigo
            nomeCategoria = it.nome
        }
    }

    fun asProduto(): Produto {
        val produto = EcommerceposFactory.eINSTANCE.createProduto()
        val categoria = EcommerceposFactory.eINSTANCE.createCategoria()

        categoria.codigo = codigoCategoria
        categoria.nome = nomeCategoria

        produto.codigoProduto = codigoProduto
        produto.nome = nome
        produto.preco = preco?.toDouble() ?: run { 0.0 }
        produto.quantidadeEstoque = quantidadeEstoque?.toDouble() ?: run { 0.0 }
        produto.cetgorias = categoria

        return produto
    }
}