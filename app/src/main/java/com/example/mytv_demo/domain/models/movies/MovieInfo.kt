package com.example.mytv_demo.domain.models.movies

import com.google.gson.annotations.SerializedName

data class MovieInfo(

    @SerializedName("CONTENT_TITLE")
    val title: String,

    @SerializedName("CONTENT_ID")
    val id: Int? = null,

    @SerializedName("CONTENT_NAME_EN")
    val titleEn: String? = null,

    @SerializedName("CONTENT_IMAGE_URL")
    val imageUrl: String? = null,

    @SerializedName("CONTENT_IMAGE_HOR")
    val imageUrlHor: String? = null,

    @SerializedName("CONTENT_AGE")
    val age: String? = null,

    @SerializedName("TRAILER_PATH")
    val trailerUrl: String? = null,

    @SerializedName("TRAILER_PLAY")
    val trailerPlay: String? = null,

    @SerializedName("IS_LIVE")
    val isLived: Int? = null,

    @SerializedName("IS_LOCKED_CONTENT")
    val isLocked: Int? = null,

    @SerializedName("CONTENT_CATEGORY_NAME")
    val categoryName: String? = null,

    @SerializedName("CONTENT_COUNTRY")
    val country: String? = null,

    @SerializedName("CONTENT_DESC")
    val description: String? = null,

    @SerializedName("CONTENT_DURATION")
    val duration: String? = null,

    @SerializedName("CONTENT_PUBLISH_YEAR")
    val publishYear: String? = null,
)