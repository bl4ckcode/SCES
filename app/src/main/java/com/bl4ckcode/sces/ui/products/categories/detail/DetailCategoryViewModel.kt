package com.bl4ckcode.sces.ui.products.categories.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.models.Categoria
import com.bl4ckcode.sces.ui.products.categories.detail.model.DetailCategoryUiModel
import com.bl4ckcode.sces.ui.products.network.CategoryRepository
import com.bl4ckcode.sces.ui.products.network.Step
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager

class DetailCategoryViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(application) }

    private val categoryRepository: CategoryRepository =
        CategoryRepository(preferenceHelper.getApiKey())
    private var _detailCategoryLiveData: LiveData<DetailCategoryUiModel?> =
        categoryRepository.detailCategoryLiveData

    val detailCategoryLiveData: LiveData<DetailCategoryUiModel?>
        get() = _detailCategoryLiveData

    fun createCategory(category: Categoria) {
        categoryRepository.category(Step.CREATE, category)
    }

    fun editCategory(category: Categoria) {
        categoryRepository.category(Step.EDIT, category)
    }

    fun deleteCategory(category: Categoria) {
        categoryRepository.category(Step.DELETE, category)
    }
}