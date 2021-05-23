package com.example.pokemongo.ui.myteam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemongo.model.myteam.MyTeamResponse
import com.example.pokemongo.repositories.IPokemonRepository
import com.example.pokemongo.util.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MyTeamViewModel(private val repository: IPokemonRepository) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val _myTeamLiveData: MutableLiveData<Resource<MyTeamResponse>> = MutableLiveData()
    val myTeamLiveData: LiveData<Resource<MyTeamResponse>>
        get() = _myTeamLiveData
    init {
        getMyTeam()
    }

    private fun getMyTeam() {
        disposables.add(
            repository.getTeams()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { _myTeamLiveData.value = Resource.loading(null) }
                .subscribe(
                    {team -> _myTeamLiveData.value = Resource.success(team) },
                    { throwable -> _myTeamLiveData.value = Resource.error(throwable.message!!) })
        )
    }

}