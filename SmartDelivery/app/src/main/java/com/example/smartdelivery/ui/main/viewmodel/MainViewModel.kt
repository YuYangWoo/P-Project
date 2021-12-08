package com.example.smartdelivery.ui.main.viewmodel

import androidx.lifecycle.*
import com.example.smartdelivery.data.model.response.CompanyList
import com.example.smartdelivery.data.model.response.TrackingResponse
//import com.example.smartdelivery.data.room.TrackingData
import com.example.smartdelivery.data.repository.RemoteRepository
import com.example.smartdelivery.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class MainViewModel(private val remoteRepository: RemoteRepository) : ViewModel() {

    private var _companyList = MutableLiveData<Resource<Response<CompanyList>>>()
    val companyList: LiveData<Resource<Response<CompanyList>>>
        get() = _companyList

    private var _invoice = MutableLiveData<Resource<Response<TrackingResponse>>>()
    val invoice: LiveData<Resource<Response<TrackingResponse>>>
        get() = _invoice

    fun requestCompanyList() {
        viewModelScope.launch(Dispatchers.IO) {
            _companyList.postValue(Resource.loading(null))
            try {
                _companyList.postValue(Resource.success(remoteRepository.requestCompany()))
            } catch (e: Exception) {
                _companyList.postValue(Resource.error(null, e.message ?: "Error"))
            }
        }
    }

    fun requestInvoice(t_code: String, t_invoice: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _invoice.postValue(Resource.loading(null))
            try {
                _invoice.postValue(Resource.success(remoteRepository.requestTracking(t_code, t_invoice)))
            } catch (e: Exception) {
                _invoice.postValue(Resource.error(null, e.message ?: "Error"))
            }
        }
    }


}