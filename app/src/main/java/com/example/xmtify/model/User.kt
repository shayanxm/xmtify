package com.example.xmtify.model

import com.squareup.moshi.Json

class User {

//    var birthdate: String? = null
//    var country: String? = null
@Json(name = "display_name")
var displayName: String? = null
    var email: String? = null

    var id: String? = null
}