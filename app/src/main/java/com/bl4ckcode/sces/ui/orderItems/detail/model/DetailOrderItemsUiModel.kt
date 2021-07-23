package com.bl4ckcode.sces.ui.orderItems.detail.model

import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.ui.products.network.Step

data class DetailOrderItemsUiModel(
    val hasError: Boolean,
    val error: String = "Erro desconhecido",
    val step: Step? = null,
    val itensPedido: ItensPedido? = null
)