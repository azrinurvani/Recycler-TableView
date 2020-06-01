package com.mobile.azrinurvani.recyclerviewtableviewkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.azrinurvani.recyclerviewtableviewkotlin.R
import com.mobile.azrinurvani.recyclerviewtableviewkotlin.model.DataMahasiswa
import kotlinx.android.synthetic.main.item_students.view.*

class StudentsAdapter(private val listStudents: List<DataMahasiswa?>?): RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_students,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = listStudents?.size!! + 1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rowPosition = holder.adapterPosition

        //set first item as title header
        if (rowPosition==0){
            holder.itemView.apply {
                setHeaderBg(txtName)
                setHeaderBg(txtMajor)
                setHeaderBg(txtGender)
                setHeaderBg(txtNim)
                setHeaderBg(txtEmail)

                txtName.text = "Name"
                txtMajor.text = "Major"
                txtGender.text = "Gender"
                txtNim.text = "Nim"
                txtEmail.text = "Email"
            }
        }else{
            val updateList = listStudents?.get(rowPosition - 1)
            holder.itemView.apply {
                setContentBg(txtName)
                setContentBg(txtMajor)
                setContentBg(txtNim)
                setContentBg(txtGender)
                setContentBg(txtEmail)

                txtName.text = updateList?.mahasiswaNama
                txtMajor.text = updateList?.mahasiswaJurusan
                txtGender.text = updateList?.mahasiswaJekel
                txtNim.text = updateList?.mahasiswaNim
                txtEmail.text = updateList?.mahasiswaEmail

            }
        }
    }


    private fun setHeaderBg(view: View){
        view.setBackgroundResource(R.drawable.table_header_cell_bg)
    }

    private fun setContentBg(view: View){
        view.setBackgroundResource(R.drawable.table_content_cell_bg)
    }

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)
}