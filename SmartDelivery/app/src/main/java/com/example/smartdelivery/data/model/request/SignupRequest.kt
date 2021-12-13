package com.example.smartdelivery.data.model.request

import java.io.Serializable

data class SignupRequest (
    var id: String,
    var password: String,
    var name:String,
    var phone:String,
    var address:String,
    var email:String,
    ): Serializable {
        constructor(): this("","","","","","")
}




