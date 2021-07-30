package com.bl4ckcode.sces.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.ui.login.network.LoginRepository
import com.bl4ckcode.sces.ui.login.network.models.LoginResponse

class LoginViewModel(
    application: Application,
    private val loginRepository: LoginRepository
) : AndroidViewModel(application) {

    private var _loginLiveData: LiveData<LoginResponse> = loginRepository.loginLiveData

    val loginLiveData: LiveData<LoginResponse>
        get() = _loginLiveData

    fun login(email: String, password: String) {
        loginRepository.login(email, password)
    }
}