package com.bl4ckcode.sces.ui.products.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.ui.products.list.model.ProductUiModel
import com.bl4ckcode.sces.ui.products.network.ProductRepository
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(application) }

    private val productRepository: ProductRepository =
        ProductRepository(preferenceHelper.getApiKey())
    private var _productLiveData: LiveData<ProductUiModel?> = productRepository.productLiveData

    val productLiveData: LiveData<ProductUiModel?>
        get() = _productLiveData

    fun products() {
        productRepository.getProducts()
    }
}