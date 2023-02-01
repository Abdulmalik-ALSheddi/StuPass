package com.mlk.stupass

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class TipsViewHolder(view: View): RecyclerView.ViewHolder(view)  {

    private val image = view.findViewById<ImageView>(R.id.tipIM)
    private val title = view.findViewById<TextView>(R.id.tipTitle)
    private val description = view.findViewById<TextView>(R.id.tipDes)
    private val root = view.findViewById<ConstraintLayout>(R.id.tipRoot)

    fun bind(tip: Tip) {
        title.text = tip.title
        description.text = tip.description
        image.setImageResource(tip.image)
        root.setOnClickListener {
            Log.d("TAGG", "root 2 clicked")

        }
    }
}