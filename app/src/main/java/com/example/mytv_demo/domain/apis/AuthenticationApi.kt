package com.example.mytv_demo.domain.apis

import com.example.mytv_demo.base.BaseApi
import com.example.mytv_demo.domain.models.APIResponse
import com.example.mytv_demo.domain.models.channels.Channel
import com.example.mytv_demo.domain.models.payload.Payload
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi : BaseApi {
    @POST("/authen-v7")
    suspend fun signIn(@Body payload: Payload) : Response<APIResponse<Channel>>
}