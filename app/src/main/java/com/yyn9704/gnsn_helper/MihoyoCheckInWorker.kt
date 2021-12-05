package com.yyn9704.gnsn_helper

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MihoyoCheckInWorker (appContext: Context, workerParams: WorkerParameters): Worker(appContext, workerParams){
    val BASE_URL: String = "https://hk4e-api-os.mihoyo.com"
//    val BASE_URL: String = "https://hk4e-api-os.mihoyo.com/event/sol/sign?act_id=e202102251931481&lang=ko-kr"
    override fun doWork(): Result {
        mihoyoCheckIn()
        return Result.success()
//        return Result.failure()
//        return Result.retry()
    }

    private fun mihoyoCheckIn() {

    }





}