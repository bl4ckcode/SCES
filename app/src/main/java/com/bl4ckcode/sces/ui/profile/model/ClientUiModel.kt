package com.bl4ckcode.sces.ui.profile.model

import com.bl4ckcode.sces.models.Cliente

data class ClientUiModel(val hasError: Boolean, val error: String = "Erro desconhecido", val cliente: Cliente? = null)