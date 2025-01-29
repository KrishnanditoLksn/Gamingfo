package app.ditsdev.core.domain.repository.publisher

import app.ditsdev.core.domain.model.Publisher
import app.ditsdev.core.data.result.resource.ResourceResult
import io.reactivex.rxjava3.core.Flowable

interface ImplPublisherRepository {
    fun getAllPublisher(): Flowable<ResourceResult<List<Publisher>>>
}