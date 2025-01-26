package app.ditsdev.core.domain.interactor

import app.ditsdev.core.domain.model.Publisher
import app.ditsdev.core.domain.repository.publisher.ImplPublisherRepository
import app.ditsdev.core.domain.usecase.PublisherUseCase
import app.ditsdev.core.result.resource.ResourceResult
import io.reactivex.rxjava3.core.Flowable

class PublisherInteractor(private val publisherRepository: ImplPublisherRepository) :
    PublisherUseCase {
    override fun displayAllPublishers(): Flowable<ResourceResult<List<Publisher>>> {
        return publisherRepository.getAllPublisher()
    }

}