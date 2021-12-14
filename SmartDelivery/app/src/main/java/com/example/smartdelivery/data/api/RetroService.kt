package com.example.smartdelivery.data.api

import com.example.smartdelivery.data.model.request.LoginRequest
import com.example.smartdelivery.data.model.request.SignupRequest
import com.example.smartdelivery.BuildConfig
import com.example.smartdelivery.data.model.request.PackagesRequest
import com.example.smartdelivery.data.model.response.*
import retrofit2.Response
import retrofit2.http.*

interface RetroService {

    @GET("/api/v1/trackingInfo?t_key=${BuildConfig.SMART_DELIVERY}")
    suspend fun getTrackingInfo(
        @Query("t_code") t_code: String,
        @Query("t_invoice") t_invoice: String
    ): Response<TrackingResponse>

    @GET("/api/v1/companylist?t_key=${BuildConfig.SMART_DELIVERY}")
    suspend fun requestCompanyList(): Response<CompanyList>

    @POST("/app/login")
    suspend fun requestLogin(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/app/signup")
    suspend fun requestSignup(@Body signupRequest: SignupRequest): Response<SignupResponse>

    @GET("/app/packages")
    suspend fun requestPackages(@Header("x-access-token") jwt: String): Response<PackagesResponse>

}