package com.mlk.stupass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {

    lateinit var loginBU: Button
    lateinit var registerBU: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        init()
        listeners()
    }

    private fun init(){
        loginBU = findViewById(R.id.loginBU)
        registerBU = findViewById(R.id.registerBU)
    }
    private fun listeners(){
        loginBU.setOnClickListener {
            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }
        registerBU.setOnClickListener {
            startActivity(Intent(applicationContext,RegisterActivity::class.java))
        }
    }
}