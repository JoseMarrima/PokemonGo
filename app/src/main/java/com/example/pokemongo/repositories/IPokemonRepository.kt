package com.example.pokemongo.repositories

import com.example.pokemongo.model.myteam.MyTeamResponse
import io.reactivex.Single

interface IPokemonRepository {
    fun getTeams(): Single<MyTeamResponse>
}