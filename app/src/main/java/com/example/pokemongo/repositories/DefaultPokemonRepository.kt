package com.example.pokemongo.repositories

import com.example.pokemongo.data.remote.PokemonService
import com.example.pokemongo.model.myteam.MyTeamResponse
import io.reactivex.Single

class DefaultPokemonRepository(/**private val dao: PokemonDao,**/ private val service: PokemonService): IPokemonRepository {

    override fun getTeams() : Single<MyTeamResponse> {
        return service.getMyTeam()
    }
}