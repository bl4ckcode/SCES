package com.bl4ckcode.sces.ui.orderItems.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.ui.orderItems.detail.model.DetailOrderItemsUiModel
import com.bl4ckcode.sces.ui.orderItems.network.OrderItemsRepository
import com.bl4ckcode.sces.ui.products.network.Step

class DetailOrderItemsViewModel(
    application: Application,
    private val orderItemsRepository: OrderItemsRepository
) : AndroidViewModel(application) {

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
