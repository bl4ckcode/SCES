package com.bl4ckcode.sces.ui.log

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bl4ckcode.sces.databinding.FragmentOrderLogBinding
import com.bl4ckcode.sces.models.Pedido
import com.bl4ckcode.sces.ui.orders.list.OrdersViewModel
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.show
import java.util.*
import kotlin.collections.ArrayList

class OrderLogFragment : Fragment() {
    private lateinit var ordersViewModel: OrdersViewModel
    private var _binding: FragmentOrderLogBinding? = null
    private val binding get() = _binding!!

    private var ordersList: ArrayList<Pedido> = ArrayList()
    private var orderLogAdapter: OrderLogAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ordersViewModel =
            ViewModelProvider(this).get(OrdersViewModel::class.java)
        _binding = FragmentOrderLogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        orderLogAdapter = OrderLogAdapter(ordersList)
        binding.ordersList.layoutManager = LinearLayoutManager(context)
        binding.ordersList.adapter = orderLogAdapter

        val today = Calendar.getInstance()
        binding.datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { _, year, month, day ->
            binding.progress.show()

            val monthFixed = month + 1
            ordersViewModel.orderLogForDate("$year-$monthFixed-$day")
        }

        ordersViewModel.ordersLiveData.observe(viewLifecycleOwner, { orderUiModel ->
            orderUiModel?.pedidos?.let {
                binding.progress.hide()

                ordersList = ArrayList(it)
                orderLogAdapter?.updateData(ordersList)
            }

            orderUiModel?.hasError?.also {
                if (it) {
                    binding.progress.hide()
                    Toast.makeText(requireContext(), orderUiModel.error, Toast.LENGTH_LONG).show()
                }
            }
        })

        ordersViewModel.orderItemsLiveData.observe(viewLifecycleOwner) { orderItemsUiModel ->
            orderItemsUiModel?.itensPedido?.let { itensPedido ->
                var price = 0.0

                ordersList.forEach { pedido ->
                    val itemPedido =
                        ArrayList(itensPedido.filter { pedido.codigoPedido == it.pedido.codigoPedido })
                    var produtos = ""

                    itemPedido.forEach {
                        produtos += "${it.produto.nome} \n"
                        price += it.produto.preco
                    }

                    pedido.clientes.endereco = produtos
                    pedido.clientes.telefone = price.toString()
                }

                orderLogAdapter?.updateData(ordersList)
            }
        }
    }
}