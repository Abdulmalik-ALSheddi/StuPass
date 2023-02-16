package com.mlk.stupass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MajorsRecyclerView(
    private val majors: ArrayList<Major>,
    private val callback: MajorItemCallback
) : RecyclerView.Adapter<ViewHolder>() {

    inner class MajorViewHolder(view: View) : ViewHolder(view) {

        private val image = view.findViewById<ImageView>(R.id.majorIM)
        private val name = view.findViewById<TextView>(R.id.majorTV)
        private val root = view.findViewById<ConstraintLayout>(R.id.root)

        fun bind(major: Major) {
            name.text = major.name
            image.setImageResource(major.image)

            root.setOnClickListener {
                callback.onItemClick(major)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.major_item_layout, parent, false)
        return MajorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is MajorViewHolder) holder.bind(majors[position])
    }

    override fun getItemCount() = majors.size
}




//package com.mlk.stupass
//

//import android.util.Log
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.ViewHolder
//
//class MajorsRecyclerView( private val majors: ArrayList<Major>):
//RecyclerView.Adapter<ViewHolder>(){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return MajorViewHolder(inflater.inflate(R.layout.major_item_layout,parent,false))
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        if (holder is MajorViewHolder)
//            holder.bind(majors[position])
//    }
//
//    override fun getItemCount() = majors.size
//}