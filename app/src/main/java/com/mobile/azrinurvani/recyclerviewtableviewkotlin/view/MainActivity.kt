package com.mobile.azrinurvani.recyclerviewtableviewkotlin.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.azrinurvani.recyclerviewtableviewkotlin.R
import com.mobile.azrinurvani.recyclerviewtableviewkotlin.adapter.StudentsAdapter
import com.mobile.azrinurvani.recyclerviewtableviewkotlin.model.DataMahasiswa
import com.mobile.azrinurvani.recyclerviewtableviewkotlin.model.ResponseGetMahasiswa
import com.mobile.azrinurvani.recyclerviewtableviewkotlin.network.RetrofitServer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchData()
    }

    private fun requestInternetPermissions(){

    }

    private fun fetchData(){
        RetrofitServer.instance.getMahasiswa()?.enqueue(object : Callback<ResponseGetMahasiswa>{

            override fun onFailure(call: Call<ResponseGetMahasiswa>, t: Throwable) {
              Log.e("ADX","FetchData Exception ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<ResponseGetMahasiswa>, response: Response<ResponseGetMahasiswa>) {
                val status = response.body()?.status
                val msg = response.body()?.pesan
                if (status==1){
                    val dataMhs : List<DataMahasiswa?>? = response.body()?.datanya
                    val adapter = StudentsAdapter(dataMhs)
                    rvList.adapter = adapter
                    rvList.layoutManager = LinearLayoutManager(this@MainActivity)
                    Log.v("ADX","Data Mahasiswa ${dataMhs.toString()}")

                }else{
                    Log.e("ADX,","Status not 1, message : $msg")

                }
            }
        })
    }

}
