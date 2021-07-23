package com.bl4ckcode.sces.ui.orders.network

import androidx.lifecycle.MutableLiveData
import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.ui.orderItems.list.model.OrderItemsUiModel
import com.bl4ckcode.sces.ui.orders.detail.model.DetailOrderUiModel
import com.bl4ckcode.sces.ui.orders.list.model.OrderUiModel
import com.bl4ckcode.sces.ui.products.network.Step
import com.bl4ckcode.sces.util.ApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*

interface OrdersApi {

    @GET("/pedidos")
    fun getOrders(): Call<List<OrdersResponse>?>

    @POST("/pedidos/")
    fun postOrder(@Body order: OrdersResponse): Call<OrdersResponse?>

    @PUT("/pedidos/{codigo_pedido}/")
    fun putOrder(
        @Path("codigo_pedido") order_code: String,
        @Body order: OrdersResponse
    ): Call<OrdersResponse?>

    @DELETE("/pedidos/{codigo_pedido}/")
    fun deleteOrder(
        @Path("codigo_pedido") order_code: String
    ): Call<OrdersResponse?>
}

class OrdersRepository(apiKey: String) {
    private val ordersApi: OrdersApi = ApiBuilder.create(OrdersApi::class.java, apiKey)
    private val _ordersLiveData: MutableLiveData<OrderUiModel?> = MutableLiveData<OrderUiModel?>()
    private val _detailOrdersLiveData: MutableLiveData<DetailOrderUiModel?> =
        MutableLiveData<DetailOrderUiModel?>()
    private val _orderItemsLiveData: MutableLiveData<OrderItemsUiModel?> =
        MutableLiveData<OrderItemsUiModel?>()

    val ordersLiveData: MutableLiveData<OrderUiModel?>
        get() = _ordersLiveData

    val orderItemsLiveData: MutableLiveData<OrderItemsUiModel?>
        get() = _orderItemsLiveData

    val detailOrderLiveData: MutableLiveData<DetailOrderUiModel?>
        get() = _detailOrdersLiveData

    fun getOrders() {
        ordersApi.getOrders()
            .enqueue(object : Callback<List<OrdersResponse>?> {
                override fun onResponse(
                    call: Call<List<OrdersResponse>?>?,
                    response: Response<List<OrdersResponse>?>
                ) {
                    when {
                        response.isSuccessful -> {
                            val pedidos: ArrayList<Pedido> = ArrayList()
                            val itensPedido: ArrayList<ItensPedido> = ArrayList()

                            response.body()?.map { orderResponse ->
                                val pedido = EcommerceposFactory.eINSTANCE.createPedido()

                                pedido.codigoPedido = orderResponse.codigoPedido
                                pedido.dataPedido = orderResponse.dataPedido

                                itensPedido.add(orderResponse.itensPedido.mapNotNull { it?.asItensPedido() }
                                    .first())
                                pedidos.add(pedido)
                            }

                            ordersLiveData.postValue(OrderUiModel(false, pedidos = pedidos))
                            orderItemsLiveData.postValue(
                                OrderItemsUiModel(
                                    false,
                                    itensPedido = itensPedido
                                )
                            )
                        }
                        response.errorBody() != null -> {
                            val errorBody = response.errorBody()!!.string()
                            ordersLiveData.postValue(OrderUiModel(true, errorBody))
                        }
                    }
                }

                override fun onFailure(call: Call<List<OrdersResponse>?>?, t: Throwable?) {
                    ordersLiveData.postValue(OrderUiModel(true))
                }
            })
    }

    fun order(step: Step, order: Pedido) {
        val call: Call<OrdersResponse?> = when (step) {
            Step.CREATE -> ordersApi.postOrder(OrdersResponse(order))
            Step.EDIT -> ordersApi.putOrder(order.codigoPedido, OrdersResponse(order))
            Step.DELETE -> ordersApi.deleteOrder(order.codigoPedido)
        }

        call.enqueue(object : Callback<OrdersResponse?> {
            override fun onResponse(
                call: Call<OrdersResponse?>?,
                response: Response<OrdersResponse?>
            ) {
                when {
                    response.isSuccessful -> {
                        response.body()?.let { orderResponse ->
                            val pedido = EcommerceposFactory.eINSTANCE.createPedido()
                            val cliente = EcommerceposFactory.eINSTANCE.createCliente()

                            cliente.id = orderResponse.cliente?.toInt() ?: run { 0 }

                            pedido.codigoPedido = orderResponse.codigoPedido
                            pedido.dataPedido = orderResponse.dataPedido
                            pedido.clientes = cliente

                            _detailOrdersLiveData.postValue(
                                DetailOrderUiModel(
                                    false,
                                    step = step,
                                    pedido = pedido,
                                )
                            )
                        } ?: run {
                            if (step == Step.DELETE) {
                                _detailOrdersLiveData.postValue(
                                    DetailOrderUiModel(
                                        false,
                                        pedido = order
                                    )
                                )
                            }
                        }
                    }
                    response.errorBody() != null -> {
                        val errorBody = response.errorBody()!!.string()
                        _detailOrdersLiveData.postValue(DetailOrderUiModel(true, errorBody))
                    }
                }
            }

            override fun onFailure(call: Call<OrdersResponse?>?, t: Throwable?) {
                _detailOrdersLiveData.postValue(DetailOrderUiModel(true))
            }
        })
    }
}