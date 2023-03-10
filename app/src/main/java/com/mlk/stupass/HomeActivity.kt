package com.mlk.stupass

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), MajorItemCallback {

    lateinit var majors: ArrayList<Major>
    lateinit var tips: ArrayList<Tip>
    lateinit var majorsRV: RecyclerView
    lateinit var tipsRV: RecyclerView
    lateinit var toolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
    }

    private fun init() {
        toolBar = findViewById(R.id.toolBar)
        majorsRV = findViewById(R.id.majorsRV)
        tipsRV = findViewById(R.id.tipsRV)

        val programming = Major("Programming", R.drawable.programming)
        val ai = Major("AI", R.drawable.ai)
        val networks = Major("Networks", R.drawable.networking)
        val math = Major("Math", R.drawable.math)
        val chem = Major("Chem", R.drawable.chem)
        val phy = Major("Physics", R.drawable.phy)

        majors = arrayListOf(programming, ai, networks, math, chem, phy)
        majorsRV.adapter = MajorsRecyclerView(majors, this)

        val tip1 = Tip("Kotlin guide", "kotlin for beginners", R.drawable.ai)
        val tip2 = Tip("Android studio", "Complete walk through", R.drawable.networking)
        val tip3 = Tip("FireBase", "easy setup", R.drawable.chem)
        val tip4 = Tip("XML guide", "XML for beginners", R.drawable.phy)
        val tip5 = Tip("SQL", "SQL for beginners", R.drawable.programming)
        val tip6 = Tip("SQL", "SQL for beginners", R.drawable.programming)


        tips = arrayListOf(tip1, tip2, tip3, tip4, tip5, tip6)
        tipsRV.adapter = TipsRecyclerView(tips)
    }

    override fun onItemClick(major: Major) {
//        Log.d("TAG!", "onItemClick: $major\n $tips")
        var tips2 = arrayListOf<Tip>()
        for (tip in tips){
//            Log.d("TAG!", "Loop: ${major.image}  ${tip.image}")

            if(tip.image == major.image)
                tips2.add(tip)
        }
        tipsRV.adapter = TipsRecyclerView(tips2)
    }
}


//package com.mlk.stupass
//
//import android.content.Context
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.widget.Toolbar
//import androidx.recyclerview.widget.RecyclerView
//
//class HomeActivity : AppCompatActivity() {
//
//    lateinit var majors:ArrayList<Major>
//    lateinit var tips:ArrayList<Tip>
//    lateinit var majorsRV: RecyclerView
//    lateinit var tipsRV: RecyclerView
//    lateinit var toolBar : Toolbar
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
//
//        toolBar = findViewById(R.id.toolBar)
//        init()
//
//    }
//    fun init(){
//
//        majorsRV = findViewById(R.id.majorsRV)
//        tipsRV = findViewById(R.id.tipsRV)
//
//            val programming = Major("Programming", R.drawable.programming)
//            val ai = Major("AI", R.drawable.ai)
//            val networks = Major("Networks", R.drawable.networking)
//            val math = Major("Math", R.drawable.math)
//            val chem = Major("Chem", R.drawable.chem)
//            val phy = Major("Physics", R.drawable.phy)
//            majors = arrayListOf(programming, ai, networks, math, chem, phy)
//            majorsRV.adapter = MajorsRecyclerView(majors)
//
//            val tip1 = Tip("Kotlin guide", "kotlin for beginners", R.drawable.ai)
//            val tip2 = Tip("Android studio", "Complete walk through", R.drawable.programming)
//            val tip3 = Tip("FireBase", "easy setup", R.drawable.programming)
//            val tip4 = Tip("XML guide", "XML for beginners", R.drawable.programming)
//            val tip5 = Tip("SQL", "SQL for beginners", R.drawable.programming)
//            tips = arrayListOf(tip1, tip2, tip3, tip4, tip5)
//            tipsRV.adapter = TipsRecyclerView(tips)
//
//    }
//}