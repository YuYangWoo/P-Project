package com.example.smartdelivery.data.model.response
import java.io.Serializable

class PackagesResponse (
    var isSuccess: Boolean,
    var code: String,
    var message: String,
    var result: Jwt
): Serializable {
    constructor() : this(false, "", "", Jwt())
}
//택배사 정보들을 가져와야한다.