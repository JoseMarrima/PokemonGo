package com.example.pokemongo.ui.myteam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokemongo.PokemonApplication
import com.example.pokemongo.R
import com.example.pokemongo.databinding.MyTeamFragmentBinding
import com.example.pokemongo.util.Resource

class MyTeamFragment : Fragment() {

    private val viewModel: MyTeamViewModel by viewModels {
        MyTeamViewModelFactory((requireContext().applicationContext as PokemonApplication).repository)
    }

    private val adapter = MyTeamAdapter(MyTeamClickListener {

    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: MyTeamFragmentBinding = DataBindingUtil
            .inflate(inflater, R.layout.my_team_fragment, container, false)

        binding.lifecycleOwner = this

        binding.myTeamRecyclerView.adapter = adapter

        viewModel.myTeamLiveData.observe(viewLifecycleOwner, {
            when(it.status) {
                Resource.Status.SUCCESS -> { adapter.submitList(it.data?.toList()) }
                Resource.Status.ERROR -> {}
                Resource.Status.LOADING -> {}
            }
        })

        return binding.root
    }
}