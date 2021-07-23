package com.bl4ckcode.sces.ui.products.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.bl4ckcode.sces.R
import com.bl4ckcode.sces.databinding.ActivityDetailProductBinding

class DetailProductActivity : AppCompatActivity() {

    companion object {
        const val UPDATE = "UPDATE"
    }

    private lateinit var binding: ActivityDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        val navController = navHost!!.navController

        val navInflater = navController.navInflater
        val graph = navInflater.inflate(R.navigation.nav_graph_detail_product)

        navController.graph = graph

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.fragment_detail_product))
        setupActionBarWithNavController(navController, appBarConfiguration)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
}