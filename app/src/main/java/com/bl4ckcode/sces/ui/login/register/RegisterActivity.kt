package com.bl4ckcode.sces.ui.login.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bl4ckcode.sces.MainActivity
import com.bl4ckcode.sces.databinding.ActivityRegisterBinding
import com.bl4ckcode.sces.util.hide
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager
import com.bl4ckcode.sces.util.show

class RegisterActivity : AppCompatActivity() {
    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(applicationContext) }

    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerViewModel =
            ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.txtViewReturnLogin.setOnClickListener {
            onBackPressed()
        }

        binding.buttonRegister.setOnClickListener {
            var shouldRegister = true

            binding.email?.let {
                if (it.isEmpty()) {
                    shouldRegister = false
                    binding.editTextEmail.error = "Campo não pode ficar vazio."
                } else {
                    binding.editTextEmail.error = null
                }
            }

            binding.password?.let {
                if (it.isEmpty()) {
                    shouldRegister = false
                    binding.editTextPassword.error = "Campo não pode ficar vazio."
                } else {
                    binding.editTextPassword.error = null
                }
            }

            binding.confirmPassword?.let {
                if (it.isEmpty()) {
                    shouldRegister = false
                    binding.editTextConfirmPassword.error = "Campo não pode ficar vazio."
                } else {
                    binding.editTextConfirmPassword.error = null
                }
            }

            if (shouldRegister) {
                binding.progress.show()
                registerViewModel.register(binding.email!!, binding.password!!)
            }
        }

        registerViewModel.loginLiveData.observe(this, { registerResponse ->
            registerResponse.key?.let { key ->
                binding.progress.hide()

                Toast.makeText(this, "Operação bem sucedida!", Toast.LENGTH_LONG).show()

                binding.email?.let {
                    preferenceHelper.setEmail(it)
                }
                preferenceHelper.setApiKey(key)

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(MainActivity.KEY, key)
                startActivity(intent)
            }

            registerResponse?.hasError?.also {
                if (it) {
                    binding.progress.hide()
                    Toast.makeText(baseContext, registerResponse.error, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}