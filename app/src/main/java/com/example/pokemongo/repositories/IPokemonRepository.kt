package com.example.pokemongo.repositories

import com.example.pokemongo.model.captured.CapturedResponse
import com.example.pokemongo.model.community.CommunityResponse
import com.example.pokemongo.model.myteam.MyTeamResponse
import io.reactivex.rxjava3.core.Single

interface IPokemonRepository {
    fun getTeams(): Single<MyTeamResponse>
    fun getCommunity(): Single<CommunityResponse>
    fun getCaptured(): Single<CapturedResponse>
}