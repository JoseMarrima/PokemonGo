package com.example.pokemongo.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokemongo.PokemonApplication
import com.example.pokemongo.R
import com.example.pokemongo.databinding.CommunityFragmentBinding
import com.example.pokemongo.util.Resource

class CommunityFragment : Fragment() {

    private val viewModel: CommunityViewModel by viewModels {
        CommunityViewModelFactory((requireContext().applicationContext as PokemonApplication).repository)
    }

    private val foeAdapter = CommunityFoeAdapter(CommunityFoeClickListener {

    })

    private val friendAdapter = CommunityFriendAdapter(CommunityFriendClickListener {

    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: CommunityFragmentBinding = DataBindingUtil
            .inflate(inflater, R.layout.community_fragment, container, false)

        binding.lifecycleOwner = this

        binding.foesRecyclerView.adapter = foeAdapter
        binding.friendsRecyclerView.adapter = friendAdapter

        viewModel.communityLiveData.observe(viewLifecycleOwner, {
            when(it.status) {
                Resource.Status.SUCCESS -> {
                    foeAdapter.submitList(it.data?.foes)
                    friendAdapter.submitList(it.data?.friends)
                }
                Resource.Status.ERROR -> {}
                Resource.Status.LOADING -> {}
            }
        })

        return binding.root
    }
}