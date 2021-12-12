package com.example.smartdelivery.data.api

import com.example.smartdelivery.data.model.request.LoginRequest
import com.example.smartdelivery.data.model.request.SignupRequest
import com.example.smartdelivery.data.model.response.CompanyList
import com.example.smartdelivery.data.model.response.LoginResponse
import com.example.smartdelivery.data.model.response.SignupResponse
import com.example.smartdelivery.data.model.response.TrackingResponse
import com.example.smartdelivery.BuildConfig
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

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


}