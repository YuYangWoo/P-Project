package com.example.smartdelivery.ui.main.viewmodel

import androidx.lifecycle.*
import com.example.smartdelivery.data.repository.LocalRepository
import com.example.smartdelivery.data.repository.RemoteRepository
import com.example.smartdelivery.data.room.TrackingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(private val localRepository: LocalRepository) : ViewModel() {

    val allList: LiveData<List<TrackingData>> = localRepository.allList.asLiveData()
    fun insertData(trackingData: TrackingData) = viewModelScope.launch(Dispatchers.IO) {
            localRepository.insertData(trackingData)
        }


}