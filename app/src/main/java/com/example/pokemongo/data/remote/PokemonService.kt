package com.example.pokemongo.data.remote

import com.example.pokemongo.model.captured.CapturedResponse
import com.example.pokemongo.model.community.CommunityResponse
import com.example.pokemongo.model.myteam.MyTeamResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PokemonService {

    @GET("activity")
    fun getCommunity(): Single<CommunityResponse>

    @GET("my-team")
    fun getMyTeam(): Single<MyTeamResponse>

    @GET("captured")
    fun getCaptured(): Single<CapturedResponse>
}