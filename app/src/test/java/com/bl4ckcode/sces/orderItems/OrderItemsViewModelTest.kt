package com.bl4ckcode.sces.orderItems

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bl4ckcode.sces.ui.orderItems.list.OrderItemsViewModel
import com.bl4ckcode.sces.ui.orderItems.list.model.OrderItemsUiModel
import com.bl4ckcode.sces.ui.orderItems.network.OrderItemsRepository
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class OrderItemsViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    var orderItemObserver: Observer<OrderItemsUiModel?> = Observer {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testGetOrders() {
        val repositoryMock = Mockito.mock(OrderItemsRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val orderItemUiModel = Mockito.mock(OrderItemsUiModel::class.java)

        Mockito.`when`(repositoryMock.orderItemsLiveData)
            .thenReturn(MutableLiveData<OrderItemsUiModel?>())

        Mockito.`when`(repositoryMock.getOrderItems()).then {
            repositoryMock.orderItemsLiveData.postValue(orderItemUiModel)
        }

        val viewModel = OrderItemsViewModel(applicationMock, repositoryMock)

        viewModel.orderItemLiveData.observeForever(orderItemObserver)

        viewModel.orderItems()

        Mockito.verify(orderItemObserver).onChanged(orderItemUiModel)
    }

    @After
    fun validate() {
        Mockito.validateMockitoUsage()
    }
}