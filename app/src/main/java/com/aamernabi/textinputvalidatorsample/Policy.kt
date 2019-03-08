package com.aamernabi.textinputvalidatorsample

class PasswordValidator {
    companion object {
        private val regx1 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[_@#$%^&+=])(?=\\S+$).{8,32}$".toRegex()
        private val regx2 = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[_@#$%^&+=])(?=\\S+$).{8,32}$".toRegex()
        private val regx3 = "^(?=.*[0-9])(?=.*[a-z])(?=.*[_@#$%^&+=])(?=\\S+$).{8,32}$".toRegex()
        private val regx4 = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,32}$".toRegex()

        fun validate(password: String) = password.matches(regx1) || password.matches(regx2)
                || password.matches(regx3) || password.matches(regx4)
    }
}