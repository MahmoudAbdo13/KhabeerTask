package com.mahomud.khabeertask.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahomud.khabeertask.data.LoginResponse
import com.mahomud.khabeertask.data.Raw
import com.mahomud.khabeertask.data.Response
import kotlinx.coroutines.launch

class UserViewModel (

): ViewModel(){
    private val loginLiveData = MutableLiveData<LoginResponse>()
    private val usersLiveData = MutableLiveData<Response>()
    private val repo = Repo()

    fun loginUser(raw: Raw): MutableLiveData<LoginResponse>{
        viewModelScope.launch {
            loginLiveData.value = repo.login(raw)
        }
        return loginLiveData
    }

    fun getpayroll(token: String) : MutableLiveData<Response>{
        viewModelScope.launch {
            usersLiveData.value = repo.getPayroll(token)
        }
        return usersLiveData
    }
}