package com.bl4ckcode.sces.ui.products.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.models.Produto
import com.bl4ckcode.sces.ui.products.detail.model.DetailProductUiModel
import com.bl4ckcode.sces.ui.products.network.ProductRepository
import com.bl4ckcode.sces.ui.products.network.Step

class DetailProductViewModel(
    application: Application, private val productRepository: ProductRepository =
        ProductRepository()
) : AndroidViewModel(application) {

    private var _detailProductLiveData: LiveData<DetailProductUiModel?> =
        productRepository.detailProductLiveData

    val detailProductLiveData: LiveData<DetailProductUiModel?>
        get() = _detailProductLiveData

    fun createProduct(product: Produto, apiKey: String) {
        productRepository.product(Step.CREATE, product, apiKey)
    }

    fun editProduct(product: Produto, apiKey: String) {
        productRepository.product(Step.EDIT, product, apiKey)
    }

    fun deleteProduct(product: Produto, apiKey: String) {
        productRepository.product(Step.DELETE, product, apiKey)
    }
}