package com.bl4ckcode.sces.ui.products.detail.model

import com.bl4ckcode.sces.models.Produto
import com.bl4ckcode.sces.ui.products.network.Step

data class DetailProductUiModel(val hasError: Boolean, val error: String = "Erro desconhecido", val step: Step? = null, val produto: Produto? = null)
