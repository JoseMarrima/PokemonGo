package com.example.pokemongo.data.remote

import com.example.pokemongo.model.TokenResponse
import com.example.pokemongo.model.captured.CapturedResponse
import com.example.pokemongo.model.community.CommunityResponse
import com.example.pokemongo.model.myteam.MyTeamResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface PokemonService {

    @GET("activity")
    fun getCommunity(): Single<CommunityResponse>

    @GET("my-team")
    fun getMyTeam(): Single<MyTeamResponse>

    @GET("captured")
    fun getCaptured(): Single<CapturedResponse>
}