package com.example.smartdelivery.data.model.response
import java.io.Serializable

class SignupResponse (
    var isSuccess: Boolean,
    var code: String,
    var message: String,
    var result: Jwt
    ): Serializable {
        constructor() : this(false, "", "", Jwt())
}



