package app.ditsdev.core.utils

import app.ditsdev.core.domain.model.Game

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
}