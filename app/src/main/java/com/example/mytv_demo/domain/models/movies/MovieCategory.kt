package com.example.mytv_demo.domain.models.movies

import com.google.gson.annotations.SerializedName

data class MovieCategory(

    @SerializedName("CATE_ID")
    val id: String?,

    @SerializedName("CATE_NAME")
    val name: String?,

    @SerializedName("PARAMS_CATE")
    val paramCate: String?,

    @SerializedName("PARAMS_LIST")
    val paramList: String?,

    @SerializedName("DATA")
    val movies: List<MovieInfo>?
)