package com.mlk.stupass

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MajorsRecyclerView( private val majors: ArrayList<Major>):
RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MajorViewHolder(inflater.inflate(R.layout.major_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is MajorViewHolder)
            holder.bind(majors[position])
    }

    override fun getItemCount() = majors.size
}