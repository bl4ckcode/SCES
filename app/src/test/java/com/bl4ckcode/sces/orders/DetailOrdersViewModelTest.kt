package com.bl4ckcode.sces.orders

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.ui.orders.detail.DetailOrderViewModel
import com.bl4ckcode.sces.ui.orders.detail.model.DetailOrderUiModel
import com.bl4ckcode.sces.ui.orders.network.OrdersRepository
import com.bl4ckcode.sces.ui.products.network.Step
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailOrdersViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    var orderObserver: Observer<DetailOrderUiModel?> = Observer {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testCreateOrder() {
        val repositoryMock = Mockito.mock(OrdersRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val order = Mockito.mock(Pedido::class.java)
        val detailOrderUiModelMock = Mockito.mock(DetailOrderUiModel::class.java)

        Mockito.`when`(repositoryMock.detailOrderLiveData)
            .thenReturn(MutableLiveData<DetailOrderUiModel?>())

        Mockito.`when`(repositoryMock.order(Step.CREATE, order, "")).then {
            repositoryMock.detailOrderLiveData.postValue(detailOrderUiModelMock)
        }

        val viewModel = DetailOrderViewModel(applicationMock, repositoryMock)

        viewModel.detailOrderLiveData.observeForever(orderObserver)

        viewModel.createOrder(order, "")

        Mockito.verify(orderObserver).onChanged(detailOrderUiModelMock)
    }

    @Test
    @Throws(Exception::class)
    fun testEditOrder() {
        val repositoryMock = Mockito.mock(OrdersRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val order = Mockito.mock(Pedido::class.java)
        val detailOrderUiModelMock = Mockito.mock(DetailOrderUiModel::class.java)

        Mockito.`when`(repositoryMock.detailOrderLiveData)
            .thenReturn(MutableLiveData<DetailOrderUiModel?>())

        Mockito.`when`(repositoryMock.order(Step.EDIT, order, "")).then {
            repositoryMock.detailOrderLiveData.postValue(detailOrderUiModelMock)
        }

        val viewModel = DetailOrderViewModel(applicationMock, repositoryMock)

        viewModel.detailOrderLiveData.observeForever(orderObserver)

        viewModel.editOrder(order, "")

        Mockito.verify(orderObserver).onChanged(detailOrderUiModelMock)
    }

    @Test
    @Throws(Exception::class)
    fun testDeleteOrder() {
        val repositoryMock = Mockito.mock(OrdersRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val order = Mockito.mock(Pedido::class.java)
        val detailOrderUiModelMock = Mockito.mock(DetailOrderUiModel::class.java)

        Mockito.`when`(repositoryMock.detailOrderLiveData)
            .thenReturn(MutableLiveData<DetailOrderUiModel?>())

        Mockito.`when`(repositoryMock.order(Step.DELETE, order, "")).then {
            repositoryMock.detailOrderLiveData.postValue(detailOrderUiModelMock)
        }

        val viewModel = DetailOrderViewModel(applicationMock, repositoryMock)

        viewModel.detailOrderLiveData.observeForever(orderObserver)

        viewModel.deleteOrder(order, "")

        Mockito.verify(orderObserver).onChanged(detailOrderUiModelMock)
    }

    @After
    fun validate() {
        Mockito.validateMockitoUsage()
    }
}