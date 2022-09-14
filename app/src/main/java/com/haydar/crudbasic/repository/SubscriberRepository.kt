package com.haydar.crudbasic.repository

import com.haydar.crudbasic.db.Subscriber
import com.haydar.crudbasic.db.SubscriberDAO

class SubscriberRepository(private val dao: SubscriberDAO) {

    val subscriber = dao.getAllSubscriber()

    suspend fun inaert(subscriber: Subscriber){
        dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber){
        dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber){
        dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}