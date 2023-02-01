package com.mlk.stupass

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MajorViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val image = view.findViewById<ImageView>(R.id.majorIM)
    private val name = view.findViewById<TextView>(R.id.majorTV)
    private val root = view.findViewById<ConstraintLayout>(R.id.root)

    fun bind(major: Major) {
        name.text = major.name
        image.setImageResource(major.image)
        root.setOnClickListener {

        }
    }
}