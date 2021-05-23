package com.example.pokemongo.model.community


import com.google.gson.annotations.SerializedName

data class Friend(
    @SerializedName("name")
    val name: String?,
    @SerializedName("pokemon")
    val pokemon: PokemonFriend?
)