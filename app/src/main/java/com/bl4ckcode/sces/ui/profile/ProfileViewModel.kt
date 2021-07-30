package com.bl4ckcode.sces.ui.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.models.Cliente
import com.bl4ckcode.sces.ui.profile.model.ClientUiModel
import com.bl4ckcode.sces.ui.profile.network.ClientRepository

class ProfileViewModel(
    application: Application,
    private val clientRepository: ClientRepository
) : AndroidViewModel(application) {

    private var _clientLiveData: LiveData<ClientUiModel?> = clientRepository.productLiveData

    val clientLiveData: LiveData<ClientUiModel?>
        get() = _clientLiveData

    fun client() {
        clientRepository.getClient()
    }

    fun editClient(client: Cliente?) {
        client?.let {
            clientRepository.putClient(client)
        }
    }
}
