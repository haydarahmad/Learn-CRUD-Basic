package com.haydar.crudbasic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.haydar.crudbasic.repository.SubscriberRepository
import java.lang.IllegalArgumentException

class SubscriberViewModelFactory(private val repository: SubscriberRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubscriberViewModel::class.java)){
            return SubscriberViewModel(repository) as T
        } else{
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}