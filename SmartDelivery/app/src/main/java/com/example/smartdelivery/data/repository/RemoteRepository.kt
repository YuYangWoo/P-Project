package com.example.smartdelivery.data.repository

import com.example.smartdelivery.data.api.RetroInstance

class RemoteRepository {
    suspend fun requestTracking(t_code: String, t_invoice: String) = RetroInstance.client.getTrackingInfo(t_code, t_invoice)
}