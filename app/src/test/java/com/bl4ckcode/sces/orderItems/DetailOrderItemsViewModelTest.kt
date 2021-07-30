package com.bl4ckcode.sces.orderItems

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.ui.orderItems.detail.DetailOrderItemsViewModel
import com.bl4ckcode.sces.ui.orderItems.detail.model.DetailOrderItemsUiModel
import com.bl4ckcode.sces.ui.orderItems.network.OrderItemsRepository
import com.bl4ckcode.sces.ui.products.network.Step
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailOrderItemsViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    var orderItemObserver: Observer<DetailOrderItemsUiModel?> = Observer {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testCreateOrderItem() {
        val repositoryMock = Mockito.mock(OrderItemsRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val order = Mockito.mock(ItensPedido::class.java)
        val detailOrderUiModelMock = Mockito.mock(DetailOrderItemsUiModel::class.java)

        Mockito.`when`(repositoryMock.detailOrderItemLiveData)
            .thenReturn(MutableLiveData<DetailOrderItemsUiModel?>())

        Mockito.`when`(repositoryMock.orderItem(Step.CREATE, order)).then {
            repositoryMock.detailOrderItemLiveData.postValue(detailOrderUiModelMock)
        }

        val viewModel = DetailOrderItemsViewModel(applicationMock, repositoryMock)

        viewModel.detailOrderItemLiveData.observeForever(orderItemObserver)

        viewModel.createOrderItem(order)

        Mockito.verify(orderItemObserver).onChanged(detailOrderUiModelMock)
    }

    @Test
    @Throws(Exception::class)
    fun testEditOrderItem() {
        val repositoryMock = Mockito.mock(OrderItemsRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val order = Mockito.mock(ItensPedido::class.java)
        val detailOrderUiModelMock = Mockito.mock(DetailOrderItemsUiModel::class.java)

        Mockito.`when`(repositoryMock.detailOrderItemLiveData)
            .thenReturn(MutableLiveData<DetailOrderItemsUiModel?>())

        Mockito.`when`(repositoryMock.orderItem(Step.EDIT, order)).then {
            repositoryMock.detailOrderItemLiveData.postValue(detailOrderUiModelMock)
        }

        val viewModel = DetailOrderItemsViewModel(applicationMock, repositoryMock)

        viewModel.detailOrderItemLiveData.observeForever(orderItemObserver)

        viewModel.editOrderItem(order)

        Mockito.verify(orderItemObserver).onChanged(detailOrderUiModelMock)
    }

    @Test
    @Throws(Exception::class)
    fun testDeleteOrderItem() {
        val repositoryMock = Mockito.mock(OrderItemsRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val order = Mockito.mock(ItensPedido::class.java)
        val detailOrderUiModelMock = Mockito.mock(DetailOrderItemsUiModel::class.java)

        Mockito.`when`(repositoryMock.detailOrderItemLiveData)
            .thenReturn(MutableLiveData<DetailOrderItemsUiModel?>())

        Mockito.`when`(repositoryMock.orderItem(Step.DELETE, order)).then {
            repositoryMock.detailOrderItemLiveData.postValue(detailOrderUiModelMock)
        }

        val viewModel = DetailOrderItemsViewModel(applicationMock, repositoryMock)

        viewModel.detailOrderItemLiveData.observeForever(orderItemObserver)

        viewModel.deleteOrderItem(order)

        Mockito.verify(orderItemObserver).onChanged(detailOrderUiModelMock)
    }

    @After
    fun validate() {
        Mockito.validateMockitoUsage()
    }
}