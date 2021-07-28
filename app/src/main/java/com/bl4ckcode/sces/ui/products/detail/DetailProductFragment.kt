package com.bl4ckcode.sces.ui.products.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.databinding.FragmentDetailProductBinding
import com.bl4ckcode.sces.models.Categoria
import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.models.Produto
import com.bl4ckcode.sces.ui.products.categories.CategoriesFragment
import com.bl4ckcode.sces.util.*

class DetailProductFragment : Fragment() {
    private lateinit var detailProductViewModel: DetailProductViewModel
    private var _binding: FragmentDetailProductBinding? = null
    private val binding get() = _binding!!

    private var produto: Produto = EcommerceposFactory.eINSTANCE.createProduto()
    private var categoria: Categoria = EcommerceposFactory.eINSTANCE.createCategoria()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailProductViewModel =
            ViewModelProvider(this).get(DetailProductViewModel::class.java)
        _binding = FragmentDetailProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDeleteProduct.hide()

        binding.btnEditProduct.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_save
            )
        )

        binding.btnEditProduct.setOnClickListener {
            binding.progress.show()
            arguments?.let {
                if (it.containsKey(ARG_PRODUCT)) {
                    detailProductViewModel.editProduct(getProductFromBinding())
                }
            } ?: run {
                detailProductViewModel.createProduct(getProductFromBinding())
            }
        }

        binding.btnDeleteProduct.setOnClickListener {
            arguments?.let {
                binding.progress.show()
                if (it.containsKey(ARG_PRODUCT)) {
                    detailProductViewModel.deleteProduct(getProductFromBinding())
                }
            }
        }

        binding.categoryContainer.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(CategoriesFragment.SELECT_CATEGORY, true)
            navigateSelectCategory(bundle)

            produto = getProductFromBinding()
        }

        arguments?.let { bundle ->
            if (bundle.containsKey(ARG_PRODUCT)) {
                val product = bundle.getSerializable(ARG_PRODUCT) as? Produto
                product?.let {
                    categoria = it.cetgorias

                    binding.code = it.codigoProduto
                    binding.name = it.nome
                    binding.price = it.preco.toCurrencyString()
                    binding.reserve = it.quantidadeEstoque.toString()
                    binding.category = categoria.nome

                    binding.productCodeEditText.isEnabled = false

                    binding.btnDeleteProduct.visibility = View.VISIBLE
                    binding.btnEditProduct.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_edit
                        )
                    )
                }
            }
        }

        detailProductViewModel.detailProductLiveData.observe(
            viewLifecycleOwner,
            { detailProductUiModel ->
                detailProductUiModel?.produto?.let {
                    findNavController().popBackStack()
                    Toast.makeText(context, "Operação bem sucedida!", Toast.LENGTH_SHORT).show()
                }

                detailProductUiModel?.hasError?.also {
                    if (it) {
                        binding.progress.hide()
                        Toast.makeText(
                            requireContext(),
                            detailProductUiModel.error,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })

        getNavigationResult<Categoria>(CategoriesFragment.SELECT_CATEGORY)?.let {
            categoria.codigo = it.codigo
            categoria.nome = it.nome

            binding.category = categoria.nome

            binding.code = produto.codigoProduto
            binding.name = produto.nome
            binding.price = produto.preco.toString()
            binding.reserve = produto.quantidadeEstoque.toString()
        }
    }

    private fun getProductFromBinding(): Produto {
        val product = EcommerceposFactory.eINSTANCE.createProduto()

        product.nome = binding.name
        product.codigoProduto = binding.code
        product.preco = binding.price?.substringAfter("$")?.toDouble() ?: run { 0.0 }
        product.quantidadeEstoque = binding.reserve?.toDouble() ?: run { 0.0 }
        product.cetgorias?.let {
            it.codigo = categoria.codigo
            it.nome = categoria.nome
        } ?: run {
            product.cetgorias = categoria
        }

        return product
    }

    private fun navigateSelectCategory(bundle: Bundle? = null) {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_fragment_detail_product_to_categories, bundle)
    }

    companion object {
        const val ARG_PRODUCT = "product"
    }
}