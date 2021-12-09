package com.example.smartdelivery.data.model.response

import java.io.Serializable

data class Jwt(
    var jwt: String
): Serializable {
    constructor() : this("")
}
