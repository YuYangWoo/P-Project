package com.example.smartdelivery.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.smartdelivery.data.model.request.PackagesRequest
import com.example.smartdelivery.data.repository.RemoteRepository
import com.example.smartdelivery.util.Resource
import java.lang.Exception

class PackagesViewModel (private val remoteRepository: RemoteRepository): ViewModel(){
    fun PackagesApiCall(packagesRequest: PackagesRequest)= liveData {
        emit(Resource.loading(null))
        try{
            emit(Resource.success(remoteRepository.requestPackages(packagesRequest)))
        }catch (e:Exception){
            emit(Resource.error(null,e.message ?:"error"))
        }
    }

}




