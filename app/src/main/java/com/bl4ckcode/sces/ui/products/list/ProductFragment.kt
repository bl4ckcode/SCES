package com.bl4ckcode.sces.ui.products.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bl4ckcode.sces.MainActivity
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.databinding.FragmentProductsBinding
import com.bl4ckcode.sces.models.Produto
import com.bl4ckcode.sces.ui.products.detail.DetailProductFragment
import com.bl4ckcode.sces.ui.products.network.ProductRepository
import com.bl4ckcode.sces.ui.search.SearchFragment
import com.bl4ckcode.sces.ui.search.TypeSearch
import com.bl4ckcode.sces.ui.search.TypeSearchEnum
import com.bl4ckcode.sces.util.ViewModelFactory
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.setNavigationResult
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager
import com.bl4ckcode.sces.util.show

class ProductFragment : Fragment(), ProductAdapter.ProductAdapterListener {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(requireContext()) }

    private val productViewModel: ProductViewModel by viewModels {
        ViewModelFactory(requireActivity().application, ProductRepository())
    }

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    private var productsList: ArrayList<Produto> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progress.show()
        productViewModel.products(preferenceHelper.getApiKey())

        arguments?.let {
            if (it.containsKey(SELECT_PRODUCT)) {
                binding.btnCreateProduct.hide()
                binding.btnSearchProduct.hide()
                (activity as? MainActivity)?.hideBottomNav()
            }
        }

        productViewModel.productLiveData.observe(viewLifecycleOwner) { productUiModel ->
            productUiModel?.produtos?.let {
                productsList = ArrayList(it)

                binding.progress.hide()

                val productsAdapter = ProductAdapter(productsList, this)
                binding.productsList.layoutManager = LinearLayoutManager(context)
                binding.productsList.adapter = productsAdapter
            }

            productUiModel?.hasError?.also {
                if (it) {
                    binding.progress.hide()
                    Toast.makeText(requireContext(), productUiModel.error, Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnCreateProduct.setOnClickListener {
            navigateDetail()
        }

        binding.btnSearchProduct.setOnClickListener {
            val bundle = Bundle()
            val typeSearch = TypeSearch(TypeSearchEnum.PRODUCT, productsList = productsList)
            bundle.putSerializable(SearchFragment.ARG_LIST, typeSearch)

            Navigation.findNavController(binding.root)
                .navigate(R.id.action_fragment_products_to_search, bundle)
        }
    }

    override fun productClicked(product: Produto) {
        arguments?.let {
            if (it.containsKey(SELECT_PRODUCT)) {
                setNavigationResult(product, SELECT_PRODUCT)
                (activity as? MainActivity)?.showBottomNav()
                findNavController().popBackStack()
            }
        } ?: run {
            val bundle = Bundle()
            bundle.putSerializable(DetailProductFragment.ARG_PRODUCT, product)
            navigateDetail(bundle)
        }
    }

    private fun navigateDetail(bundle: Bundle? = null) {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_fragment_products_to_nav_graph_detail, bundle)
    }

    companion object {
        const val SELECT_PRODUCT = "selectProduct"
    }
}