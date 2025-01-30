package app.ditsdev.favorite.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.ditsdev.core.domain.model.Game
import app.ditsdev.favorite.databinding.FavoriteItemRowBinding
import app.ditsdev.gamingfo.ui.detail.DetailGameActivity
import coil3.load

class GameFavoriteAdapter : ListAdapter<Game, GameFavoriteAdapter.ViewHolder>(
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
        val view =
            FavoriteItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameFavoriteAdapter.ViewHolder, position: Int) {
        val items = getItem(position)
        holder.bind(items)

    }

    inner class ViewHolder(private var binding: FavoriteItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Game) {
            with(binding) {
                ivFavoriteGameImage.load(data.backgroundImage)
                tvFavGameName.text = data.gameName
                tvFavoriteRatingGame.text = data.rating
                cliFavItem.setOnClickListener {
                    val context = binding.root.context
                    val intent = Intent(context, DetailGameActivity::class.java)
                    intent.putExtra(EXTRA_DATAS, data)
                    context.startActivity(intent)
                }
            }
        }
    }

    companion object {
        const val EXTRA_DATAS = "extra_datas"
    }
}