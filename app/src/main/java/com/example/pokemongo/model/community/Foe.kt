package com.example.pokemongo.model.community


import com.google.gson.annotations.SerializedName

data class Foe(
    @SerializedName("name")
    val name: String?,
    @SerializedName("pokemon")
    val pokemon: PokemonFoe?
)