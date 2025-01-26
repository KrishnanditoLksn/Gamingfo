package app.ditsdev.core.domain.usecase

import app.ditsdev.core.domain.model.Publisher
import app.ditsdev.core.result.resource.ResourceResult
import io.reactivex.rxjava3.core.Flowable

interface PublisherUseCase {
    fun displayAllPublishers(): Flowable<ResourceResult<List<Publisher>>>
}