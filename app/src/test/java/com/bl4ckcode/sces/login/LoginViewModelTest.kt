package com.bl4ckcode.sces.login

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bl4ckcode.sces.ui.login.LoginViewModel
import com.bl4ckcode.sces.ui.login.network.LoginRepository
import com.bl4ckcode.sces.ui.login.network.models.LoginResponse
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LoginViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    var loginObserver: Observer<LoginResponse?> = Observer {}

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Throws(Exception::class)
    fun testGetClient() {
        val repositoryMock = Mockito.mock(LoginRepository::class.java)
        val applicationMock = Mockito.mock(Application::class.java)
        val loginResponseMock = Mockito.mock(LoginResponse::class.java)

        Mockito.`when`(repositoryMock.loginLiveData)
            .thenReturn(MutableLiveData<LoginResponse>())

        Mockito.`when`(repositoryMock.login("", "")).then {
            repositoryMock.loginLiveData.postValue(loginResponseMock)
        }

        val viewModel = LoginViewModel(applicationMock, repositoryMock)

        viewModel.loginLiveData.observeForever(loginObserver)

        viewModel.login("", "")

        Mockito.verify(loginObserver).onChanged(loginResponseMock)
    }


    @After
    fun validate() {
        Mockito.validateMockitoUsage()
    }
}