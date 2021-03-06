package com.bl4ckcode.sces.ui.orders.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.databinding.FragmentDetailOrderBinding
import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.ui.orders.network.OrdersRepository
import com.bl4ckcode.sces.util.ViewModelFactory
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager
import com.bl4ckcode.sces.util.show
import com.bl4ckcode.sces.util.toCurrency

class DetailOrderFragment : Fragment() {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(requireContext()) }

    private val detailOrderViewModel: DetailOrderViewModel by viewModels {
        ViewModelFactory(requireActivity().application, OrdersRepository())
    }
    private var _binding: FragmentDetailOrderBinding? = null
    private val binding get() = _binding!!

    private var orderItensList: MutableList<ItensPedido> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.orderItemsList.layoutManager = LinearLayoutManager(context)

        binding.btnDeleteOrder.hide()
        binding.orderItemsList.hide()

        binding.btnEditOrder.setOnClickListener {
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_save
            )
        }

        binding.btnEditOrder.setOnClickListener {
            binding.progress.show()
            arguments?.let {
                if (it.containsKey(ARG_ORDER)) {
                    detailOrderViewModel.editOrder(
                        getOrderFromBinding(),
                        preferenceHelper.getApiKey()
                    )
                }
            } ?: run {
                detailOrderViewModel.createOrder(
                    getOrderFromBinding(),
                    preferenceHelper.getApiKey()
                )
            }
        }

        binding.btnDeleteOrder.setOnClickListener {
            arguments?.let {
                binding.progress.show()
                if (it.containsKey(ARG_ORDER)) {
                    detailOrderViewModel.deleteOrder(
                        getOrderFromBinding(),
                        preferenceHelper.getApiKey()
                    )
                }
            }
        }

        arguments?.let {
            if (it.containsKey(ARG_ORDER)) {
                val order = it.getSerializable(ARG_ORDER) as? Pedido
                order?.let { orderIt ->
                    binding.numero = orderIt.codigoPedido
                    binding.data = orderIt.dataPedido
                    binding.nomeCliente = orderIt.clientes.nome

                    binding.orderIdEditText.isEnabled = false
                    binding.orderClientNameEditText.isEnabled = false

                    binding.btnDeleteOrder.show()
                    binding.orderClientNameTextInput.show()

                    binding.btnEditOrder.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_edit
                        )
                    )
                }
            }

            if (it.containsKey(ARG_ORDERS_LIST)) {
                orderItensList = it.getSerializable(ARG_ORDERS_LIST) as ArrayList<ItensPedido>

                binding.orderPriceTextInput.show()
                binding.price =
                    orderItensList.map { it.produto.preco * it.quantidade }.sum().toCurrency()

                binding.orderItemsList.adapter = OrderItemAdapter(orderItensList)
                binding.orderItemsList.show()
            }
        }

        detailOrderViewModel.detailOrderLiveData.observe(
            viewLifecycleOwner,
            { detailOrderUiModel ->
                detailOrderUiModel?.pedido?.let {
                    findNavController().popBackStack()
                    Toast.makeText(context, "Opera????o bem sucedidade!", Toast.LENGTH_SHORT).show()
                }

                detailOrderUiModel?.hasError?.also {
                    if (it) {
                        binding.progress.hide()
                        Toast.makeText(
                            requireContext(),
                            detailOrderUiModel.error,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })
    }

    private fun getOrderFromBinding(): Pedido {
        val order = EcommerceposFactory.eINSTANCE.createPedido()
        val client = EcommerceposFactory.eINSTANCE.createCliente()

        client.id = preferenceHelper.getClientId().toInt()

        order.codigoPedido = binding.numero
        order.dataPedido = binding.data
        order.clientes = client

        return order
    }

    companion object {
        const val ARG_ORDER = "order"
        const val ARG_ORDERS_LIST = "ordersList"
    }
}