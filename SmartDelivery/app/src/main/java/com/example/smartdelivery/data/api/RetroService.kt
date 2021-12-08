package com.example.smartdelivery.data.api

import com.example.smartdelivery.BuildConfig
import com.example.smartdelivery.data.model.response.TrackingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroService {

@GET("api/v1/trackingInfo?t_key=${BuildConfig.SMART_DELIVERY}")
suspend fun getTrackingInfo(
    @Query("t_code") t_code: String,
    @Query("t_invoice") t_invoice: String
): Response<TrackingResponse>

}