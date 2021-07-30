package com.bl4ckcode.sces.ui.orderItems.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bl4ckcode.sces.MainActivity
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.databinding.FragmentOrderItemsBinding
import com.bl4ckcode.sces.models.ItensPedido
import com.bl4ckcode.sces.ui.orderItems.detail.DetailOrderItemsFragment
import com.bl4ckcode.sces.ui.orderItems.network.OrderItemsRepository
import com.bl4ckcode.sces.util.ViewModelFactory
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager
import com.bl4ckcode.sces.util.show

class OrderItemsFragment : Fragment(), OrderItemsAdapter.OrderItemsAdapterAdapterListener {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(requireContext()) }

    private val orderItemsViewModel: OrderItemsViewModel by viewModels {
        ViewModelFactory(
            requireActivity().application,
            OrderItemsRepository(preferenceHelper.getApiKey())
        )
    }

    private var _binding: FragmentOrderItemsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progress.show()
        orderItemsViewModel.orderItems()

        arguments?.let {
            if (it.containsKey(DetailOrderItemsFragment.ARG_ORDER_ITEM)) {
                binding.btnCreateOrderItem.hide()
                (activity as? MainActivity)?.hideBottomNav()
            }
        }

        orderItemsViewModel.orderItemLiveData.observe(viewLifecycleOwner) { orderItemUiModel ->
            orderItemUiModel?.itensPedido?.let {
                binding.progress.hide()

                val orderItemsAdapter = OrderItemsAdapter(it, this)
                binding.ordersItemsList.layoutManager = LinearLayoutManager(context)
                binding.ordersItemsList.adapter = orderItemsAdapter
            }

            orderItemUiModel?.hasError?.also {
                if (it) {
                    binding.progress.hide()
                    Toast.makeText(requireContext(), orderItemUiModel.error, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

        binding.btnCreateOrderItem.setOnClickListener {
            navigateDetailOrderItem()
        }
    }

    override fun orderItemClicked(orderItem: ItensPedido) {
        val bundle = Bundle()
        bundle.putSerializable(DetailOrderItemsFragment.ARG_ORDER_ITEM, orderItem)
        navigateDetailOrderItem(bundle)
    }

    private fun navigateDetailOrderItem(bundle: Bundle? = null) {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_fragment_order_items_to_nav_graph_detail, bundle)
    }
}