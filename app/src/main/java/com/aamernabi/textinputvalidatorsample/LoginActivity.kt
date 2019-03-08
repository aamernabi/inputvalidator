package com.aamernabi.textinputvalidatorsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.aamernabi.inputvalidator.ofLength
import com.aamernabi.inputvalidator.validate
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)

        btn_submit.setOnClickListener {
            val isValidUsername = et_username.validate(ofLength(4))
            val isValidPassword = et_password.validate(ofLength(8)) && et_password.validate {
                PasswordValidator.validate(this)
            }

            if (!isValidUsername) {
                til_username.error = "Invalid username. Minimum 4 characters required"
                return@setOnClickListener
            } else if (!isValidPassword) {
                til_password.error = "Password must contain mixture of letter, numbers and special characters"
                return@setOnClickListener
            }

            Toast.makeText(this@LoginActivity, "Valid details", Toast.LENGTH_LONG).show()
        }
    }
}
