package com.bl4ckcode.sces.ui.products.list.model

import com.bl4ckcode.sces.models.Produto

data class ProductUiModel(val hasError: Boolean, val error: String = "Erro desconhecido", val produtos: List<Produto> = ArrayList())