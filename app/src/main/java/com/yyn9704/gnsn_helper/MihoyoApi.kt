package com.yyn9704.gnsn_helper

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface MihoyoApi {
    @Headers("accept: application/json", "content-type: application/json")
    @POST("event/sol/sign")
    fun checkIn(@Query("act_id") actId: String, @Query("lang") lang: String, @Body request: MihoyoRequest) : Call<MihoyoCheckInResponse>
}