package com.example.smartdelivery.data.api

object RetroInstance {
    val baseUrl = "http://info.sweettracker.co.kr"
    val client = BaseRetrofit.getClient(baseUrl).create(RetroService::class.java)
}