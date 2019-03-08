package com.aamernabi.textinputvalidatorsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.aamernabi.inputvalidator.ofLength
import com.aamernabi.inputvalidator.onTextChanged
import com.aamernabi.inputvalidator.validate
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)

        et_username.onTextChanged {
            til_username.error = null
            til_username.isErrorEnabled = false
        }

        et_password.onTextChanged {
            til_password.error = null
            til_password.isErrorEnabled = false
        }

        btn_submit.setOnClickListener {
            et_username.validate(ofLength(4), {
                til_username.error = "Invalid username. Minimum 4 characters required"
                return@setOnClickListener
            })
            et_password.validate(ofLength(8), {
                til_password.error = "Invalid password. Minimum 8 characters required"
                return@setOnClickListener
            })
            et_password.validate({ PasswordValidator.validate(this) }, {
                til_password.error = "Password must contain mixture of letter, numbers and special characters"
                return@setOnClickListener
            })

            Toast.makeText(this@LoginActivity, "Valid details", Toast.LENGTH_LONG).show()
        }
    }
}
