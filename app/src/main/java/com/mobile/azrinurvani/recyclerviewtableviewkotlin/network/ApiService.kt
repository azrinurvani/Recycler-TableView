package com.mobile.azrinurvani.recyclerviewtableviewkotlin.network

import com.mobile.azrinurvani.recyclerviewtableviewkotlin.model.ResponseGetMahasiswa
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("getMahasiswa")
    fun getMahasiswa(
    ): Call<ResponseGetMahasiswa>?
}