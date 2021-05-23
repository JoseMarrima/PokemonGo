package com.example.pokemongo.util

import android.content.Context
import android.content.SharedPreferences
import com.example.pokemongo.data.remote.TokenService


class TokenProvider(private val context: Context,
                    private val service: TokenService): AccessTokenProvider {

    override fun token(): String? {
        val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getString(TOKEN_KEY, "")
    }

    override fun refreshToken(): String? {
        val token = service.requestToken().execute().body()?.token
        val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(TOKEN_KEY, token)
        editor.apply()
        return token
    }
}