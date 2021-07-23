package com.bl4ckcode.sces.ui.orderItems.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.ui.orderItems.detail.model.DetailOrderItemsUiModel
import com.bl4ckcode.sces.ui.orderItems.network.OrderItemsRepository
import com.bl4ckcode.sces.ui.products.network.Step
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager

class DetailOrderItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(application) }

    private val orderItemsRepository: OrderItemsRepository =
        OrderItemsRepository(preferenceHelper.getApiKey())
    private var _detailProductLiveData: LiveData<DetailOrderItemsUiModel?> =
        orderItemsRepository.detailOrderItemLiveData

    val detailOrderItemLiveData: LiveData<DetailOrderItemsUiModel?>
        get() = _detailProductLiveData

    fun createOrderItem(itensPedido: ItensPedido) {
        orderItemsRepository.orderItem(Step.CREATE, itensPedido)
    }

    fun editOrderItem(itensPedido: ItensPedido) {
        orderItemsRepository.orderItem(Step.EDIT, itensPedido)
    }

    fun deleteOrderItem(itensPedido: ItensPedido) {
        orderItemsRepository.orderItem(Step.DELETE, itensPedido)
    }
}
