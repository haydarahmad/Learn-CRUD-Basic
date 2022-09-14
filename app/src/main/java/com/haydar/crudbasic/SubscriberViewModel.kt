package com.haydar.crudbasic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haydar.crudbasic.db.Subscriber
import com.haydar.crudbasic.repository.SubscriberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    //cause we uso live data we dont need
    val subscribers = repository.subscriber

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate(){
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Subscriber(0,name,email))
        inputName.value = ""
        inputEmail.value = ""
    }

    fun clearAllOrDelete(){
        clearAll()
    }

    fun insert(subscriber: Subscriber){
       viewModelScope.launch (Dispatchers.IO){
           repository.inaert(subscriber)
       }
    }

    fun delete(subscriber: Subscriber){
        viewModelScope.launch (Dispatchers.IO){
            repository.delete(subscriber)
        }
    }

    fun update(subscriber: Subscriber){
        viewModelScope.launch (Dispatchers.IO){
            repository.update(subscriber)
        }
    }

    fun clearAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

}