package com.example.smartdelivery.data.model.response
import java.io.Serializable

class PackagesResponse (
    var isSuccess: Boolean,
    var code: Int,
    var message: String,
    var result: List<Package>
)


