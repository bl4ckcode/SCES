package com.bl4ckcode.sces.ui.products.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.ui.products.list.model.ProductUiModel
import com.bl4ckcode.sces.ui.products.network.ProductRepository

class ProductViewModel constructor(
    application: Application, private val productRepository: ProductRepository =
        ProductRepository()
) : AndroidViewModel(application) {

    private var _productLiveData: LiveData<ProductUiModel?> = productRepository.productLiveData

    val productLiveData: LiveData<ProductUiModel?>
        get() = _productLiveData

    fun products(apiKey: String) {
        productRepository.getProducts(apiKey)
    }
}