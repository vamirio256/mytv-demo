package com.example.mytv_demo.domain.models.channels

import com.google.gson.annotations.SerializedName

data class ChannelCategory(
    @SerializedName("CATE_ID")
    val id: String,

    @SerializedName("CATE_NAME")
    val name: String? = null
)