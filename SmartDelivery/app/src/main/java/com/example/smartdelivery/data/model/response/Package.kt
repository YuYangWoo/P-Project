package com.example.smartdelivery.data.model.response

import java.io.Serializable

data class Package(
    var packageIdx: Int,
    var createdAt: String,
    var companyCode: String,
    var trackingNumber: String,
    var imageUrl: String,
    var status: Int
): Serializable {
    constructor(): this(0,"","","","",0)
}
