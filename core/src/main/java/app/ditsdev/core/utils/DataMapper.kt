package app.ditsdev.core.utils

import app.ditsdev.core.domain.model.Game
import app.ditsdev.core.domain.model.Publisher
import app.ditsdev.core.local.entity.GameEntity
import app.ditsdev.core.local.entity.PublisherEntity

object DataMapper {
    /*
    Entities to Domain
     */
    fun mapGameEntitiesToDomain(input: List<GameEntity>): List<Game> {
        return input.map {
            Game(
                gameId = it.gameId,
                gameName = it.gameName,
                rating = it.rating,
                backgroundImage = it.backgroundImage,
                released = it.released,
                isFavorite = it.isFavorite
            )
        }
    }

    fun mapPublisherEntitiesToDomain(publisher: List<PublisherEntity>): List<Publisher> {
        return publisher.map {
            Publisher(
                idPublisher = it.idPublisher,
                name = it.name,
                imageBackground = it.imageBackground,
                gamesCount = it.gamesCount
            )
        }
    }

    /*
    Domain to Entities
     */

    fun mapGameDomainToEntities(gameDomain: List<Game>): List<GameEntity> {
        return gameDomain.map {
            GameEntity(
                gameId = it.gameId,
                gameName = it.gameName,
                rating = it.rating,
                backgroundImage = it.backgroundImage,
                released = it.released
            )
        }
    }

    fun mapPublisherDomainToEntities(publisherDomain: List<Publisher>): List<PublisherEntity> {
        return publisherDomain.map {
            PublisherEntity(
                idPublisher = it.idPublisher,
                name = it.name,
                imageBackground = it.imageBackground,
                gamesCount = it.gamesCount
            )
        }
    }
}