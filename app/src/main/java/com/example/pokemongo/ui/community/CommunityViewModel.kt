package com.example.pokemongo.ui.community

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemongo.model.community.CommunityResponse
import com.example.pokemongo.repositories.IPokemonRepository
import com.example.pokemongo.util.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CommunityViewModel(private val repository: IPokemonRepository) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val _communityLiveData: MutableLiveData<Resource<CommunityResponse>> = MutableLiveData()
    val communityLiveData: LiveData<Resource<CommunityResponse>>
        get() = _communityLiveData
    init {
        getMyTeam()
    }

    private fun getMyTeam() {
        disposables.add(
            repository.getCommunity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { _communityLiveData.value = Resource.loading(null) }
                .subscribe(
                    {team -> _communityLiveData.value = Resource.success(team) },
                    { throwable -> _communityLiveData.value = Resource.error(throwable.message!!) })
        )
    }
}