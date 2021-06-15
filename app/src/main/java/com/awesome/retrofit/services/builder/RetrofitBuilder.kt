package com.awesome.retrofit.services.builder

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    //
    //Define the base url to the web service
    private const val base_url = "https://82b11d4ee434.ngrok.io"
    //
    //Create request/response Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    //
    //Create the Okhttp client
    private val okHttp = OkHttpClient.Builder().addInterceptor(logger)
    //
     //Create the Retrofit builder
    private val builder = Retrofit.Builder().baseUrl(base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttp.build())
    //Create Retrofit instance
    private val retrofit = builder.build()
    //
    //Create a function that takes in a generic class
    fun <T>buildService(serviceType: Class<T>):T{
        return retrofit.create(serviceType)
    }
}