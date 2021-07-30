package com.bl4ckcode.sces.product

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bl4ckcode.sces.ui.products.list.ProductViewModel
import com.bl4ckcode.sces.ui.products.list.model.ProductUiModel
import com.bl4ckcode.sces.ui.products.network.ProductRepository
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.validateMockitoUsage
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class ProductViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    var productObserver: Observer<ProductUiModel?> = Observer {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testGetProducts() {
        val repositoryMock = Mockito.mock(ProductRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val productUiModelMock = Mockito.mock(ProductUiModel::class.java)

        Mockito.`when`(repositoryMock.productLiveData)
            .thenReturn(MutableLiveData<ProductUiModel?>())

        Mockito.`when`(repositoryMock.getProducts("")).then {
            repositoryMock.productLiveData.postValue(productUiModelMock)
        }

        val viewModel = ProductViewModel(applicationMock, repositoryMock)

        viewModel.productLiveData.observeForever(productObserver)

        viewModel.products("")

        verify(productObserver).onChanged(productUiModelMock)
    }

    @After
    fun validate() {
        validateMockitoUsage()
    }
}