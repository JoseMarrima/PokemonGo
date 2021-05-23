package com.example.pokemongo.model.captured


import com.google.gson.annotations.SerializedName

data class CapturedItem(
    @SerializedName("captured_at")
    val capturedAt: String?,
    @SerializedName("captured_lat_at")
    val capturedLatAt: Double?,
    @SerializedName("captured_long_at")
    val capturedLongAt: Double?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)