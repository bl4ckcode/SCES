package com.bl4ckcode.sces.ui.login.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse(val hasError: Boolean = false, val error: String = "Erro desconhecido"){
    @SerializedName("key")
    @Expose
    val key: String? = null
}