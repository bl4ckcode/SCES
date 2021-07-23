package com.bl4ckcode.sces

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bl4ckcode.sces.databinding.ActivityMainBinding
import com.bl4ckcode.sces.util.sharedpreferences.IPreferenceHelper
import com.bl4ckcode.sces.util.sharedpreferences.PreferenceManager


class MainActivity : AppCompatActivity() {

    companion object {
        const val LOGIN = "LOGIN"
        const val KEY = "KEY"
    }

    private val preferenceHelper: IPreferenceHelper by lazy { PreferenceManager(applicationContext) }

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.client()

        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        val navController = navHost!!.navController

        val navInflater = navController.navInflater
        val graph = navInflater.inflate(R.navigation.nav_graph_main)

        if (intent.getBooleanExtra(LOGIN, false)) {
            intent.getStringExtra(KEY)?.also {
                graph.startDestination = R.id.fragment_products
            }
        } else {
            intent.getStringExtra(KEY)?.also {
                graph.startDestination = R.id.fragment_profile
            } ?: run { graph.startDestination = R.id.fragment_products }
        }

        navController.graph = graph

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragment_products,
                R.id.fragment_orders,
                R.id.fragment_categories,
                R.id.fragment_order_items,
                R.id.fragment_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupNav(navController)

        mainViewModel.clientLiveData.observe(this, { clientUiModel ->
            clientUiModel?.cliente?.let {
                preferenceHelper.setClientId(it.id.toString())
            }

            clientUiModel?.hasError?.also {
                if (it) {
                    Toast.makeText(this, clientUiModel.error, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupNav(navController: NavController) {
        binding.navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragment_products, R.id.fragment_orders, R.id.fragment_categories,
                R.id.fragment_order_items, R.id.fragment_profile -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    fun showBottomNav() {
        binding.navView.visibility = View.VISIBLE
    }

    fun hideBottomNav() {
        binding.navView.visibility = View.GONE
    }
}