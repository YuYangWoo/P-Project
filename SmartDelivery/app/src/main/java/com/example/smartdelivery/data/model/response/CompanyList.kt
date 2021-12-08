package com.example.smartdelivery.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CompanyList(
    @SerializedName("Company")
    val companies: ArrayList<Company>
)

data class Company(
    val Code: String,
    val Name: String
)