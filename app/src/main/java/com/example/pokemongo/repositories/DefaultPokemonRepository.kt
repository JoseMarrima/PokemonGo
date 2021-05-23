package com.example.pokemongo.repositories

import com.example.pokemongo.data.remote.PokemonService
import com.example.pokemongo.model.captured.CapturedResponse
import com.example.pokemongo.model.community.CommunityResponse
import com.example.pokemongo.model.myteam.MyTeamResponse
import io.reactivex.rxjava3.core.Single

class DefaultPokemonRepository(/**private val dao: PokemonDao,**/ private val service: PokemonService): IPokemonRepository {

    override fun getTeams() : Single<MyTeamResponse> {
        return service.getMyTeam()
    }

    override fun getCommunity(): Single<CommunityResponse> {
        return service.getCommunity()
    }

    override fun getCaptured(): Single<CapturedResponse> {
        return service.getCaptured()
    }
}