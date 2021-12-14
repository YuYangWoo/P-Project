package com.example.smartdelivery.data.model.response

data class PackageDetailResponse(
    var isSuccess: Boolean,
    var code: Int,
    var message: String,
    var result: Detail
)
