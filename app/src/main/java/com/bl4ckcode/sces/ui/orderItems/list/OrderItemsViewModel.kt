package com.bl4ckcode.sces.ui.orderItems.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.ui.orderItems.list.model.OrderItemsUiModel
import com.bl4ckcode.sces.ui.orderItems.network.OrderItemsRepository
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager

class OrderItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(application) }

    private val orderItemsRepository: OrderItemsRepository =
        OrderItemsRepository(preferenceHelper.getApiKey())
    private var _orderItemLiveData: LiveData<OrderItemsUiModel?> =
        orderItemsRepository.orderItemsLiveData

    val orderItemLiveData: LiveData<OrderItemsUiModel?>
        get() = _orderItemLiveData

    fun orderItems() {
        orderItemsRepository.getOrderItems()
    }
}