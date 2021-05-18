package com.example.pokemongo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokemongo.ui.captured.CapturedFragment
import com.example.pokemongo.ui.community.CommunityFragment
import com.example.pokemongo.ui.explore.ExploreFragment
import com.example.pokemongo.ui.myteam.MyTeamFragment

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ExploreFragment()
            1 -> CommunityFragment()
            2 -> MyTeamFragment()
            3 -> CapturedFragment()
            else -> throw IndexOutOfBoundsException()
        }
    }
}