package app.ditsdev.core.utils

import app.ditsdev.core.domain.model.Game
import app.ditsdev.core.domain.model.Publisher

object DummyData {
    fun generateDummyGame(): List<Game> {
        return listOf(
            Game(
                gameId = 1,
                gameName = "Gta",
                rating = "3.1",
                backgroundImage = "a.png",
                released = "30-01-2024",
                isFavorite = false
            )
        )
    }

    fun generateDummyPublisher(): List<Publisher> {
        return listOf(
            Publisher(
                idPublisher = 308,
                name = "Square Enix",
                imageBackground = "https://media.rawg.io/media/games/54a/54a3e4c617217848dc43c4de9989fe37.jpg",
                gamesCount = 600,
            )
        )
    }
}