package com.bl4ckcode.sces.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bl4ckcode.sces.databinding.FragmentSearchBinding
import com.bl4ckcode.sces.models.Categoria
import com.bl4ckcode.sces.models.Produto
import com.bl4ckcode.sces.ui.products.categories.CategoryAdapter
import com.bl4ckcode.sces.ui.products.list.ProductAdapter

class SearchFragment : Fragment(), ProductAdapter.ProductAdapterListener,
    CategoryAdapter.CategoryAdapterListener {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private var productList: ArrayList<Produto> = ArrayList()
    private var filteredProductList: ArrayList<Produto> = ArrayList()

    private var categoriesList: ArrayList<Categoria> = ArrayList()
    private var filteredCategoriesList: ArrayList<Categoria> = ArrayList()

    private var typeSearch: TypeSearchEnum? = null

    private var productAdapter: ProductAdapter? = null
    private var categoryAdapter: CategoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val typeSearch = it.getSerializable(ARG_LIST) as TypeSearch
            this.typeSearch = typeSearch.typeSearchEnum
            when (typeSearch.typeSearchEnum) {
                TypeSearchEnum.PRODUCT -> configProductsList(ArrayList(typeSearch.productsList!!))
                TypeSearchEnum.CATEGORY -> configCategoriesList(ArrayList(typeSearch.categoriesList!!))
            }
        }

        binding.searchIdEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let { searchTerm ->
                    if (searchTerm.length > 2) {
                        typeSearch?.let {
                            when (it) {
                                TypeSearchEnum.PRODUCT -> filterProductsList(searchTerm.toString())
                                TypeSearchEnum.CATEGORY -> filterCategoryList(searchTerm.toString())
                            }
                        }
                    }

                    if (searchTerm.isEmpty()) {
                        typeSearch?.let {
                            when (it) {
                                TypeSearchEnum.PRODUCT -> {
                                    filteredProductList = ArrayList(productList)
                                    productAdapter?.updateData(filteredProductList)
                                }
                                TypeSearchEnum.CATEGORY -> {
                                    filteredCategoriesList = ArrayList(categoriesList)
                                    categoryAdapter?.updateData(filteredCategoriesList)
                                }
                            }
                        }
                    }
                }
            }
        })
    }

    private fun filterCategoryList(searchTerm: String) {
        typeSearch?.let {
            filteredCategoriesList.clear()
            filteredCategoriesList.addAll(categoriesList.filter {
                it.nome.contains(
                    searchTerm,
                    ignoreCase = true
                )
            })
            categoryAdapter?.updateData(filteredCategoriesList)
        }
    }

    private fun filterProductsList(searchTerm: String) {
        typeSearch?.let {
            filteredProductList.clear()
            filteredProductList.addAll(productList.filter {
                it.nome.contains(
                    searchTerm,
                    ignoreCase = true
                )
            })
            productAdapter?.updateData(filteredProductList)
        }
    }

    override fun productClicked(product: Produto) {

    }

    override fun categoryClicked(categoria: Categoria) {

    }

    private fun configProductsList(list: ArrayList<Produto>) {
        productList = list
        filteredProductList = ArrayList(productList)

        productAdapter = ProductAdapter(ArrayList(filteredProductList), this)
        binding.list.adapter = productAdapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun configCategoriesList(list: ArrayList<Categoria>) {
        categoriesList = list
        filteredCategoriesList = ArrayList(categoriesList)

        categoryAdapter = CategoryAdapter(ArrayList(filteredCategoriesList), this)
        binding.list.adapter = categoryAdapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        const val ARG_LIST = "list"
    }
}