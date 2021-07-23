package com.bl4ckcode.sces.ui.orders.detail.model

import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.ui.products.network.Step

data class DetailOrderUiModel(
    val hasError: Boolean,
    val error: String = "Erro desconhecido",
    val step: Step? = null,
    val pedido: Pedido? = null
)

