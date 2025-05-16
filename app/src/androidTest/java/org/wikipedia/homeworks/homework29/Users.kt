package org.wikipedia.homeworks.homework29

import org.wikipedia.BuildConfig

object Users {
    val alfaLogin = "alfaLogin"
    val bettaLogin = "bettaLogin"
}

object Credentials {
    private val map = mapOf(
        Users.alfaLogin to BuildConfig.alfaLogin,
        Users.bettaLogin to BuildConfig.bettaLogin
    )
    fun getPassword(user: String) : String{
        return map.getOrElse(user){
            throw IllegalArgumentException("$user пользователя нет")
        }
    }
}