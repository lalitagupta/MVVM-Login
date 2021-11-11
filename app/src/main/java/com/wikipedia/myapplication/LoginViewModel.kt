package com.wikipedia.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel(), Callback<ResponseBody> {
    private  val TAG = "LoginViewModel"
    var EmailAddress = MutableLiveData<LoginUser>()
    private val userMutableLiveData: MutableLiveData<LoginUser>? = null

    fun getUser(loginUser: LoginUser) {
        var call: Call<ResponseBody>? = null
        call = RetrofitClient.retrofitService.login(loginUser);
        call?.enqueue(this)

    }

    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
        Log.d(TAG, "onResponse: "+ response?.body().toString())
        Log.d(TAG, "onResponse: "+ response?.body()?.string())


    }

    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
        Log.d(TAG, "onFailure: ")
    }
}