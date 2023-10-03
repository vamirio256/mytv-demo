package com.example.mytv_demo.domain.apis

import com.example.mytv_demo.base.BaseApi
import com.example.mytv_demo.domain.models.APIResponse
import com.example.mytv_demo.domain.models.movies.MovieInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface HomeApi : BaseApi {

    @POST("home-page1-v2")
    suspend fun getHomePage(
        @Body payload: String,
        @Header("Content-Type") contentType: String = "application/x-www-form-urlencoded",
    ): Response<APIResponse<MovieInfo>>
}