package com.wikipedia.myapplication.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun getRetrofit(): Retrofit {
       return Retrofit.Builder()
               .baseUrl("https://www.google.com/")
               .addConverterFactory(GsonConverterFactory.create( GsonBuilder().create()))
               .build()
    }
    val retrofitService: ApiService by lazy {
        getRetrofit().create(ApiService::class.java)
    }

}