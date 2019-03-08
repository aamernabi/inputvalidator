package com.aamernabi.inputvalidator

import android.widget.EditText

val notEmpty: String.() -> Boolean = { isNotEmpty() }
fun ofLength(length: Int): String.() -> Boolean = { this.length == length  }
fun ofLength(min: Int, max: Int): String.() -> Boolean = { this.length in min..max }

inline fun EditText.validate(block: String.() -> Boolean): Boolean {
    val text = text?.toString() ?: ""
    return block(text)
}

fun test(e: EditText) {
    val isNotEmpty = e.validate(notEmpty)
    val hasValidLen = e.validate(ofLength(6))
    val hasDigits = e.validate { contains("\\d".toRegex()) }
}