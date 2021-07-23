package com.bl4ckcode.sces.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bl4ckcode.sces.ui.login.network.LoginRepository
import com.bl4ckcode.sces.ui.login.network.models.LoginResponse

class LoginViewModel : ViewModel() {
    private val loginRepository: LoginRepository = LoginRepository()
    private var _loginLiveData: LiveData<LoginResponse> = loginRepository.loginLiveData

    val loginLiveData: LiveData<LoginResponse>
        get() = _loginLiveData

    fun login(email: String, password: String) {
        loginRepository.login(email, password)
    }
}