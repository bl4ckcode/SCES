package com.bl4ckcode.sces.util

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController

fun FragmentActivity.addFragment(container: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .add(container, fragment)
        .commitAllowingStateLoss()
}

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun <T> Fragment.getNavigationResult(key: String = "result") =
    findNavController().currentBackStackEntry?.savedStateHandle?.get<T>(key)

fun <T> Fragment.getNavigationResultLiveData(key: String = "result") =
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)

fun <T> Fragment.setNavigationResult(result: T, key: String = "result") {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
}