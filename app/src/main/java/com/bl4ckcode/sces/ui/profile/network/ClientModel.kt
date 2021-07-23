package com.bl4ckcode.sces.ui.profile.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ClientModel(
    @SerializedName("CPF")
    @Expose
    val cpf: String? = null,

    @SerializedName("nome")
    @Expose
    val nome: String? = null,

    @SerializedName("endereco")
    @Expose
    val endereco: String? = null,

    @SerializedName("estado")
    @Expose
    val estado: String? = null,

    @SerializedName("municipio")
    @Expose
    val municipio: String? = null,

    @SerializedName("telefone")
    @Expose
    val telefone: String? = null
)