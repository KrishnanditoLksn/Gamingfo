package app.ditsdev.core.data.source.local

import app.ditsdev.core.data.source.local.dao.PublisherDao
import app.ditsdev.core.data.source.local.entity.PublisherEntity
import io.reactivex.rxjava3.core.Flowable

class LocalPublisherDataSource(private val publisherDao: PublisherDao) {
    fun insertPublisher(publisher: List<PublisherEntity>) =
        publisherDao.insertPublishers(publisher)

    fun displayPublisher(): Flowable<List<PublisherEntity>> = publisherDao.displayAllPublishers()

}