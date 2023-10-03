package com.example.mytv_demo.data.db

import androidx.room.TypeConverter
import com.example.mytv_demo.domain.models.channels.ChannelCategory
import com.example.mytv_demo.domain.models.movies.MovieInfo

class Converter {

    @TypeConverter
    fun fromMovieInfo(movieInfo: MovieInfo): String {
        return movieInfo.title
    }

    @TypeConverter
    fun toMovieInfo(title: String): MovieInfo {
        return MovieInfo(title = title)
    }

    fun toChannelCategory(id: String, name: String): ChannelCategory {
        return ChannelCategory(id = id)
    }
}