package com.yyn9704.gnsn_helper

data class MihoyoRequest(
    val cookies : MihoyoCookie

)

data class MihoyoCookie(
    val ltuid: String, val ltoken: String
)


