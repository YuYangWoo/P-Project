package com.example.smartdelivery.data.repository

import com.example.smartdelivery.data.api.RetroInstance
import com.example.smartdelivery.data.model.request.LoginRequest
import com.example.smartdelivery.data.model.request.PackagesRequest
import com.example.smartdelivery.data.model.request.SignupRequest

class RemoteRepository {
    suspend fun requestTracking(t_code: String, t_invoice: String) = RetroInstance.client.getTrackingInfo(t_code, t_invoice)
    suspend fun requestCompany() = RetroInstance.client.requestCompanyList()
    suspend fun requestLogin(loginRequest: LoginRequest) = RetroInstance.serverClient.requestLogin(loginRequest)
    suspend fun requestSignup(signupRequest: SignupRequest) = RetroInstance.serverClient.requestSignup(signupRequest)
    suspend fun requestPackages(jwt: String) = RetroInstance.serverClient.requestPackages(jwt)
    suspend fun requestPackageDetail(idx: Int,jwt: String) = RetroInstance.serverClient.requestPackageDetail(jwt, idx)
    suspend fun requestLoss(jwt: String) = RetroInstance.serverClient.requestLoss(jwt)
}