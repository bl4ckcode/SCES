package com.bl4ckcode.sces.ui.orders.list

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
import com.bl4ckcode.sces.databinding.FragmentOrdersBinding
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.ui.orders.detail.DetailOrderFragment
import com.bl4ckcode.sces.ui.orders.network.OrdersRepository
import com.bl4ckcode.sces.util.ViewModelFactory
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.setNavigationResult
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager
import com.bl4ckcode.sces.util.show
import java.io.Serializable

class OrdersFragment : Fragment(), OrderAdapter.OrderAdapterListener {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(requireContext()) }

    private val ordersViewModel: OrdersViewModel by viewModels {
        ViewModelFactory(requireActivity().application, OrdersRepository())
    }

    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!

    private var ordersList: ArrayList<Pedido> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
        ordersViewModel.orders(preferenceHelper.getApiKey())

        arguments?.let {
            if (it.containsKey(SELECT_ORDER)) {
                binding.btnCreateOrder.hide()
                binding.btnGenOrderLog.visibility = View.INVISIBLE
                (activity as? MainActivity)?.hideBottomNav()
            }
        }

        ordersViewModel.ordersLiveData.observe(viewLifecycleOwner) { orderUiModel ->
            orderUiModel?.pedidos?.let {
                binding.progress.hide()

                ordersList = ArrayList(it)

                binding.ordersList.adapter = OrderAdapter(ordersList, this)
                binding.ordersList.layoutManager = LinearLayoutManager(context)
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

        binding.btnGenOrderLog.setOnClickListener {
            navigateLog()
        }
    }

    private fun navigateLog() {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_fragment_orders_to_log)
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
            bundle.putSerializable(
                DetailOrderFragment.ARG_ORDERS_LIST,
                getOrderItemsForOrder(order) as Serializable
            )
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