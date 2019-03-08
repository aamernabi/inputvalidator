package com.aamernabi.inputvalidator

import android.support.design.widget.TextInputLayout
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

val notEmpty: String.() -> Boolean = { isNotEmpty() }
fun ofLength(length: Int): String.() -> Boolean = { this.length >= length  }
fun ofLength(min: Int, max: Int): String.() -> Boolean = { this.length in min..max }

inline fun EditText.validate(block: String.() -> Boolean): Boolean {
    val text = text?.toString() ?: ""
    return block(text)
}

inline fun EditText.validate(validator: String.() -> Boolean, block: () -> Unit): Boolean {
    val text = text?.toString() ?: ""
    val isValid = validator(text)

    if (!isValid) {
        block()
    }

    return isValid
}

fun EditText.onTextChanged(block: () -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            block()
        }
    })
}

fun test(e: EditText, til: TextInputLayout) {
    val isNotEmpty = e.validate(notEmpty)
    val hasValidLen = e.validate(ofLength(6))
    val hasDigits = e.validate { contains("\\d".toRegex()) }

    val hasCaps = e.validate({ contains("A-Z".toRegex())}, {
        til.error = "Must contain Caps characters"
    })
}