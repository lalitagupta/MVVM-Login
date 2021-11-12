package com.wikipedia.myapplication.network

import com.wikipedia.myapplication.login.LoginUser
import retrofit2.http.GET
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiService {
    @POST()
    fun login(@Body loginUser: LoginUser, @Url url: String="https://reqres.in/api/login"): Call<ResponseBody>?
    @GET()
    fun userDetails(@Url url: String="https://jsonplaceholder.typicode.com/users"): Call<ResponseBody>?
}