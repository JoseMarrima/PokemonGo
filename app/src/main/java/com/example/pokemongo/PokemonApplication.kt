package com.example.pokemongo

import android.app.Application
import com.example.pokemongo.repositories.IPokemonRepository

class PokemonApplication: Application() {
    val repository: IPokemonRepository
        get() = ServiceLocator.provideTasksRepository(this)
}