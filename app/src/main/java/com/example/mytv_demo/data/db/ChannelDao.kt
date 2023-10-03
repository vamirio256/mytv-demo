package com.example.mytv_demo.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mytv_demo.domain.models.channels.Channel

@Dao
interface ChannelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Channel): Long

    @Query("SELECT * FROM channels")
    fun getAllChannels(): LiveData<List<Channel>>

    @Delete
    suspend fun deleteChannel(channel: Channel)
}