package com.example.smartdelivery.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.smartdelivery.data.room.TrackingData
import com.example.smartdelivery.data.repository.LocalRespository
import kotlinx.coroutines.launch

class AddViewModel(private val localRespository: LocalRespository) : ViewModel(){
     var trackingList: LiveData<List<TrackingData>> = localRespository.trackingList.asLiveData()

    fun insert(trackingData: TrackingData) = viewModelScope.launch {
        localRespository.insert(trackingData)
    }
}