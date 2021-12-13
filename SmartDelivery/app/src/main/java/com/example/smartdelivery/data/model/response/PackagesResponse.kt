package com.example.smartdelivery.data.model.response
import java.io.Serializable

class PackagesResponse (
    var isSuccess: Boolean,
    var code: String,
    var message: String,
    var createdAt :String,  //도착시간
    var trackingNumber:String, //송장번호
    var imageUrl:String  //이미지
): Serializable {
    constructor() : this(false, "", "", "","","")
}
//택배사 정보들을 가져와야한다.


