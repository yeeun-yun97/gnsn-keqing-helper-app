package com.yyn9704.gnsn_helper

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MihoyoCheckInCallback :Callback<MihoyoCheckInResponse>{
    override fun onResponse(call: Call<MihoyoCheckInResponse>, response: Response<MihoyoCheckInResponse>) {
        Log.d("디버그",response.message())
    }

    override fun onFailure(call: Call<MihoyoCheckInResponse>, t: Throwable) {
        TODO("Not yet implemented")
    }



}