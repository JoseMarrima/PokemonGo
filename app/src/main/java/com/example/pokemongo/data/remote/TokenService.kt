package com.example.pokemongo.data.remote

import com.example.pokemongo.model.TokenResponse
import retrofit2.Call
import retrofit2.http.POST

interface TokenService {
    @POST("token?email=benderspor@gmail.com")
    fun requestToken(): Call<TokenResponse>
}