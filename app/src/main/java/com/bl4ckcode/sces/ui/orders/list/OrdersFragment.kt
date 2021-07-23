package com.bl4ckcode.sces.ui.orders.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bl4ckcode.sces.MainActivity
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.databinding.FragmentOrdersBinding
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.ui.orders.detail.DetailOrderFragment
import com.bl4ckcode.sces.ui.products.list.ProductFragment
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.setNavigationResult
import com.bl4ckcode.sces.util.show
import java.io.Serializable

class OrdersFragment : Fragment(), OrderAdapter.OrderAdapterListener {
    private lateinit var ordersViewModel: OrdersViewModel
    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ordersViewModel =
            ViewModelProvider(this).get(OrdersViewModel::class.java)
        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progress.show()
        ordersViewModel.orders()

        arguments?.let {
            if (it.containsKey(ProductFragment.SELECT_PRODUCT)) {
                binding.btnCreateOrder.hide()
                (activity as? MainActivity)?.hideBottomNav()
            }
        }

        ordersViewModel.ordersLiveData.observe(viewLifecycleOwner) { orderUiModel ->
            orderUiModel?.pedidos?.let {
                binding.progress.hide()

                val productsAdapter = OrderAdapter(it, this)
                binding.ordersList.layoutManager = LinearLayoutManager(context)
                binding.ordersList.adapter = productsAdapter
            }

            orderUiModel?.hasError?.also {
                if (it) {
                    binding.progress.hide()
                    Toast.makeText(requireContext(), orderUiModel.error, Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnCreateOrder.setOnClickListener {
            navigateDetail()
        }
    }

    override fun orderClicked(order: Pedido) {
        arguments?.let {
            if (it.containsKey(SELECT_ORDER)) {
                setNavigationResult(order, SELECT_ORDER)
                (activity as? MainActivity)?.showBottomNav()
                findNavController().popBackStack()
            }
        } ?: run {
            val bundle = Bundle()
            bundle.putSerializable(DetailOrderFragment.ARG_ORDERS_LIST, getOrderItemsForOrder(order) as Serializable)
            bundle.putSerializable(DetailOrderFragment.ARG_ORDER, order)
            navigateDetail(bundle)
        }
    }

    private fun getOrderItemsForOrder(order: Pedido): ArrayList<ItensPedido>? {
        ordersViewModel.orderItemsLiveData.value?.let {
            return ArrayList(it.itensPedido.filter { it.pedido.codigoPedido == order.codigoPedido })
        } ?: run {
            return null
        }
    }

    private fun navigateDetail(bundle: Bundle? = null) {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_fragment_orders_to_nav_graph_detail, bundle)
    }

    companion object {
        const val SELECT_ORDER = "selectOrder"
    }
}