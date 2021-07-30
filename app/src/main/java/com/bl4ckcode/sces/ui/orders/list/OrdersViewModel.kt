package com.bl4ckcode.sces.ui.orders.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.ui.orderItems.list.model.OrderItemsUiModel
import com.bl4ckcode.sces.ui.orders.list.model.OrderUiModel
import com.bl4ckcode.sces.ui.orders.network.OrdersRepository

class OrdersViewModel(
    application: Application,
    private val ordersRepository: OrdersRepository = OrdersRepository()
) : AndroidViewModel(application) {

    private var _ordersLiveData: LiveData<OrderUiModel?> = ordersRepository.ordersLiveData

    val ordersLiveData: LiveData<OrderUiModel?>
        get() = _ordersLiveData

    val orderItemsLiveData: LiveData<OrderItemsUiModel?>
        get() = ordersRepository.orderItemsLiveData

    fun orders(apiKey: String) {
        ordersRepository.getOrders(apiKey)
    }

    fun orderLogForDate(apiKey: String, date: String) {
        ordersRepository.getOrders(apiKey, date)
    }
}