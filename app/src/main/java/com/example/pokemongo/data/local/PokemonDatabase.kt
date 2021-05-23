package com.example.pokemongo.data.local

import androidx.room.RoomDatabase

abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}