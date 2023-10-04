package com.example.mytv_demo.data.repositories

import com.example.mytv_demo.data.db.ChannelDatabase
import com.example.mytv_demo.domain.apis.ChannelApi
import com.example.mytv_demo.utils.Constants
import javax.inject.Inject

class ChannelRepository @Inject constructor(
    private val channelDatabase: ChannelDatabase,
    private val channelApi: ChannelApi
) {
    suspend fun getAllChannels() = channelApi.getAllChannels(Constants.CHANNEL_PAYLOAD)

//    fun getMovie(){
//        RetrofitHelper.createService(MovieApi::class.java).getMovie(RequestParam.createDefaultParams().apply {
//            this["date_time"] = "now"
//        })
//    }
}
