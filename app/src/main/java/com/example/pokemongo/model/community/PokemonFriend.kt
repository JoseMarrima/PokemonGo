package com.example.pokemongo.model.community


import com.google.gson.annotations.SerializedName

data class PokemonFriend(
    @SerializedName("captured_at")
    val capturedAt: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)