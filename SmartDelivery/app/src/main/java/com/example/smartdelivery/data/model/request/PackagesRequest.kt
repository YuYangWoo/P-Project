package com.example.smartdelivery.data.model.request
import java.io.Serializable


class PackagesRequest (
    var id: String
    ):Serializable {
    constructor(): this("")
}

//아이디를 주고 도착한 택배 조회, 예진님은 jwt 헤더에 넣어서 보내면 된다고 하시는데 잘몰르겠,,




