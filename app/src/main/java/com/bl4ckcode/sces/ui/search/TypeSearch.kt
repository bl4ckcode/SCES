package com.bl4ckcode.sces.ui.search

import com.bl4ckcode.sces.models.Categoria
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.models.Produto
import java.io.Serializable

data class TypeSearch(
    val typeSearchEnum: TypeSearchEnum,
    val productsList: List<Produto>? = null,
    val categoriesList: List<Categoria>? = null,
) : Serializable

enum class TypeSearchEnum {
    PRODUCT,
    CATEGORY
}