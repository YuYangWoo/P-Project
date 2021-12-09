package com.example.smartdelivery.data.repository

import com.example.smartdelivery.data.api.RetroInstance
import com.example.smartdelivery.data.model.request.LoginRequest

class RemoteRepository {
    suspend fun requestTracking(t_code: String, t_invoice: String) = RetroInstance.client.getTrackingInfo(t_code, t_invoice)
    suspend fun requestCompany() = RetroInstance.client.requestCompanyList()
    suspend fun requestLogin(loginRequest: LoginRequest) = RetroInstance.serverClient.requestLogin(loginRequest)
}