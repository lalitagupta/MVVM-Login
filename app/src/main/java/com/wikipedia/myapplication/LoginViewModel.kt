package com.wikipedia.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel(), Callback<ResponseBody> {
    private  val TAG = "LoginViewModel"
     var userMutableLiveData= MutableLiveData<String>()

    fun getUser(loginUser: LoginUser) {
        var call: Call<ResponseBody>? = null
        call = RetrofitClient.retrofitService.login(loginUser);
        call?.enqueue(this)

    }

    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
        Log.d(TAG, "onResponse: "+ response?.body().toString())
       // Log.d(TAG, "onResponse: "+ response?.body()?.string())
        var json =response?.body()?.string()
        val token: String = JSONObject(json).getString("token");
        userMutableLiveData.value=token
    }

    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
        Log.d(TAG, "onFailure: ")
    }
}