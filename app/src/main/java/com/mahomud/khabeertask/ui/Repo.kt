package com.mahomud.khabeertask.ui

import com.mahomud.khabeertask.api.ApiClient
import com.mahomud.khabeertask.api.KhabeerApi
import com.mahomud.khabeertask.data.LoginResponse
import com.mahomud.khabeertask.data.Raw
import com.mahomud.khabeertask.data.Response

class Repo {

    private val retrofit = ApiClient.retrofitInstance
    private val api = retrofit?.create(KhabeerApi::class.java)

    suspend fun login(raw: Raw): LoginResponse{
        return api!!.login(raw)

    }
    suspend fun getPayroll(token: String): Response{
        return api!!.getPayroll(token)
    }
}