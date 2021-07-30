package com.bl4ckcode.sces.ui.products.categories

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.ui.products.categories.model.CategoryUiModel
import com.bl4ckcode.sces.ui.products.network.CategoryRepository

class CategoriesViewModel(
    application: Application,
    private val categoryRepository: CategoryRepository =
        CategoryRepository()
) : AndroidViewModel(application) {

    private var _categoryLiveData
            : LiveData<CategoryUiModel?> = categoryRepository.categoryLiveData

    val categoryLiveData: LiveData<CategoryUiModel?>
        get() = _categoryLiveData

    fun categories(apiKey: String) {
        categoryRepository.getCategories(apiKey)
    }
}