package com.bl4ckcode.sces.ui.products.network

import com.bl4ckcode.sces.models.Categoria
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Category(categoria: Categoria) {
    @SerializedName("codigo_categoria")
    @Expose
    var codigo: String? = null

    @SerializedName("nome_categoria")
    @Expose
    var nome: String? = null

    init {
        codigo = categoria.codigo
        nome = categoria.nome
    }
}