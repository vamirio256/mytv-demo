package com.example.mytv_demo.domain.apis

import com.example.mytv_demo.base.BaseApi
import com.example.mytv_demo.domain.RequestParam
import com.example.mytv_demo.domain.models.APIResponse
import com.example.mytv_demo.domain.models.movies.MovieCategory
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface MovieApi : BaseApi {

//    @FormUrlEncoded
//    @POST("content/home")
//    suspend fun getMovie(
//        @FieldMap params: RequestParam
//    ):Response<APIResponse<List<MovieCategory>>>

    @FormUrlEncoded
    @POST("content/home")
    suspend fun getMovie(
        @Body payload: String,
        ):Response<APIResponse<List<MovieCategory>>>
}