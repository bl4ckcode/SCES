package com.bl4ckcode.sces.util

import android.text.Editable

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

fun Double.toCurrencyString(): String = String.format("R$ %.2f", this)
