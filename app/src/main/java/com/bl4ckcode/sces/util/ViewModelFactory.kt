package com.bl4ckcode.sces.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bl4ckcode.sces.ui.login.LoginViewModel
import com.bl4ckcode.sces.ui.login.network.LoginRepository
import com.bl4ckcode.sces.ui.orderItems.detail.DetailOrderItemsViewModel
import com.bl4ckcode.sces.ui.orderItems.list.OrderItemsViewModel
import com.bl4ckcode.sces.ui.orderItems.network.OrderItemsRepository
import com.bl4ckcode.sces.ui.orders.detail.DetailOrderViewModel
import com.bl4ckcode.sces.ui.orders.list.OrdersViewModel
import com.bl4ckcode.sces.ui.orders.network.OrdersRepository
import com.bl4ckcode.sces.ui.products.categories.CategoriesViewModel
import com.bl4ckcode.sces.ui.products.categories.detail.DetailCategoryViewModel
import com.bl4ckcode.sces.ui.products.detail.DetailProductViewModel
import com.bl4ckcode.sces.ui.products.list.ProductViewModel
import com.bl4ckcode.sces.ui.products.network.CategoryRepository
import com.bl4ckcode.sces.ui.products.network.ProductRepository
import com.bl4ckcode.sces.ui.profile.ProfileViewModel
import com.bl4ckcode.sces.ui.profile.network.ClientRepository

class ViewModelFactory<T>(private val mApplication: Application, private val repository: T) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ProductViewModel::class.java) -> {
                ProductViewModel(mApplication, repository as ProductRepository) as T
            }
            modelClass.isAssignableFrom(DetailProductViewModel::class.java) -> {
                DetailProductViewModel(mApplication, repository as ProductRepository) as T
            }
            modelClass.isAssignableFrom(CategoriesViewModel::class.java) -> {
                CategoriesViewModel(mApplication, repository as CategoryRepository) as T
            }
            modelClass.isAssignableFrom(DetailCategoryViewModel::class.java) -> {
                DetailCategoryViewModel(mApplication, repository as CategoryRepository) as T
            }
            modelClass.isAssignableFrom(OrdersViewModel::class.java) -> {
                OrdersViewModel(mApplication, repository as OrdersRepository) as T
            }
            modelClass.isAssignableFrom(DetailOrderViewModel::class.java) -> {
                DetailOrderViewModel(mApplication, repository as OrdersRepository) as T
            }
            modelClass.isAssignableFrom(OrderItemsViewModel::class.java) -> {
                OrderItemsViewModel(mApplication, repository as OrderItemsRepository) as T
            }
            modelClass.isAssignableFrom(DetailOrderItemsViewModel::class.java) -> {
                DetailOrderItemsViewModel(mApplication, repository as OrderItemsRepository) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(mApplication, repository as ClientRepository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(mApplication, repository as LoginRepository) as T
            }
            else -> throw IllegalArgumentException()
        }
    }
}