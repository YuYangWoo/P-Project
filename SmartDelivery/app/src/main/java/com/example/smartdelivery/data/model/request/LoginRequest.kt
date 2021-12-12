package com.example.smartdelivery.data.model.request

import java.io.Serializable

data class LoginRequest(
    var id: String,
    var password: String,
    var deviceToken: String ?= null
): Serializable {
    constructor(): this("","")
}