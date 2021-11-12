package com.wikipedia.myapplication.user

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.fasterxml.jackson.databind.ObjectMapper
import com.wikipedia.myapplication.network.RetrofitClient
import com.wikipedia.myapplication.login.LoginUser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserViewModel : ViewModel(), Callback<ResponseBody> {
    private  val TAG = "UserViewModel"
    var userListResponse = MutableLiveData<ArrayList<User>>()
    private val userMutableLiveData: MutableLiveData<LoginUser>? = null

    fun getUser() {
        var call: Call<ResponseBody>? = null
        call = RetrofitClient.retrofitService.userDetails();
        call?.enqueue(this)

    }

    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
         var json:String? =response?.body()?.string()
        val mapper = ObjectMapper()
        val users: Array<User> = mapper.readValue(json, Array<User>::class.java)
        userListResponse.value=users.toCollection(ArrayList())
    }

    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
           Log.d(TAG, "onFailure: "+ t?.cause)
       }
}