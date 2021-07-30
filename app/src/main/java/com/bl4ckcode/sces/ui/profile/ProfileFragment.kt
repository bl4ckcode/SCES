package com.bl4ckcode.sces.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bl4ckcode.sces.databinding.FragmentProfileBinding
import com.bl4ckcode.sces.models.EcommerceposFactory
import com.bl4ckcode.sces.ui.profile.network.ClientRepository
import com.bl4ckcode.sces.util.ViewModelFactory
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager
import com.bl4ckcode.sces.util.show

class ProfileFragment : Fragment() {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(requireContext()) }

    private val profileViewModel: ProfileViewModel by viewModels {
        ViewModelFactory(
            requireActivity().application,
            ClientRepository(preferenceHelper.getApiKey())
        )
    }

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progress.show()
        profileViewModel.client()

        profileViewModel.clientLiveData.observe(viewLifecycleOwner, { clientUiModel ->
            clientUiModel?.cliente?.let {
                binding.progress.hide()

                binding.nome = it.nome
                binding.cpf = it.cpf
                binding.endereco = it.endereco
                binding.cidade = it.municipio
                binding.estado = it.estado
                binding.celular = it.telefone

                preferenceHelper.setClientId(it.id.toString())
            }

            clientUiModel?.hasError?.also {
                if (it) {
                    binding.progress.hide()
                    Toast.makeText(requireContext(), clientUiModel.error, Toast.LENGTH_LONG).show()
                }
            }

        })

        binding.btnEditClient.setOnClickListener {
            var shouldSave = true

            binding.nome?.let {
                if (it.isEmpty()) {
                    shouldSave = false
                    binding.nameEditText.error = "Campo não pode ficar vazio."
                } else {
                    binding.nameEditText.error = null
                }
            }

            binding.cpf?.let {
                if (it.isEmpty()) {
                    shouldSave = false
                    binding.cpfEditText.error = "Campo não pode ficar vazio."
                } else {
                    binding.cpfEditText.error = null
                }
            }

            binding.endereco?.let {
                if (it.isEmpty()) {
                    shouldSave = false
                    binding.addressEditText.error = "Campo não pode ficar vazio."
                } else {
                    binding.addressEditText.error = null
                }
            }

            binding.estado?.let {
                if (it.isEmpty()) {
                    shouldSave = false
                    binding.stateEditText.error = "Campo não pode ficar vazio."
                } else {
                    binding.stateEditText.error = null
                }
            }

            binding.cidade?.let {
                if (it.isEmpty()) {
                    shouldSave = false
                    binding.cityEditText.error = "Campo não pode ficar vazio."
                } else {
                    binding.cityEditText.error = null
                }
            }

            binding.celular?.let {
                if (it.isEmpty()) {
                    shouldSave = false
                    binding.phoneEditText.error = "Campo não pode ficar vazio."
                } else {
                    binding.phoneEditText.error = null
                }
            }

            if (shouldSave) {
                val client = EcommerceposFactory.eINSTANCE.createCliente()

                client.nome = binding.nome
                client.cpf = binding.cpf
                client.endereco = binding.endereco
                client.municipio = binding.cidade
                client.estado = binding.estado
                client.telefone = binding.celular

                binding.progress.show()

                profileViewModel.editClient(client)
            }
        }
    }
}