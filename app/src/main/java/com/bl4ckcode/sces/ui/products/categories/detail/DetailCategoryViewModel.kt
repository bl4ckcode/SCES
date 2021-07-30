package com.bl4ckcode.sces.ui.products.categories.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.models.Categoria
import com.bl4ckcode.sces.ui.products.categories.detail.model.DetailCategoryUiModel
import com.bl4ckcode.sces.ui.products.network.CategoryRepository
import com.bl4ckcode.sces.ui.products.network.Step

class DetailCategoryViewModel(
    application: Application,
    private val categoryRepository: CategoryRepository =
        CategoryRepository()
) : AndroidViewModel(application) {

    private var _detailCategoryLiveData: LiveData<DetailCategoryUiModel?> =
        categoryRepository.detailCategoryLiveData

    val detailCategoryLiveData: LiveData<DetailCategoryUiModel?>
        get() = _detailCategoryLiveData

    fun createCategory(category: Categoria, apiKey: String) {
        categoryRepository.category(Step.CREATE, category, apiKey)
    }

    fun editCategory(category: Categoria, apiKey: String) {
        categoryRepository.category(Step.EDIT, category, apiKey)
    }

    fun deleteCategory(category: Categoria, apiKey: String) {
        categoryRepository.category(Step.DELETE, category, apiKey)
    }
}