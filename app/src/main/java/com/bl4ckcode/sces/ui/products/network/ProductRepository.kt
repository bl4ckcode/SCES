package com.bl4ckcode.sces.ui.products.network

import androidx.lifecycle.MutableLiveData
import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.models.Produto
import com.bl4ckcode.sces.ui.products.detail.model.DetailProductUiModel
import com.bl4ckcode.sces.ui.products.list.model.ProductUiModel
import com.bl4ckcode.sces.util.ApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*

enum class Step {
    CREATE, EDIT, DELETE
}

interface ProductApi {

    @GET("/produtos")
    fun getProducts(): Call<List<ProductResponse>?>

    @POST("/produtos/")
    fun postProduct(@Body product: ProductResponse): Call<ProductResponse?>

    @PUT("/produtos/{codigo_produto}/")
    fun putProduct(
        @Path("codigo_produto") product_code: String,
        @Body product: ProductResponse
    ): Call<ProductResponse?>

    @DELETE("/produtos/{codigo_produto}/")
    fun deleteProduct(
        @Path("codigo_produto") product_code: String
    ): Call<ProductResponse?>
}

class ProductRepository {

    private lateinit var productApi: ProductApi

    private val _productLiveData: MutableLiveData<ProductUiModel?> =
        MutableLiveData<ProductUiModel?>()

    private val _detailProductLiveData: MutableLiveData<DetailProductUiModel?> =
        MutableLiveData<DetailProductUiModel?>()

    val productLiveData: MutableLiveData<ProductUiModel?>
        get() = _productLiveData

    val detailProductLiveData: MutableLiveData<DetailProductUiModel?>
        get() = _detailProductLiveData

    fun getProducts(apiKey: String) {
        productApi = ApiBuilder.create(ProductApi::class.java, apiKey)

        productApi.getProducts()
            .enqueue(object : Callback<List<ProductResponse>?> {
                override fun onResponse(
                    call: Call<List<ProductResponse>?>?,
                    response: Response<List<ProductResponse>?>
                ) {
                    when {
                        response.isSuccessful -> {
                            val produtos: ArrayList<Produto> = ArrayList()

                            response.body()?.map { productResponse ->
                                val categoria = EcommerceposFactory.eINSTANCE.createCategoria()
                                categoria.codigo = productResponse.codigoCategoria
                                categoria.nome = productResponse.nomeCategoria

                                val produto = EcommerceposFactory.eINSTANCE.createProduto()
                                produto.codigoProduto = productResponse.codigoProduto
                                produto.nome = productResponse.nome
                                produto.preco = productResponse.preco?.toDouble() ?: run { 0.0 }
                                produto.quantidadeEstoque =
                                    productResponse.quantidadeEstoque?.toDouble() ?: run { 0.0 }
                                produto.cetgorias = categoria

                                produtos.add(produto)
                            }

                            _productLiveData.postValue(ProductUiModel(false, produtos = produtos))
                        }
                        response.errorBody() != null -> {
                            val errorBody = response.errorBody()!!.string()
                            _productLiveData.postValue(ProductUiModel(true, errorBody))
                        }
                    }
                }

                override fun onFailure(call: Call<List<ProductResponse>?>?, t: Throwable?) {
                    _productLiveData.postValue(ProductUiModel(true))
                }
            })
    }

    fun product(step: Step, product: Produto, apiKey: String) {
        productApi = ApiBuilder.create(ProductApi::class.java, apiKey)

        val call: Call<ProductResponse?> = when (step) {
            Step.CREATE -> productApi.postProduct(ProductResponse(product))
            Step.EDIT -> productApi.putProduct(product.codigoProduto, ProductResponse(product))
            Step.DELETE -> productApi.deleteProduct(product.codigoProduto)
        }

        call.enqueue(object : Callback<ProductResponse?> {
            override fun onResponse(
                call: Call<ProductResponse?>?,
                response: Response<ProductResponse?>
            ) {
                when {
                    response.isSuccessful -> {
                        response.body()?.let { productResponse ->
                            val categoria = EcommerceposFactory.eINSTANCE.createCategoria()
                            categoria.codigo = productResponse.codigoCategoria
                            categoria.nome = productResponse.nomeCategoria

                            val produto = EcommerceposFactory.eINSTANCE.createProduto()
                            produto.codigoProduto = productResponse.codigoProduto
                            produto.nome = productResponse.nome
                            produto.preco = productResponse.preco?.toDouble() ?: run { 0.0 }
                            produto.quantidadeEstoque =
                                productResponse.quantidadeEstoque?.toDouble() ?: run { 0.0 }
                            produto.cetgorias = categoria

                            _detailProductLiveData.postValue(
                                DetailProductUiModel(
                                    false,
                                    step = step,
                                    produto = produto,
                                )
                            )
                        } ?: run {
                            if (step == Step.DELETE) {
                                _detailProductLiveData.postValue(
                                    DetailProductUiModel(
                                        false,
                                        produto = product
                                    )
                                )
                            }
                        }
                    }
                    response.errorBody() != null -> {
                        val errorBody = response.errorBody()!!.string()
                        _detailProductLiveData.postValue(DetailProductUiModel(true, errorBody))
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse?>?, t: Throwable?) {
                _detailProductLiveData.postValue(DetailProductUiModel(true))
            }
        })
    }
}
