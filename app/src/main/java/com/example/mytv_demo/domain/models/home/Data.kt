package com.example.mytv_demo.domain.models.home

data class Data(
    val ad_data: AdData,
    val menu_left_config: MenuLeftConfig,
    val reminder_v2: Any,
    val row1: Row1,
    val row2: Row2,
    val service: List<Service>,
    val trailer: Trailer
)