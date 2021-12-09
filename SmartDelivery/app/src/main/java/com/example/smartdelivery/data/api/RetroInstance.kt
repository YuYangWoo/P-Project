package com.example.smartdelivery.data.api

object RetroInstance {
    val baseUrl = "http://info.sweettracker.co.kr"
    val client = BaseRetrofit.getClient(baseUrl).create(RetroService::class.java)
    val baseServerUrl = "http://52.79.239.78"
    val serverClient = BaseRetrofit.getClient(baseServerUrl).create(RetroService::class.java)
}