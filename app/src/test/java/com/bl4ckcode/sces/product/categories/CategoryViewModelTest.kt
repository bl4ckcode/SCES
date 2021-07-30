package com.bl4ckcode.sces.product.categories

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bl4ckcode.sces.ui.products.categories.CategoriesViewModel
import com.bl4ckcode.sces.ui.products.categories.model.CategoryUiModel
import com.bl4ckcode.sces.ui.products.network.CategoryRepository
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CategoryViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    var categoryObserver: Observer<CategoryUiModel?> = Observer {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testGetCategories() {
        val repositoryMock = Mockito.mock(CategoryRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val categoryUiModelMock = Mockito.mock(CategoryUiModel::class.java)

        Mockito.`when`(repositoryMock.categoryLiveData)
            .thenReturn(MutableLiveData<CategoryUiModel?>())

        Mockito.`when`(repositoryMock.getCategories("")).then {
            repositoryMock.categoryLiveData.postValue(categoryUiModelMock)
        }

        val viewModel = CategoriesViewModel(applicationMock, repositoryMock)

        viewModel.categoryLiveData.observeForever(categoryObserver)

        viewModel.categories("")

        Mockito.verify(categoryObserver).onChanged(categoryUiModelMock)
    }

    @After
    fun validate() {
        Mockito.validateMockitoUsage()
    }
}