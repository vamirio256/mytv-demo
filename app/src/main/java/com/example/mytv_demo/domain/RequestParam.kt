package com.example.mytv_demo.domain

class RequestParam: HashMap<String, String>() {
    companion object {
        fun createDefaultParams(): HashMap<String, String> {
            val hm = HashMap<String, String>()
            hm["device_type"] = "9"
            return hm
        }
    }
}