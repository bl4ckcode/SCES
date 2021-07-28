package com.bl4ckcode.sces.util

import java.text.DecimalFormat

fun Double.toCurrencyString(): String = String.format("R$ %.2f", this)

fun Double.toCurrency(): String {
    val formatter = DecimalFormat("R$ ###,###,##0.00")
    return formatter.format(this)
}
