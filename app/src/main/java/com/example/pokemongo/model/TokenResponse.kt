package com.example.pokemongo.model


import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("expiresAt")
    val expiresAt: Long?,
    @SerializedName("token")
    val token: String?
)