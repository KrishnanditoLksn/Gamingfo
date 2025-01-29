package app.ditsdev.gamingfo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.ditsdev.core.domain.model.Publisher
import app.ditsdev.gamingfo.databinding.ItemPublisherRowBinding
import coil3.load

class PublisherListAdapter :
    ListAdapter<Publisher, PublisherListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemPublisherRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = getItem(position)
        holder.bind(items)
    }


    inner class ViewHolder(private var binding: ItemPublisherRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Publisher) {
            binding.ivPublisher.load(data.imageBackground)
            binding.tvPublisherName.text = data.name
            binding.tvGamesCount.text = data.gamesCount.toString()
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Publisher>() {
            override fun areItemsTheSame(oldItem: Publisher, newItem: Publisher): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Publisher, newItem: Publisher): Boolean {
                return oldItem == newItem
            }
        }
    }
}
