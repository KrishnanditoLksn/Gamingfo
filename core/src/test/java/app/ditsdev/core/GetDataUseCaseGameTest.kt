package app.ditsdev.core

import app.ditsdev.core.data.result.resource.ResourceResult
import app.ditsdev.core.domain.interactor.GameInteractor
import app.ditsdev.core.domain.model.Game
import app.ditsdev.core.domain.repository.game.ImplGameRepository
import app.ditsdev.core.domain.usecase.GameUseCase
import io.reactivex.rxjava3.core.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner.Silent::class)
class GetDataUseCaseGameTest {
    private lateinit var gameUseCase: GameUseCase

    @Mock
    private lateinit var gameRepository: ImplGameRepository

    @Before
    fun setup() {
        gameUseCase = GameInteractor(
            gameRepository
        )
        val dummyGame = listOf(
            Game(
                gameId = 1,
                gameName = "Gta",
                rating = "3.1",
                backgroundImage = "a.png",
                released = "30-01-2024",
                isFavorite = false
            )
        )
        val flowableGames: Flowable<ResourceResult<List<Game>>> =
            Flowable.just(ResourceResult.Success(dummyGame))
        `when`(gameRepository.getAllGames()).thenReturn(flowableGames)
    }

    @Test
    fun `should get data from repository`() {
        val testObserver = gameUseCase.getAllGames().test()

        testObserver.assertValue { result ->
            when (result) {
                is ResourceResult.Success -> {
                    val game = result.data
                    game?.size == 1 &&
                            game[0].gameName == "Gta" &&
                            game[0].gameId == 1
                }

                else -> {
                    false
                }
            }
        }
    }
}