package com.mahomud.khabeertask.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "http://40.127.194.127:5656/Salamtak/"

    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                var client = OkHttpClient.Builder()
                    .readTimeout(45, TimeUnit.SECONDS)
                    .build()

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

}