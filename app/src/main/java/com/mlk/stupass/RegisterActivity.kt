package com.mlk.stupass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mlk.stupass.models.UserModel

class RegisterActivity : AppCompatActivity() {

    val db = Firebase.firestore
    lateinit var userModel:UserModel
    lateinit var nameET:EditText
    lateinit var emailET:EditText
    lateinit var phoneET:EditText
    lateinit var passwordET:EditText
    lateinit var submitBU:Button
    lateinit var name:String
    lateinit var email:String
    lateinit var phone:String
    lateinit var password:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()

        submitBU.setOnClickListener {
            if(isNotBlank()){
                if (!userModel.validName(name))
                    toast("Wrong Name")
            }
        }
    }

    private fun init(){
        nameET = findViewById(R.id.nameET)
        emailET = findViewById(R.id.emailET)
        phoneET = findViewById(R.id.phoneET)
        passwordET = findViewById(R.id.passwordET)
        submitBU = findViewById(R.id.submitBU)
        name = nameET.text.toString()
        email = emailET.text.toString()
        phone = phoneET.text.toString()
        password = passwordET.text.toString()
    }
    private fun isNotBlank(): Boolean {
        var notBlank = true
        if(nameET.text.toString().isBlank()){
//            nameET.setHintTextColor(R.color.red)
            toast("Enter your name")
            notBlank = false
        }
        if (emailET.text.toString().isBlank())  {
//            emailET.setHintTextColor(R.color.red)
            toast("Enter your email")
            notBlank = false
        }
        if (phoneET.text.toString().isBlank())   {
            toast("Enter your phone number")
            notBlank = false
        }
        if (passwordET.text.toString().isBlank()){
            toast("Enter your phone password")
            notBlank = false
        }
        return notBlank
    }
    private fun toast(msg: String){
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
}