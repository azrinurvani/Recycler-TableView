package com.mobile.azrinurvani.recyclerviewtableviewkotlin.network

import com.mobile.azrinurvani.recyclerviewtableviewkotlin.util.Util
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServer  {


    private fun getClient(): Retrofit {
       return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.0.121:8080/server_mahasiswa/index.php/Server/")
                .build()

    }

    val instance : ApiService
        get() = getClient().create<ApiService>(ApiService::class.java)
}