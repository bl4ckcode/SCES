package com.bl4ckcode.sces.product.categories

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bl4ckcode.sces.models.Categoria
import com.bl4ckcode.sces.ui.products.categories.detail.DetailCategoryViewModel
import com.bl4ckcode.sces.ui.products.categories.detail.model.DetailCategoryUiModel
import com.bl4ckcode.sces.ui.products.network.CategoryRepository
import com.bl4ckcode.sces.ui.products.network.Step
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailCategoryViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    var categoryObserver: Observer<DetailCategoryUiModel?> = Observer {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testCreateCategory() {
        val repositoryMock = Mockito.mock(CategoryRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val category = Mockito.mock(Categoria::class.java)
        val detailCategoryUiModelMock = Mockito.mock(DetailCategoryUiModel::class.java)

        Mockito.`when`(repositoryMock.detailCategoryLiveData)
            .thenReturn(MutableLiveData<DetailCategoryUiModel?>())

        Mockito.`when`(repositoryMock.category(Step.CREATE, category, "")).then {
            repositoryMock.detailCategoryLiveData.postValue(detailCategoryUiModelMock)
        }

        val viewModel = DetailCategoryViewModel(applicationMock, repositoryMock)

        viewModel.detailCategoryLiveData.observeForever(categoryObserver)

        viewModel.createCategory(category, "")

        Mockito.verify(categoryObserver).onChanged(detailCategoryUiModelMock)
    }

    @Test
    @Throws(Exception::class)
    fun testEditCategory() {
        val repositoryMock = Mockito.mock(CategoryRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val category = Mockito.mock(Categoria::class.java)
        val detailCategoryUiModelMock = Mockito.mock(DetailCategoryUiModel::class.java)

        Mockito.`when`(repositoryMock.detailCategoryLiveData)
            .thenReturn(MutableLiveData<DetailCategoryUiModel?>())

        Mockito.`when`(repositoryMock.category(Step.EDIT, category, "")).then {
            repositoryMock.detailCategoryLiveData.postValue(detailCategoryUiModelMock)
        }

        val viewModel = DetailCategoryViewModel(applicationMock, repositoryMock)

        viewModel.detailCategoryLiveData.observeForever(categoryObserver)

        viewModel.editCategory(category, "")

        Mockito.verify(categoryObserver).onChanged(detailCategoryUiModelMock)
    }

    @Test
    @Throws(Exception::class)
    fun testDeleteCategory() {
        val repositoryMock = Mockito.mock(CategoryRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val category = Mockito.mock(Categoria::class.java)
        val detailCategoryUiModelMock = Mockito.mock(DetailCategoryUiModel::class.java)

        Mockito.`when`(repositoryMock.detailCategoryLiveData)
            .thenReturn(MutableLiveData<DetailCategoryUiModel?>())

        Mockito.`when`(repositoryMock.category(Step.DELETE, category, "")).then {
            repositoryMock.detailCategoryLiveData.postValue(detailCategoryUiModelMock)
        }

        val viewModel = DetailCategoryViewModel(applicationMock, repositoryMock)

        viewModel.detailCategoryLiveData.observeForever(categoryObserver)

        viewModel.deleteCategory(category, "")

        Mockito.verify(categoryObserver).onChanged(detailCategoryUiModelMock)
    }

    @After
    fun validate() {
        Mockito.validateMockitoUsage()
    }
}