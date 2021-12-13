package com.example.smartdelivery.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PackagesList(
    @SerializedName("packages")
    val companies: ArrayList<packages>
)

//송장번호, 시간, 이미지
data class packages(
    val createdAt:String, //도착시간
    val trackingNumber:String, //송장번호
    val imageUrl:String //이미지
)


//사용안함