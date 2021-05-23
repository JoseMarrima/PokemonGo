package com.example.pokemongo.model.community


import com.google.gson.annotations.SerializedName

data class CommunityResponse(
    @SerializedName("foes")
    val foes: List<Foe>?,
    @SerializedName("friends")
    val friends: List<Friend>?
)