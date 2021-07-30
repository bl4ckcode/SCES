package com.bl4ckcode.sces.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.bl4ckcode.sces.MainActivity
import com.bl4ckcode.sces.databinding.ActivityLoginBinding
import com.bl4ckcode.sces.ui.login.network.LoginRepository
import com.bl4ckcode.sces.ui.login.register.RegisterActivity
import com.bl4ckcode.sces.util.ViewModelFactory
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager
import com.bl4ckcode.sces.util.show

class LoginActivity : AppCompatActivity() {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(applicationContext) }

    private val loginViewModel: LoginViewModel by viewModels {
        ViewModelFactory(
            application,
            LoginRepository()
        )
    }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (preferenceHelper.getApiKey().isNotEmpty()) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MainActivity.LOGIN, true)
            intent.putExtra(MainActivity.KEY, preferenceHelper.getApiKey())
            startActivity(intent)
        }

        binding.irLoginButton.isEnabled = false
        binding.irLoginButton.setOnClickListener {
            binding.progress.show()
            loginViewModel.login(binding.email!!, binding.password!!)
        }

        binding.editTextPassword.addTextChangedListener {
            binding.irLoginButton.isEnabled =
                binding.editTextEmail.text.toString().isNotEmpty()
        }

        binding.cadastrarContainer.setOnClickListener {
            val intent = Intent(baseContext, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginViewModel.loginLiveData.observe(this, { loginResponse ->
            loginResponse.key?.let { key ->
                binding.progress.hide()

                preferenceHelper.setApiKey(key)
                preferenceHelper.setEmail(binding.email!!)
                preferenceHelper.setPassword(binding.password!!)

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(MainActivity.LOGIN, true)
                intent.putExtra(MainActivity.KEY, key)
                startActivity(intent)
            }

            loginResponse?.hasError?.also {
                if (it) {
                    binding.progress.hide()
                    Toast.makeText(baseContext, loginResponse.error, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}