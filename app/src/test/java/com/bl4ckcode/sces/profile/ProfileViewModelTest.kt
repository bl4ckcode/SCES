package com.bl4ckcode.sces.profile

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bl4ckcode.sces.models.Cliente
import com.bl4ckcode.sces.ui.profile.ProfileViewModel
import com.bl4ckcode.sces.ui.profile.model.ClientUiModel
import com.bl4ckcode.sces.ui.profile.network.ClientRepository
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ProfileViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    var clientObserver: Observer<ClientUiModel?> = Observer {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testGetClient() {
        val repositoryMock = Mockito.mock(ClientRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val clientUiModelMock = Mockito.mock(ClientUiModel::class.java)

        Mockito.`when`(repositoryMock.productLiveData)
            .thenReturn(MutableLiveData<ClientUiModel?>())

        Mockito.`when`(repositoryMock.getClient()).then {
            repositoryMock.productLiveData.postValue(clientUiModelMock)
        }

        val viewModel = ProfileViewModel(applicationMock, repositoryMock)

        viewModel.clientLiveData.observeForever(clientObserver)

        viewModel.client()

        Mockito.verify(clientObserver).onChanged(clientUiModelMock)
    }

    @Test
    @Throws(Exception::class)
    fun testPutClient() {
        val repositoryMock = Mockito.mock(ClientRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val clientUiModelMock = Mockito.mock(ClientUiModel::class.java)
        val clientMock = Mockito.mock(Cliente::class.java)

        Mockito.`when`(repositoryMock.productLiveData)
            .thenReturn(MutableLiveData<ClientUiModel?>())

        Mockito.`when`(repositoryMock.putClient(clientMock)).then {
            repositoryMock.productLiveData.postValue(clientUiModelMock)
        }

        val viewModel = ProfileViewModel(applicationMock, repositoryMock)

        viewModel.clientLiveData.observeForever(clientObserver)

        viewModel.editClient(clientMock)

        Mockito.verify(clientObserver).onChanged(clientUiModelMock)
    }

    @After
    fun validate() {
        Mockito.validateMockitoUsage()
    }
}