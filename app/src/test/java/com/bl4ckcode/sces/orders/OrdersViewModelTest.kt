package com.bl4ckcode.sces.orders

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bl4ckcode.sces.ui.orders.list.OrdersViewModel
import com.bl4ckcode.sces.ui.orders.list.model.OrderUiModel
import com.bl4ckcode.sces.ui.orders.network.OrdersRepository
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class OrdersViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    var orderObserver: Observer<OrderUiModel?> = Observer {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testGetOrders() {
        val repositoryMock = Mockito.mock(OrdersRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val orderUiModelMock = Mockito.mock(OrderUiModel::class.java)

        Mockito.`when`(repositoryMock.ordersLiveData)
            .thenReturn(MutableLiveData<OrderUiModel?>())

        Mockito.`when`(repositoryMock.getOrders("")).then {
            repositoryMock.ordersLiveData.postValue(orderUiModelMock)
        }

        val viewModel = OrdersViewModel(applicationMock, repositoryMock)

        viewModel.ordersLiveData.observeForever(orderObserver)

        viewModel.orders("")

        Mockito.verify(orderObserver).onChanged(orderUiModelMock)
    }

    /** Retorno Total Pedido
     */
    @Test
    @Throws(Exception::class)
    fun testGetOrdersForDate() {
        val repositoryMock = Mockito.mock(OrdersRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val orderUiModelMock = Mockito.mock(OrderUiModel::class.java)

        Mockito.`when`(repositoryMock.ordersLiveData)
            .thenReturn(MutableLiveData<OrderUiModel?>())

        Mockito.`when`(repositoryMock.getOrders("", date = "")).then {
            repositoryMock.ordersLiveData.postValue(orderUiModelMock)
        }

        val viewModel = OrdersViewModel(applicationMock, repositoryMock)

        viewModel.ordersLiveData.observeForever(orderObserver)

        viewModel.orderLogForDate("", "")

        Mockito.verify(orderObserver).onChanged(orderUiModelMock)
    }

    @After
    fun validate() {
        Mockito.validateMockitoUsage()
    }
}