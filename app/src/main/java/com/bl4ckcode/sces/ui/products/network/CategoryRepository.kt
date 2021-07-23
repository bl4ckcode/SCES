package com.bl4ckcode.sces.ui.products.network

import androidx.lifecycle.MutableLiveData
import com.bl4ckcode.sces.models.Categoria
import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.ui.products.categories.detail.model.DetailCategoryUiModel
import com.bl4ckcode.sces.ui.products.categories.model.CategoryUiModel
import com.bl4ckcode.sces.util.ApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*

interface CategoryApi {

    @GET("/categorias")
    fun getCategories(): Call<List<Category>?>

    @POST("/categorias/")
    fun postCategory(@Body category: Category): Call<Category?>

    @PUT("/categorias/{codigo_categoria}/")
    fun putCategory(
        @Path("codigo_categoria") category_code: String,
        @Body category: Category
    ): Call<Category?>

    @DELETE("/categorias/{codigo_categoria}/")
    fun deleteCategory(
        @Path("codigo_categoria") category_code: String
    ): Call<Category?>
}

class CategoryRepository(apiKey: String) {

    private val categoryApi: CategoryApi = ApiBuilder.create(CategoryApi::class.java, apiKey)
    private val _categoryLiveData: MutableLiveData<CategoryUiModel?> =
        MutableLiveData<CategoryUiModel?>()

    private val _detailCategoryLiveData: MutableLiveData<DetailCategoryUiModel?> =
        MutableLiveData<DetailCategoryUiModel?>()

    val categoryLiveData: MutableLiveData<CategoryUiModel?>
        get() = _categoryLiveData

    val detailCategoryLiveData: MutableLiveData<DetailCategoryUiModel?>
        get() = _detailCategoryLiveData

    fun getCategories() {
        categoryApi.getCategories()
            .enqueue(object : Callback<List<Category>?> {
                override fun onResponse(
                    call: Call<List<Category>?>?,
                    response: Response<List<Category>?>
                ) {
                    when {
                        response.isSuccessful -> {
                            val categorias: ArrayList<Categoria> = ArrayList()

                            response.body()?.map { categoryResponse ->
                                val categoria = EcommerceposFactory.eINSTANCE.createCategoria()

                                categoria.codigo = categoryResponse.codigo
                                categoria.nome = categoryResponse.nome

                                categorias.add(categoria)
                            }

                            _categoryLiveData.postValue(
                                CategoryUiModel(
                                    false,
                                    categorias = categorias
                                )
                            )
                        }
                        response.errorBody() != null -> {
                            val errorBody = response.errorBody()!!.string()
                            _categoryLiveData.postValue(CategoryUiModel(true, errorBody))
                        }
                    }
                }

                override fun onFailure(call: Call<List<Category>?>?, t: Throwable?) {
                    _categoryLiveData.postValue(CategoryUiModel(true))
                }
            })
    }

    fun category(step: Step, categoria: Categoria) {
        val call: Call<Category?> = when (step) {
            Step.CREATE -> categoryApi.postCategory(Category(categoria = categoria))
            Step.EDIT -> categoryApi.putCategory(categoria.codigo, Category(categoria))
            Step.DELETE -> categoryApi.deleteCategory(categoria.codigo)
        }

        call.enqueue(object : Callback<Category?> {
            override fun onResponse(
                call: Call<Category?>?,
                response: Response<Category?>
            ) {
                when {
                    response.isSuccessful -> {
                        response.body()?.let { categoryResponse ->
                            val category = EcommerceposFactory.eINSTANCE.createCategoria()

                            category.codigo = categoryResponse.codigo
                            category.nome = categoryResponse.nome

                            _detailCategoryLiveData.postValue(
                                DetailCategoryUiModel(
                                    false,
                                    step = step,
                                    categoria = category,
                                )
                            )
                        } ?: run {
                            if (step == Step.DELETE) {
                                _detailCategoryLiveData.postValue(
                                    DetailCategoryUiModel(
                                        false,
                                        categoria = categoria
                                    )
                                )
                            }
                        }
                    }
                    response.errorBody() != null -> {
                        val errorBody = response.errorBody()!!.string()
                        _detailCategoryLiveData.postValue(DetailCategoryUiModel(true, errorBody))
                    }
                }
            }

            override fun onFailure(call: Call<Category?>?, t: Throwable?) {
                _detailCategoryLiveData.postValue(DetailCategoryUiModel(true))
            }
        })
    }
}