package com.example.mytv_demo.data.db

import android.content.Context
import androidx.room.*
import com.example.mytv_demo.domain.models.channels.Channel

@Database(
    entities = [Channel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class ChannelDatabase : RoomDatabase() {
    abstract fun getChannelDao(): ChannelDao

    companion object {
        @Volatile
        private var instance: ChannelDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ChannelDatabase::class.java,
            "channel_db.db"
        ).build()

    }
}