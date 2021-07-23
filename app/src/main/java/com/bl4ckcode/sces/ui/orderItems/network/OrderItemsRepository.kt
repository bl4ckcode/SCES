package com.bl4ckcode.sces.ui.orderItems.network

import androidx.lifecycle.MutableLiveData
import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.ui.orderItems.detail.model.DetailOrderItemsUiModel
import com.bl4ckcode.sces.ui.orderItems.list.model.OrderItemsUiModel
import com.bl4ckcode.sces.ui.orderItems.network.model.OrderItemsResponse
import com.bl4ckcode.sces.ui.products.network.Step
import com.bl4ckcode.sces.util.ApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*

interface OrderItemsApi {

    @GET("/itens")
    fun getOrderItems(): Call<List<OrderItemsResponse>?>

    @POST("/itens/")
    fun postOrderItem(@Body order: OrderItemsResponse): Call<OrderItemsResponse?>

    @PUT("/itens/{id}/")
    fun putOrderItem(
        @Path("id") id: String,
        @Body order: OrderItemsResponse
    ): Call<OrderItemsResponse?>

    @DELETE("/itens/{id}/")
    fun deleteOrderItem(
        @Path("id") order_code: String
    ): Call<OrderItemsResponse?>
}

class OrderItemsRepository(apiKey: String) {

    private val orderItemsApi: OrderItemsApi = ApiBuilder.create(OrderItemsApi::class.java, apiKey)
    private val _orderItemsLiveData: MutableLiveData<OrderItemsUiModel?> =
        MutableLiveData<OrderItemsUiModel?>()
    private val _detailOrderItemsLiveData: MutableLiveData<DetailOrderItemsUiModel?> =
        MutableLiveData<DetailOrderItemsUiModel?>()

    val orderItemsLiveData: MutableLiveData<OrderItemsUiModel?>
        get() = _orderItemsLiveData

    val detailOrderItemLiveData: MutableLiveData<DetailOrderItemsUiModel?>
        get() = _detailOrderItemsLiveData

    fun getOrderItems() {
        orderItemsApi.getOrderItems()
            .enqueue(object : Callback<List<OrderItemsResponse>?> {
                override fun onResponse(
                    call: Call<List<OrderItemsResponse>?>?,
                    response: Response<List<OrderItemsResponse>?>
                ) {
                    when {
                        response.isSuccessful -> {
                            val itensPedidos: ArrayList<ItensPedido> = ArrayList()

                            response.body()?.map { orderItemResponse ->
                                val itensPedido = EcommerceposFactory.eINSTANCE.createItensPedido()
                                val produto = EcommerceposFactory.eINSTANCE.createProduto()
                                val pedido = EcommerceposFactory.eINSTANCE.createPedido()

                                produto.codigoProduto = orderItemResponse.produto
                                produto.nome = orderItemResponse.nomeProduto
                                pedido.codigoPedido = orderItemResponse.pedido

                                itensPedido.id = orderItemResponse.id ?: run { 0 }
                                itensPedido.produto = produto
                                itensPedido.pedido = pedido
                                itensPedido.quantidade =
                                    orderItemResponse.quantidade?.toDouble() ?: run { 0.0 }

                                itensPedidos.add(itensPedido)
                            }

                            orderItemsLiveData.postValue(
                                OrderItemsUiModel(
                                    false,
                                    itensPedido = itensPedidos
                                )
                            )
                        }
                        response.errorBody() != null -> {
                            val errorBody = response.errorBody()!!.string()
                            orderItemsLiveData.postValue(OrderItemsUiModel(true, errorBody))
                        }
                    }
                }

                override fun onFailure(call: Call<List<OrderItemsResponse>?>?, t: Throwable?) {
                    orderItemsLiveData.postValue(OrderItemsUiModel(true))
                }
            })
    }

    fun orderItem(step: Step, orderItem: ItensPedido) {
        val call: Call<OrderItemsResponse?> = when (step) {
            Step.CREATE -> orderItemsApi.postOrderItem(OrderItemsResponse(orderItem))
            Step.EDIT -> orderItemsApi.putOrderItem(
                orderItem.id.toString(),
                OrderItemsResponse(orderItem)
            )
            Step.DELETE -> orderItemsApi.deleteOrderItem(
                orderItem.id.toString()
            )
        }

        call.enqueue(object : Callback<OrderItemsResponse?> {
            override fun onResponse(
                call: Call<OrderItemsResponse?>?,
                response: Response<OrderItemsResponse?>
            ) {
                when {
                    response.isSuccessful -> {
                        response.body()?.let { orderItemResponse ->
                            val itensPedido = EcommerceposFactory.eINSTANCE.createItensPedido()
                            val produto = EcommerceposFactory.eINSTANCE.createProduto()
                            val pedido = EcommerceposFactory.eINSTANCE.createPedido()

                            produto.codigoProduto = orderItemResponse.produto
                            produto.nome = orderItemResponse.nomeProduto
                            pedido.codigoPedido = orderItemResponse.pedido

                            itensPedido.id = orderItemResponse.id ?: run { 0 }
                            itensPedido.produto = produto
                            itensPedido.pedido = pedido
                            itensPedido.quantidade =
                                orderItemResponse.quantidade?.toDouble() ?: run { 0.0 }

                            _detailOrderItemsLiveData.postValue(
                                DetailOrderItemsUiModel(
                                    false,
                                    step = step,
                                    itensPedido = itensPedido,
                                )
                            )
                        } ?: run {
                            if (step == Step.DELETE) {
                                _detailOrderItemsLiveData.postValue(
                                    DetailOrderItemsUiModel(
                                        false,
                                        itensPedido = orderItem
                                    )
                                )
                            }
                        }
                    }
                    response.errorBody() != null -> {
                        val errorBody = response.errorBody()!!.string()
                        _detailOrderItemsLiveData.postValue(
                            DetailOrderItemsUiModel(
                                true,
                                errorBody
                            )
                        )
                    }
                }
            }

            override fun onFailure(call: Call<OrderItemsResponse?>?, t: Throwable?) {
                _detailOrderItemsLiveData.postValue(DetailOrderItemsUiModel(true))
            }
        })
    }
}