package com.example.mytv_demo.domain.models.authentication

import com.google.gson.annotations.SerializedName

data class Authentication(

    @SerializedName("username_mytv")
    val usernameMytv: String,
    val session: String
)
