package com.mlk.stupass


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TipsRecyclerView( private val tips: ArrayList<Tip>):
    RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TipsViewHolder(inflater.inflate(R.layout.tip_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is TipsViewHolder)
            holder.bind(tips[position])
    }

    override fun getItemCount() = tips.size
}