package com.bl4ckcode.sces.ui.products.categories.model

import com.bl4ckcode.sces.models.Categoria

data class CategoryUiModel(val hasError: Boolean, val error: String = "Erro desconhecido", val categorias: List<Categoria> = ArrayList())