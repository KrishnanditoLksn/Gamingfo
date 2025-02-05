package app.ditsdev.search.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.ditsdev.core.databinding.ItemGameRowBinding
import app.ditsdev.core.domain.model.Game
import coil3.load

class GameResultAdapter : ListAdapter<Game, GameResultAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.gameId == newItem.gameId
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.gameId == newItem.gameId
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemGameRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameResultAdapter.ViewHolder, position: Int) {
        val items = getItem(position)
        holder.bind(items)

    }

    inner class ViewHolder(private var binding: ItemGameRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Game) {
            binding.ivGameImage.load(data.backgroundImage)
            binding.tvGameName.text = data.gameName
            binding.tvRatingGame.rating = data.rating.toFloat()
        }
    }
}