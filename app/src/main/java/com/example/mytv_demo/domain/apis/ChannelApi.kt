package com.example.mytv_demo.domain.apis

import com.example.mytv_demo.base.BaseApi
import com.example.mytv_demo.domain.models.APIResponse
import com.example.mytv_demo.domain.models.channels.Channel
import com.example.mytv_demo.domain.models.channels.ChannelCategory
import retrofit2.Response
import retrofit2.http.*

interface ChannelApi : BaseApi {

    @POST("channel/list-v3")
    suspend fun getAllChannels(
        @Body payload: String,
        @Header("Content-Type") contentType: String = "application/x-www-form-urlencoded",
        ): Response<APIResponse<List<Channel>>>

    @FormUrlEncoded
    @POST("channel/")
    suspend fun getChannelCategories(
        @Body payload: String,
    ): Response<APIResponse<List<ChannelCategory>>>
}