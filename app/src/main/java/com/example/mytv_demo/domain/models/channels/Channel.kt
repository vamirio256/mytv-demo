package com.example.mytv_demo.domain.models.channels

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "channels"
)
data class Channel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @SerializedName("CONTENT_ID")
    val contentId: String,

    @SerializedName("CONTENT_IMAGE_SMALL")
    val imageUrlSmall: String,

    @SerializedName("CONTENT_IMAGE_URL")
    val imageUrl: String,

    @SerializedName("CONTENT_TITLE")
    val title: String,

    @SerializedName("SORT_ORDER")
    val sortOrder: String,
)