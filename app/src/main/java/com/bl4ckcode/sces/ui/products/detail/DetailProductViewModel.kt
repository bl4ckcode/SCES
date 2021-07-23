package com.bl4ckcode.sces.ui.products.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.models.Produto
import com.bl4ckcode.sces.ui.products.detail.model.DetailProductUiModel
import com.bl4ckcode.sces.ui.products.network.ProductRepository
import com.bl4ckcode.sces.ui.products.network.Step
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager

class DetailProductViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(application) }

    private val productRepository: ProductRepository =
        ProductRepository(preferenceHelper.getApiKey())
    private var _detailProductLiveData: LiveData<DetailProductUiModel?> =
        productRepository.detailProductLiveData

    val detailProductLiveData: LiveData<DetailProductUiModel?>
        get() = _detailProductLiveData

    fun createProduct(product: Produto) {
        productRepository.product(Step.CREATE, product)
    }

    fun editProduct(product: Produto) {
        productRepository.product(Step.EDIT, product)
    }

    fun deleteProduct(product: Produto) {
        productRepository.product(Step.DELETE, product)
    }
}