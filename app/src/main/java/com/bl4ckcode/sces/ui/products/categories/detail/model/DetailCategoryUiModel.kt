package com.bl4ckcode.sces.ui.products.categories.detail.model

import com.bl4ckcode.sces.models.Categoria
import com.bl4ckcode.sces.ui.products.network.Step

data class DetailCategoryUiModel(
    val hasError: Boolean,
    val error: String = "Erro desconhecido",
    val step: Step? = null,
    val categoria: Categoria? = null
)
