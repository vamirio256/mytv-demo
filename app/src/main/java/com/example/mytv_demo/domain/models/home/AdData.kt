package com.example.mytv_demo.domain.models.home

data class AdData(
    val ad_id: Int,
    val ad_info: String,
    val ad_type: String,
    val ads_partner: Int,
    val is_skip: Int,
    val time_skip: Int
)