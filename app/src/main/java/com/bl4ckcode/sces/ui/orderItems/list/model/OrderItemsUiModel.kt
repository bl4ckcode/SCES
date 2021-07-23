package com.bl4ckcode.sces.ui.orderItems.list.model

import com.bl4ckcode.sces.models.ItensPedido

data class OrderItemsUiModel(
    val hasError: Boolean,
    val error: String = "Erro desconhecido",
    val itensPedido: List<ItensPedido> = ArrayList()
)