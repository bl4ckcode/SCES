package com.bl4ckcode.sces.ui.login.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bl4ckcode.sces.ui.login.network.models.LoginResponse
import com.bl4ckcode.sces.util.ApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface LoginApi {

    @POST("/rest-auth/login/")
    @FormUrlEncoded
    fun login(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): Call<LoginResponse>

    @POST("rest-auth/registration/")
    @FormUrlEncoded
    fun register(
        @Field("email") email: String?,
        @Field("password1") password1: String?,
        @Field("password2") password2: String?
    ): Call<LoginResponse>
}

class LoginRepository {

    companion object {
        const val BASE_URL = "https://ecommercepos.herokuapp.com/"
    }

    private val loginApi: LoginApi = ApiBuilder.create(LoginApi::class.java)
    private val _loginLiveData: MutableLiveData<LoginResponse> = MutableLiveData<LoginResponse>()

    val loginLiveData: LiveData<LoginResponse>
        get() = _loginLiveData

    fun login(email: String?, password: String?) {
        loginApi.login(email, password)
            .enqueue(object : Callback<LoginResponse?> {
                override fun onResponse(
                    call: Call<LoginResponse?>?,
                    response: Response<LoginResponse?>
                ) {
                    when {
                        response.isSuccessful -> {
                            _loginLiveData.postValue(response.body())
                        }
                        response.errorBody() != null -> {
                            val errorBody = response.errorBody()!!.string()
                            _loginLiveData.postValue(LoginResponse(true, errorBody))
                        }
                    }
                }

                override fun onFailure(call: Call<LoginResponse?>?, t: Throwable?) {
                    _loginLiveData.postValue(LoginResponse(true))
                }
            })
    }

    fun register(email: String?, password: String?) {
        loginApi.register(email, password, password)
            .enqueue(object : Callback<LoginResponse?> {
                override fun onResponse(
                    call: Call<LoginResponse?>?,
                    response: Response<LoginResponse?>
                ) {
                    when {
                        response.isSuccessful -> {
                            _loginLiveData.postValue(response.body())
                        }
                        response.errorBody() != null -> {
                            val errorBody = response.errorBody()!!.string()
                            _loginLiveData.postValue(LoginResponse(true, errorBody))
                        }
                    }
                }

                override fun onFailure(call: Call<LoginResponse?>?, t: Throwable?) {
                    _loginLiveData.postValue(LoginResponse(true))
                }
            })
    }
}