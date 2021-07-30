package com.bl4ckcode.sces.ui.products.categories

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
import com.bl4ckcode.sces.databinding.FragmentCategoriesBinding
import com.bl4ckcode.sces.models.Categoria
import com.bl4ckcode.sces.ui.products.categories.detail.DetailCategoryFragment
import com.bl4ckcode.sces.util.ViewModelFactory
import com.bl4ckcode.sces.ui.products.network.CategoryRepository
import com.bl4ckcode.sces.ui.search.SearchFragment
import com.bl4ckcode.sces.ui.search.TypeSearch
import com.bl4ckcode.sces.ui.search.TypeSearchEnum
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.setNavigationResult
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager
import com.bl4ckcode.sces.util.show

class CategoriesFragment : Fragment(), CategoryAdapter.CategoryAdapterListener {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(requireContext()) }

    private val categoryViewModel: CategoriesViewModel by viewModels {
        ViewModelFactory(requireActivity().application, CategoryRepository())
    }
    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    private var categoriesList: ArrayList<Categoria> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progress.show()
        categoryViewModel.categories(preferenceHelper.getApiKey())

        arguments?.let {
            if (it.containsKey(SELECT_CATEGORY)) {
                binding.btnCreateCategory.hide()
                binding.btnSearchCategory.hide()
                (activity as? MainActivity)?.hideBottomNav()
            }
        }

        categoryViewModel.categoryLiveData.observe(viewLifecycleOwner) { categoryUiModel ->
            categoryUiModel?.categorias?.let {
                categoriesList = ArrayList(it)

                binding.progress.hide()

                val productsAdapter = CategoryAdapter(categoriesList, this)
                binding.categoriesList.layoutManager = LinearLayoutManager(context)
                binding.categoriesList.adapter = productsAdapter
            }

            categoryUiModel?.hasError?.also {
                if (it) {
                    binding.progress.hide()
                    Toast.makeText(requireContext(), categoryUiModel.error, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

        binding.btnCreateCategory.setOnClickListener {
            navigateDetail()
        }

        binding.btnSearchCategory.setOnClickListener {
            val bundle = Bundle()
            val typeSearch = TypeSearch(TypeSearchEnum.CATEGORY, categoriesList = categoriesList)
            bundle.putSerializable(SearchFragment.ARG_LIST, typeSearch)

            Navigation.findNavController(binding.root)
                .navigate(R.id.action_fragment_categories_to_search, bundle)
        }
    }

    override fun categoryClicked(categoria: Categoria) {
        arguments?.let {
            if (it.containsKey(SELECT_CATEGORY)) {
                setNavigationResult(categoria, SELECT_CATEGORY)
                (activity as? MainActivity)?.showBottomNav()
                findNavController().popBackStack()
            }
        } ?: run {
            val bundle = Bundle()
            bundle.putSerializable(DetailCategoryFragment.ARG_CATEGORY, categoria)
            navigateDetail(bundle)
        }
    }

    private fun navigateDetail(bundle: Bundle? = null) {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_fragment_categories_to_nav_graph_detail, bundle)
    }

    companion object {
        const val SELECT_CATEGORY = "selectCategory"
    }
}