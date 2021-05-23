package com.example.pokemongo.ui.myteam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemongo.databinding.ListItemMyTeamBinding
import com.example.pokemongo.model.myteam.MyTeam

class MyTeamAdapter(private val clickListener: MyTeamClickListener) :
ListAdapter<MyTeam, RecyclerView.ViewHolder>(MyTeamDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyTeamViewHolder(
            ListItemMyTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyTeamViewHolder).bind(clickListener, getItem(position))
    }

    class MyTeamViewHolder(private val binding: ListItemMyTeamBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: MyTeamClickListener, item: MyTeam) {
            binding.apply {
                clickListener = listener
                team = item
                executePendingBindings()
            }
        }
    }

}

class MyTeamDiffCallback: DiffUtil.ItemCallback<MyTeam>() {
    override fun areItemsTheSame(oldItem: MyTeam, newItem: MyTeam): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MyTeam, newItem: MyTeam): Boolean {
        return oldItem == newItem
    }

}

class MyTeamClickListener(val clickListener: (myTeam: MyTeam) -> Unit) {
    fun onClick(myTeam: MyTeam) = clickListener(myTeam)
}

