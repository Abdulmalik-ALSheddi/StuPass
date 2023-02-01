package com.mlk.stupass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBU = findViewById<Button>(R.id.loginBU)
        val signUpTV = findViewById<TextView>(R.id.signUpTV)

        loginBU.setOnClickListener {
            startActivity(Intent(applicationContext,HomeActivity::class.java))
        }
        signUpTV.setOnClickListener{
            startActivity(Intent(applicationContext,RegisterActivity::class.java))
        }
    }
}