package com.bl4ckcode.sces.product

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bl4ckcode.sces.models.Produto
import com.bl4ckcode.sces.ui.products.detail.DetailProductViewModel
import com.bl4ckcode.sces.ui.products.detail.model.DetailProductUiModel
import com.bl4ckcode.sces.ui.products.network.ProductRepository
import com.bl4ckcode.sces.ui.products.network.Step
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailProductViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    var productObserver: Observer<DetailProductUiModel?> = Observer {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testCreateProduct() {
        val repositoryMock = Mockito.mock(ProductRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val product = Mockito.mock(Produto::class.java)
        val detailProductUiModelMock = Mockito.mock(DetailProductUiModel::class.java)

        Mockito.`when`(repositoryMock.detailProductLiveData)
            .thenReturn(MutableLiveData<DetailProductUiModel?>())

        Mockito.`when`(repositoryMock.product(Step.CREATE, product, "")).then {
            repositoryMock.detailProductLiveData.postValue(detailProductUiModelMock)
        }

        val viewModel = DetailProductViewModel(applicationMock, repositoryMock)

        viewModel.detailProductLiveData.observeForever(productObserver)

        viewModel.createProduct(product, "")

        Mockito.verify(productObserver).onChanged(detailProductUiModelMock)
    }

    @Test
    @Throws(Exception::class)
    fun testEditProduct() {
        val repositoryMock = Mockito.mock(ProductRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val product = Mockito.mock(Produto::class.java)
        val detailProductUiModelMock = Mockito.mock(DetailProductUiModel::class.java)

        Mockito.`when`(repositoryMock.detailProductLiveData)
            .thenReturn(MutableLiveData<DetailProductUiModel?>())

        Mockito.`when`(repositoryMock.product(Step.EDIT, product, "")).then {
            repositoryMock.detailProductLiveData.postValue(detailProductUiModelMock)
        }

        val viewModel = DetailProductViewModel(applicationMock, repositoryMock)

        viewModel.detailProductLiveData.observeForever(productObserver)

        viewModel.editProduct(product, "")

        Mockito.verify(productObserver).onChanged(detailProductUiModelMock)
    }

    @Test
    @Throws(Exception::class)
    fun testDeleteProduct() {
        val repositoryMock = Mockito.mock(ProductRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val product = Mockito.mock(Produto::class.java)
        val detailProductUiModelMock = Mockito.mock(DetailProductUiModel::class.java)

        Mockito.`when`(repositoryMock.detailProductLiveData)
            .thenReturn(MutableLiveData<DetailProductUiModel?>())

        Mockito.`when`(repositoryMock.product(Step.DELETE, product, "")).then {
            repositoryMock.detailProductLiveData.postValue(detailProductUiModelMock)
        }

        val viewModel = DetailProductViewModel(applicationMock, repositoryMock)

        viewModel.detailProductLiveData.observeForever(productObserver)

        viewModel.deleteProduct(product, "")

        Mockito.verify(productObserver).onChanged(detailProductUiModelMock)
    }

    @After
    fun validate() {
        Mockito.validateMockitoUsage()
    }
}