package app.ditsdev.core

import app.ditsdev.core.data.result.resource.ResourceResult
import app.ditsdev.core.domain.interactor.PublisherInteractor
import app.ditsdev.core.domain.model.Publisher
import app.ditsdev.core.domain.repository.publisher.ImplPublisherRepository
import app.ditsdev.core.domain.usecase.PublisherUseCase
import app.ditsdev.core.utils.DummyData
import io.reactivex.rxjava3.core.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class GetDataUseCasePublisherTest {
    private lateinit var publisherUseCase: PublisherUseCase

    @Mock
    private lateinit var publisherRepository: ImplPublisherRepository

    @Before
    fun setup() {
        publisherUseCase = PublisherInteractor(
            publisherRepository
        )

        val dummyPublisher = DummyData.generateDummyPublisher()
        val flowablePublisher: Flowable<ResourceResult<List<Publisher>>> =
            Flowable.just(ResourceResult.Success(dummyPublisher))

        `when`(publisherRepository.getAllPublisher()).thenReturn(flowablePublisher)
    }

    @Test
    fun `should get publisher data from repo`() {
        val testObserver = publisherUseCase.displayAllPublishers().test()

        testObserver.assertValue { res ->
            when (res) {
                is ResourceResult.Success -> {
                    val publisher = res.data
                    publisher?.size == 1 &&
                            publisher[0].name == "Square Enix" &&
                            publisher[0].idPublisher == 308
                }

                else -> {
                    false
                }
            }
        }
    }
}