package com.bl4ckcode.sces.ui.profile.network

import androidx.lifecycle.MutableLiveData
import com.bl4ckcode.sces.models.Cliente
import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.ui.profile.model.ClientUiModel
import com.bl4ckcode.sces.util.ApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface ClientApi {

    @GET("/rest-auth/user")
    fun getClient(): Call<ClientResponse?>

    @GET("/clientes")
    fun getClientId(@Query("email") email: String): Call<List<ClientResponse>?>

    @PUT("/rest-auth/user/")
    fun putClient(@Body client: ClientModel): Call<ClientResponse>
}

class ClientRepository(apiKey: String) {

    private val clientApi: ClientApi = ApiBuilder.create(ClientApi::class.java, apiKey)
    private val _clienttLiveData: MutableLiveData<ClientUiModel?> =
        MutableLiveData<ClientUiModel?>()

    val productLiveData: MutableLiveData<ClientUiModel?>
        get() = _clienttLiveData

    fun getClient() {
        clientApi.getClient().enqueue(object : Callback<ClientResponse?> {
            override fun onResponse(
                call: Call<ClientResponse?>?,
                response: Response<ClientResponse?>
            ) {
                when {
                    response.isSuccessful -> {
                        response.body()?.also {
                            val cliente: Cliente = EcommerceposFactory.eINSTANCE.createCliente()

                            cliente.cpf = it.cpf
                            cliente.estado = it.estado
                            cliente.municipio = it.municipio
                            cliente.telefone = it.telefone
                            cliente.id = it.id ?: run { 0 }
                            cliente.nome = it.nome
                            cliente.endereco = it.endereco

                            _clienttLiveData.postValue(ClientUiModel(false, cliente = cliente))
                        }
                    }
                    response.errorBody() != null -> {
                        val errorBody = response.errorBody()!!.string()
                        _clienttLiveData.postValue(ClientUiModel(true, errorBody))
                    }
                }
            }

            override fun onFailure(call: Call<ClientResponse?>?, t: Throwable?) {
                _clienttLiveData.postValue(ClientUiModel(true))
            }
        })
    }

    fun getClient(email: String) {
        clientApi.getClientId(email)
            .enqueue(object : Callback<List<ClientResponse>?> {
                override fun onResponse(
                    call: Call<List<ClientResponse>?>?,
                    response: Response<List<ClientResponse>?>
                ) {
                    when {
                        response.isSuccessful -> {
                            response.body()?.also {
                                if (!it.isNullOrEmpty()) {
                                    val clientResponse = it[0]
                                    val cliente: Cliente =
                                        EcommerceposFactory.eINSTANCE.createCliente()

                                    cliente.cpf = clientResponse.cpf
                                    cliente.estado = clientResponse.estado
                                    cliente.municipio = clientResponse.municipio
                                    cliente.telefone = clientResponse.telefone
                                    cliente.id = clientResponse.id ?: run { 0 }
                                    cliente.nome = clientResponse.nome
                                    cliente.endereco = clientResponse.endereco

                                    _clienttLiveData.postValue(
                                        ClientUiModel(
                                            false,
                                            cliente = cliente
                                        )
                                    )
                                } else {
                                    _clienttLiveData.postValue(ClientUiModel(true))
                                }
                            }
                        }
                        response.errorBody() != null -> {
                            val errorBody = response.errorBody()!!.string()
                            _clienttLiveData.postValue(ClientUiModel(true, errorBody))
                        }
                    }
                }

                override fun onFailure(call: Call<List<ClientResponse>?>, t: Throwable?) {
                    _clienttLiveData.postValue(ClientUiModel(true))
                }
            })
    }

    fun putClient(client: Cliente) {
        clientApi.putClient(
            ClientModel(
                client.cpf,
                client.nome,
                client.endereco,
                client.estado,
                client.municipio,
                client.telefone
            )
        )
            .enqueue(object : Callback<ClientResponse?> {
                override fun onResponse(
                    call: Call<ClientResponse?>?,
                    response: Response<ClientResponse?>
                ) {
                    when {
                        response.isSuccessful -> {
                            response.body()?.also {
                                val cliente: Cliente = EcommerceposFactory.eINSTANCE.createCliente()
                                cliente.cpf = it.cpf
                                cliente.estado = it.estado
                                cliente.municipio = it.municipio
                                cliente.nome = it.nome
                                cliente.endereco = it.endereco
                                cliente.telefone = it.telefone

                                _clienttLiveData.postValue(ClientUiModel(false, cliente = cliente))
                            }
                        }
                        response.errorBody() != null -> {
                            val errorBody = response.errorBody()!!.string()
                            _clienttLiveData.postValue(ClientUiModel(true, errorBody, null))
                        }
                    }
                }

                override fun onFailure(call: Call<ClientResponse?>?, t: Throwable?) {
                    _clienttLiveData.postValue(ClientUiModel(true, cliente = null))
                }
            })
    }
}