package com.example.mytv_demo.domain.models

data class APIResponse<T> (
    val result: Int,
    val message: String,
    val error: ApiError?,
    val data: T,
    val response: T
)