package app.ditsdev.core.remote.source.publisher

import app.ditsdev.core.local.dao.PublisherDao
import app.ditsdev.core.local.entity.PublisherEntity
import io.reactivex.rxjava3.core.Flowable

class LocalPublisherDataSource(private val publisherDao: PublisherDao) {
    fun insertPublisher(publisher: List<PublisherEntity>) =
        publisherDao.insertPublishers(publisher)

    fun displayPublisher(): Flowable<List<PublisherEntity>> = publisherDao.displayAllPublishers()

}