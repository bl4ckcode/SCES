package com.bl4ckcode.sces.ui.orderItems.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.databinding.FragmentDetailOrderItemsBinding
import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.models.Produto
import com.bl4ckcode.sces.ui.orderItems.network.OrderItemsRepository
import com.bl4ckcode.sces.ui.orders.list.OrdersFragment
import com.bl4ckcode.sces.ui.products.list.ProductFragment
import com.bl4ckcode.sces.util.*
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager

class DetailOrderItemsFragment : Fragment() {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(requireContext()) }

    private val detailOrderItemsViewModel: DetailOrderItemsViewModel by viewModels {
        ViewModelFactory(
            requireActivity().application,
            OrderItemsRepository(preferenceHelper.getApiKey())
        )
    }

    private var _binding: FragmentDetailOrderItemsBinding? = null
    private val binding get() = _binding!!

    private val itemPedido: ItensPedido = EcommerceposFactory.eINSTANCE.createItensPedido()
    private val order = EcommerceposFactory.eINSTANCE.createPedido()
    private val product = EcommerceposFactory.eINSTANCE.createProduto()

    private var isEditing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailOrderItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.order = "Selecionar pedido"
        binding.product = "Selecionar produto"

        binding.btnCreateEditOrderItem.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_save
            )
        )

        binding.btnCreateEditOrderItem.setOnClickListener {
            binding.progress.show()
            arguments?.let {
                getItemOrderFromBinding()

                if (it.containsKey(ARG_ORDER_ITEM)) {
                    detailOrderItemsViewModel.editOrderItem(itemPedido)
                } else {
                    detailOrderItemsViewModel.createOrderItem(itemPedido)
                }
            } ?: run {
                getItemOrderFromBinding()

                if (isEditing) {
                    detailOrderItemsViewModel.editOrderItem(itemPedido)
                } else {
                    detailOrderItemsViewModel.createOrderItem(itemPedido)
                }
            }
        }

        binding.btnDeleteOrderItem.setOnClickListener {
            arguments?.let {
                binding.progress.show()
                if (it.containsKey(ARG_ORDER_ITEM)) {
                    getItemOrderFromBinding()
                    detailOrderItemsViewModel.deleteOrderItem(itemPedido)
                }
            }
        }

        binding.orderContainer.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(OrdersFragment.SELECT_ORDER, true)
            navigateSelectOrder(bundle)

            getItemOrderFromBinding()

            arguments = null
        }

        binding.productContainer.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(ProductFragment.SELECT_PRODUCT, true)
            navigateSelectProducts(bundle)

            getItemOrderFromBinding()

            arguments = null
        }

        arguments?.let { bundle ->
            if (bundle.containsKey(ARG_ORDER)) {
                val pedido = bundle.getSerializable(ARG_ORDER) as Pedido
                binding.order = pedido.codigoPedido

                itemPedido.pedido = pedido
            } else if (bundle.containsKey(ARG_ORDER_ITEM)) {
                isEditing = true

                val orderItem = bundle.getSerializable(ARG_ORDER_ITEM) as? ItensPedido

                orderItem?.let {
                    itemPedido.id = it.id
                    itemPedido.quantidade = it.quantidade

                    order.codigoPedido = it.pedido.codigoPedido
                    product.codigoProduto = it.produto.codigoProduto
                    product.nome = it.produto.nome

                    binding.id = itemPedido.id.toString()
                    binding.product = product.nome
                    binding.order = order.codigoPedido
                    binding.amount = itemPedido.quantidade.toString()

                    binding.btnDeleteOrderItem.show()
                    binding.btnCreateEditOrderItem.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_edit
                        )
                    )
                }
            }
        }

        detailOrderItemsViewModel.detailOrderItemLiveData.observe(
            viewLifecycleOwner,
            { detailProductUiModel ->
                detailProductUiModel?.itensPedido?.let {
                    setNavigationResult(it, ARG_ORDER_ITEM)
                    findNavController().popBackStack()
                    Toast.makeText(
                        context,
                        "Opera????o bem sucedida!!",
                        Toast.LENGTH_SHORT
                    ).show()
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

        getNavigationResult<Pedido>(OrdersFragment.SELECT_ORDER)?.let {
            order.codigoPedido = it.codigoPedido

            binding.id = itemPedido.id.toString()
            binding.product = product.nome
            binding.amount = itemPedido.quantidade.toString()
            binding.order = order.codigoPedido
        }

        getNavigationResult<Produto>(ProductFragment.SELECT_PRODUCT)?.let {
            product.codigoProduto = it.codigoProduto
            product.nome = it.nome

            binding.id = itemPedido.id.toString()
            binding.product = product.nome
            binding.amount = itemPedido.quantidade.toString()
            binding.order = order.codigoPedido
        }
    }

    private fun getItemOrderFromBinding() {
        itemPedido.id = binding.id?.toInt() ?: run { 0 }
        itemPedido.produto = product
        itemPedido.pedido = order
        itemPedido.quantidade = binding.amount?.toDouble() ?: run { 0.0 }
    }

    private fun navigateSelectProducts(bundle: Bundle? = null) {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_fragment_detail_order_items_to_products, bundle)
    }

    private fun navigateSelectOrder(bundle: Bundle? = null) {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_fragment_detail_order_items_to_orders, bundle)
    }

    companion object {
        const val ARG_ORDER_ITEM = "order_item"
        const val ARG_ORDER = "order"
    }
}