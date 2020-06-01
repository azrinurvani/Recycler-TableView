package com.mobile.azrinurvani.recyclerviewtableviewkotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseGetMahasiswa(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("datanya")
	val datanya: List<DataMahasiswa?>? = null,

	@field:SerializedName("status")
	val status: Int? = null
) : Parcelable

@Parcelize
data class DataMahasiswa(

	@field:SerializedName("mahasiswa_jekel")
	val mahasiswaJekel: String? = null,

	@field:SerializedName("mahasiswa_email")
	val mahasiswaEmail: String? = null,

	@field:SerializedName("mahasiswa_jurusan")
	val mahasiswaJurusan: String? = null,

	@field:SerializedName("mahasiswa_nama")
	val mahasiswaNama: String? = null,

	@field:SerializedName("mahasiswa_id")
	val mahasiswaId: String? = null,

	@field:SerializedName("mahasiswa_nim")
	val mahasiswaNim: String? = null
) : Parcelable
