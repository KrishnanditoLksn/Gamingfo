package app.ditsdev.gamingfo.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import app.ditsdev.core.utils.KeyExtras
import app.ditsdev.gamingfo.databinding.ActivityDetailGameBinding
import coil3.load

class DetailGameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameName = intent.getStringExtra(KeyExtras.EXTRA_NAME)
        val rating = intent.getStringExtra(KeyExtras.EXTRA_RATING)
        val image = intent.getStringExtra(KeyExtras.EXTRA_IMAGE)
        val released = intent.getStringExtra(KeyExtras.EXTRA_RELEASED)
        binding.tvDetailGameName.text = gameName
        binding.tvDetailRatingGame.rating = rating!!.toFloat()
        binding.ivDetailGame.load(image)
        binding.tvDetailReleaseDate.text = released!!.toString()

        binding.btnBack.setOnClickListener {
            backPressed()
        }
    }

    private fun backPressed() {
        onBackPressedDispatcher.onBackPressed()
    }
}