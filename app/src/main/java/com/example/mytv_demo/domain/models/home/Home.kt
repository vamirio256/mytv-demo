package com.example.mytv_demo.domain.models.home

data class Home(
    val IP_SERVER: String,
    val `data`: Data,
    val ip_client: String,
    val message: String,
    val optional: Optional,
    val result: Int,
    val ser_time: String,
    val time_exec: Int,
    val time_log: TimeLog
)