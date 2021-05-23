package com.example.pokemongo.ui.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemongo.databinding.ListItemCommunityBinding
import com.example.pokemongo.model.community.Foe
import com.example.pokemongo.model.community.Friend

class CommunityFriendAdapter(private val clickListener: CommunityFriendClickListener) :
    ListAdapter<Friend, RecyclerView.ViewHolder>(CommunityFriendDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommunityFriendViewHolder(
            ListItemCommunityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CommunityFriendViewHolder).bind(clickListener, getItem(position))
    }

    class CommunityFriendViewHolder(private val binding: ListItemCommunityBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: CommunityFriendClickListener, item: Friend) {
            binding.apply {
//                clickListener = listener
//                team = item
                executePendingBindings()
            }
        }
    }
}

class CommunityFriendDiffCallback: DiffUtil.ItemCallback<Friend>() {

    override fun areItemsTheSame(oldItem: Friend, newItem: Friend): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Friend, newItem: Friend): Boolean {
        return oldItem == newItem
    }

}

class CommunityFriendClickListener(val clickListener: (friend: Friend) -> Unit) {
    fun onClick(friend: Friend) = clickListener(friend)
}


class CommunityFoeAdapter(private val clickListener: CommunityFoeClickListener) :
    ListAdapter<Foe, RecyclerView.ViewHolder>(CommunityFoeDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommunityFoeViewHolder(
            ListItemCommunityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CommunityFoeViewHolder).bind(clickListener, getItem(position))
    }

    class CommunityFoeViewHolder(private val binding: ListItemCommunityBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: CommunityFoeClickListener, item: Foe) {
            binding.apply {
//                clickListener = listener
//                team = item
                executePendingBindings()
            }
        }
    }
}

class CommunityFoeDiffCallback: DiffUtil.ItemCallback<Foe>() {

    override fun areItemsTheSame(oldItem: Foe, newItem: Foe): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Foe, newItem: Foe): Boolean {
        return oldItem == newItem
    }

}

class CommunityFoeClickListener(val clickListener: (foe: Foe) -> Unit) {
    fun onClick(foe: Foe) = clickListener(foe)
}