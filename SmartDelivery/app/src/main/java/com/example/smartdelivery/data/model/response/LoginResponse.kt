package com.example.smartdelivery.data.model.response

import java.io.Serializable

data class LoginResponse(
    var isSuccess: Boolean,
    var code: String,
    var message: String,
    var result: Jwt
): Serializable {
    constructor() : this(false, "", "", Jwt())
}