package com.bl4ckcode.sces.ui.products.categories.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.databinding.FragmentDetailCategoryBinding
import com.bl4ckcode.sces.models.Categoria
import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.util.ViewModelFactory
import com.bl4ckcode.sces.ui.products.network.CategoryRepository
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager
import com.bl4ckcode.sces.util.show

class DetailCategoryFragment : Fragment() {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(requireContext()) }

    private val detailCategoryViewModel: DetailCategoryViewModel by viewModels {
        ViewModelFactory(requireActivity().application, CategoryRepository())
    }

    private var _binding: FragmentDetailCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDeleteCategory.hide()

        binding.btnEditCategory.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_save
            )
        )

        binding.btnEditCategory.setOnClickListener {
            binding.progress.show()
            arguments?.let {
                if (it.containsKey(ARG_CATEGORY)) {
                    detailCategoryViewModel.editCategory(
                        getCategoryFromBinding(),
                        preferenceHelper.getApiKey()
                    )
                }
            } ?: run {
                detailCategoryViewModel.createCategory(
                    getCategoryFromBinding(),
                    preferenceHelper.getApiKey()
                )
            }
        }

        binding.btnDeleteCategory.setOnClickListener {
            arguments?.let {
                binding.progress.show()
                if (it.containsKey(ARG_CATEGORY)) {
                    detailCategoryViewModel.deleteCategory(
                        getCategoryFromBinding(),
                        preferenceHelper.getApiKey()
                    )
                }
            }
        }

        arguments?.let { bundle ->
            if (bundle.containsKey(ARG_CATEGORY)) {
                val product = bundle.getSerializable(ARG_CATEGORY) as? Categoria
                product?.let {
                    binding.code = it.codigo
                    binding.name = it.nome

                    binding.categoryCodeTextInput.isEnabled = false

                    binding.btnDeleteCategory.visibility = View.VISIBLE
                    binding.btnEditCategory.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_edit
                        )
                    )
                }
            }
        }

        detailCategoryViewModel.detailCategoryLiveData.observe(
            viewLifecycleOwner,
            { detailCategoryUiModel ->
                detailCategoryUiModel?.categoria?.let {
                    findNavController().popBackStack()
                    Toast.makeText(context, "Opera????o bem sucedida!", Toast.LENGTH_SHORT).show()
                }

                detailCategoryUiModel?.hasError?.also {
                    if (it) {
                        binding.progress.hide()
                        Toast.makeText(
                            requireContext(),
                            detailCategoryUiModel.error,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })
    }

    private fun getCategoryFromBinding(): Categoria {
        val categoria = EcommerceposFactory.eINSTANCE.createCategoria()

        categoria.nome = binding.name
        categoria.codigo = binding.code

        return categoria
    }

    companion object {
        const val ARG_CATEGORY = "category"
    }
}