package app.ditsdev.gamingfo.ui.detail

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import app.ditsdev.core.domain.model.Game
import app.ditsdev.gamingfo.R
import app.ditsdev.gamingfo.databinding.ActivityDetailGameBinding
import app.ditsdev.gamingfo.ui.GameListAdapter
import coil3.load
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailGameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailGameBinding
    private val detailVm: DetailGameViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameName = intent.getParcelableExtra(GameListAdapter.EXTRA_DATAS, Game::class.java)
        var isFavorite = gameName!!.isFavorite
        binding.tvDetailGameName.text = gameName.gameName
        binding.tvDetailRatingGame.rating = gameName.rating.toFloat()
        binding.ivDetailGame.load(gameName.backgroundImage)
        binding.tvDetailReleaseDate.text = gameName.released

        binding.btnBack.setOnClickListener {
            backPressed()
        }
        setFavoriteStatus(isFavorite)
        binding.fabFavorite.setOnClickListener {
            isFavorite = !isFavorite
            detailVm.setFavoriteGames(gameName, isFavorite)
            setFavoriteStatus(isFavorite)
        }
    }

    private fun backPressed() {
        onBackPressedDispatcher.onBackPressed()
    }

    private fun setFavoriteStatus(isFavorite: Boolean) {
        if (isFavorite) {
            binding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.baseline_bookmark_24
                )
            )
        } else {
            binding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.baseline_bookmark_border_24
                )
            )
        }
    }
}