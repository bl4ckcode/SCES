package com.bl4ckcode.sces.ui.orders.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.ui.orderItems.list.model.OrderItemsUiModel
import com.bl4ckcode.sces.ui.orders.list.model.OrderUiModel
import com.bl4ckcode.sces.ui.orders.network.OrdersRepository
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager

class OrdersViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(application) }

    private val ordersRepository: OrdersRepository = OrdersRepository(preferenceHelper.getApiKey())
    private var _ordersLiveData: LiveData<OrderUiModel?> = ordersRepository.ordersLiveData

    val ordersLiveData: LiveData<OrderUiModel?>
        get() = _ordersLiveData

    val orderItemsLiveData: LiveData<OrderItemsUiModel?>
        get() = ordersRepository.orderItemsLiveData

    fun orders() {
        ordersRepository.getOrders()
    }
}