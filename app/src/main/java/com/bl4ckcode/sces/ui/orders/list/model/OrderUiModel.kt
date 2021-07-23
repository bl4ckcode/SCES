package com.bl4ckcode.sces.ui.orders.list.model

import com.bl4ckcode.sces.models.Pedido

data class OrderUiModel(
    val hasError: Boolean,
    val error: String = "Erro desconhecido",
    val pedidos: List<Pedido> = ArrayList()
)