package com.bl4ckcode.sces.ui.orderItems.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.ui.orderItems.list.model.OrderItemsUiModel
import com.bl4ckcode.sces.ui.orderItems.network.OrderItemsRepository

class OrderItemsViewModel(
    application: Application,
    private val orderItemsRepository: OrderItemsRepository
) : AndroidViewModel(application) {
    private var _orderItemLiveData: LiveData<OrderItemsUiModel?> =
        orderItemsRepository.orderItemsLiveData

    val orderItemLiveData: LiveData<OrderItemsUiModel?>
        get() = _orderItemLiveData

    fun orderItems() {
        orderItemsRepository.getOrderItems()
    }
}