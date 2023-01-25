package com.mlk.stupass.models

class UserModel(
    private val name: String,
    private val email: String,
    private val phone: String,
    private val password: String
) {

    fun validName(name: String): Boolean {
        return when{
            else -> true
        }
    }
    fun validEmail(email: String): Boolean {
        return when{
            else -> true
        }
    }
    fun validPhone(phone: String): Boolean {
        return when{
            else -> true
        }
    }
    fun validPassword(password: String): Boolean {
        return when{
            else -> true
        }
    }
}