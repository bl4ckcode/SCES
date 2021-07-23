package com.bl4ckcode.sces.ui.orders.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.ui.orders.detail.model.DetailOrderUiModel
import com.bl4ckcode.sces.ui.orders.network.OrdersRepository
import com.bl4ckcode.sces.ui.products.network.Step
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager

class DetailOrderViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(application) }

    private val ordersRepository: OrdersRepository = OrdersRepository(preferenceHelper.getApiKey())
    private var _detailOrderLiveData: LiveData<DetailOrderUiModel?> =
        ordersRepository.detailOrderLiveData

    val detailOrderLiveData: LiveData<DetailOrderUiModel?>
        get() = _detailOrderLiveData

    fun createOrder(order: Pedido) {
        ordersRepository.order(Step.CREATE, order)
    }

    fun editOrder(order: Pedido) {
        ordersRepository.order(Step.EDIT, order)
    }

    fun deleteOrder(order: Pedido) {
        ordersRepository.order(Step.DELETE, order)
    }
}