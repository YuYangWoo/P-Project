package com.example.smartdelivery.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PackagesList(
    @SerializedName("packages")
    val companies: ArrayList<packages>
)

data class packages(
    val packageIdx:Int,
    val createdAt:String,
    val companyCode:String,
    val trackingNumber:String,
    val imageUrl:String,
    val isRobbed:String,
    val isReceived:String
)
/*
* 택배 정보
* packageIdx: 택배 idx
* createdAt:택배 도착시간
* companyCode:택배사 코드
* trackingNumber:운송장번호
* imageUrl:택배 이미지
* isRobbed:도난 여부
* isRecevied:수령여부
* */