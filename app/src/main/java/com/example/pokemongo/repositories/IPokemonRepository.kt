package com.example.pokemongo.repositories

import com.example.pokemongo.model.myteam.MyTeamResponse
import io.reactivex.rxjava3.core.Single

interface IPokemonRepository {
    fun getTeams(): Single<MyTeamResponse>
}