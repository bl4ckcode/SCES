package com.bl4ckcode.sces.ui.products.categories

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.ui.products.categories.model.CategoryUiModel
import com.bl4ckcode.sces.ui.products.network.CategoryRepository
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager

class CategoriesViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(application) }

    private val categoryRepository: CategoryRepository =
        CategoryRepository(preferenceHelper.getApiKey())
    private var _categoryLiveData
    : LiveData<CategoryUiModel?> = categoryRepository.categoryLiveData

    val categoryLiveData: LiveData<CategoryUiModel?>
        get() = _categoryLiveData

    fun categories() {
        categoryRepository.getCategories()
    }
}