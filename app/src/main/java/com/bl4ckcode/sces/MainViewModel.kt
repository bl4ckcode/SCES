package com.bl4ckcode.sces

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bl4ckcode.sces.ui.profile.model.ClientUiModel
import com.bl4ckcode.sces.ui.profile.network.ClientRepository
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(application) }

    private val clientRepository: ClientRepository = ClientRepository(preferenceHelper.getApiKey())
    private var _clientLiveData: LiveData<ClientUiModel?> = clientRepository.productLiveData

    val clientLiveData: LiveData<ClientUiModel?>
        get() = _clientLiveData

    fun client() {
        clientRepository.getClient(preferenceHelper.getEmailKey())
    }
}