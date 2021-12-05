package com.yyn9704.gnsn_helper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.work.*
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.Interceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val uploadWorkRequest: WorkRequest=
//            PeriodicWorkRequestBuilder<MihoyoCheckInWorker>(5, TimeUnit.MINUTES).build();
//        WorkManager.getInstance(baseContext).enqueue(uploadWorkRequest);


        Log.d("서비스 콜","서비스 콜!!")
        val supplementService = RetrofitClass.retrofit.create(MihoyoApi::class.java)
        val request = MihoyoRequest(MihoyoCookie("uid","token"))
        Log.d("디버그",Gson().toJson(request))
        supplementService.checkIn("e202102251931481","ko-kr",request)
            .enqueue(object : Callback<MihoyoCheckInResponse> {
                override fun onResponse(
                    call: Call<MihoyoCheckInResponse>,
                    response: Response<MihoyoCheckInResponse>
                ) {
                  var tv = findViewById<TextView>(R.id.MainActivity_HelloTextView)
                    tv.setText(response.body()?.message)
                }

                override fun onFailure(call: Call<MihoyoCheckInResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
    object RetrofitClass{
        val BASE_URL: String = "https://hk4e-api-os.mihoyo.com/"
         val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}
