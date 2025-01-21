package app.ditsdev.gamingfo.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.ditsdev.core.domain.model.Game
import app.ditsdev.gamingfo.databinding.ItemGameRowBinding
import app.ditsdev.gamingfo.ui.detail.DetailGameActivity
import coil3.load

class GameListAdapter : ListAdapter<Game, GameListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemGameRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameListAdapter.ViewHolder, position: Int) {
        val items = getItem(position)
        holder.bind(items)

    }

    inner class ViewHolder(private var binding: ItemGameRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Game) {
            binding.ivGameImage.load(data.backgroundImage)
            binding.tvGameName.text = data.gameName
            binding.tvRatingGame.rating = data.rating.toFloat()

            binding.clItem.setOnClickListener {
                val context = binding.root.context
                val intent = Intent(context, DetailGameActivity::class.java)
                intent.putExtra(EXTRA_DATAS, data)
                context.startActivity(intent)
            }
        }
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Game>() {
            override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
                return oldItem.gameId == newItem.gameId
            }

            override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
                return oldItem.gameId == newItem.gameId
            }

        }

        const val EXTRA_DATAS = "extra_datas"
    }
}