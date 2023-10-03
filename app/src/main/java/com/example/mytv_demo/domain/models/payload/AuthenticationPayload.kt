package com.example.mytv_demo.domain.models.payload

data class AuthenticationPayload(
    val device_model: String = "sdk_google_atv64_amati_arm64",
    val fk: String = "first%23key",
    val device_type: Int = 9,
    val version_number: Int = 470,
    val password: String = "c4ca4238a0b923820dcc509a6f75849b",
    val authen_type: Int = 2,
    val manufacturer_id: String = "7046fc86f010cba1",
    val device_manu: String = "Google",
    val app_hash: String = "b57a114216395fbb0909acf4bc49f497",
    val username: String = "tsna90"
)