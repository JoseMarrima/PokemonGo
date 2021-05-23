package com.example.pokemongo.ui.myteam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemongo.repositories.IPokemonRepository

@Suppress("UNCHECKED_CAST")
class MyTeamViewModelFactory(private val repository: IPokemonRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyTeamViewModel::class.java)) {
            return MyTeamViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
