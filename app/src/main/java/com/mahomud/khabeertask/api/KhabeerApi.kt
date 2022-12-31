package com.mahomud.khabeertask.api

import com.mahomud.khabeertask.data.LoginResponse
import com.mahomud.khabeertask.data.Raw
import com.mahomud.khabeertask.data.Response
import retrofit2.Call
import retrofit2.http.*

interface KhabeerApi {
    companion object {
        const val BASE_URI: String = "http://40.127.194.127:5656/Salamtak/"
    }

    @POST("Login")
    suspend fun login(@Body raw: Raw): LoginResponse

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("GetPayroll")
    suspend fun getPayroll(@Header("Authorization") authToken: String): Response

}