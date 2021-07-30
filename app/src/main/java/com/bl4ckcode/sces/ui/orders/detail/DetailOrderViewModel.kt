package com.bl4ckcode.sces.ui.orders.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.ui.orders.detail.model.DetailOrderUiModel
import com.bl4ckcode.sces.ui.orders.network.OrdersRepository
import com.bl4ckcode.sces.ui.products.network.Step

class DetailOrderViewModel(
    application: Application,
    private val ordersRepository: OrdersRepository = OrdersRepository()
) : AndroidViewModel(application) {

    private var _detailOrderLiveData: LiveData<DetailOrderUiModel?> =
        ordersRepository.detailOrderLiveData

    val detailOrderLiveData: LiveData<DetailOrderUiModel?>
        get() = _detailOrderLiveData

    fun createOrder(order: Pedido, apiKey: String) {
        ordersRepository.order(Step.CREATE, order, apiKey)
    }

    fun editOrder(order: Pedido, apiKey: String) {
        ordersRepository.order(Step.EDIT, order, apiKey)
    }

    fun deleteOrder(order: Pedido, apiKey: String) {
        ordersRepository.order(Step.DELETE, order, apiKey)
    }
}