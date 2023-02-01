package com.mlk.stupass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mlk.stupass.models.UserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.appcompat.widget.Toolbar
import com.mlk.stupass.models.User

class RegisterActivity : AppCompatActivity() {

    val db = Firebase.firestore
    lateinit var userModel:UserModel

    lateinit var toolbar: Toolbar
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
        CoroutineScope(Dispatchers.IO).launch {
            userModel.findUser(phone).collect {
                Log.d("TAG_USER", "onCreate: $it")
            }
        }

        toolbar.setNavigationOnClickListener {
            finish()
        }

        submitBU.setOnClickListener {
            if(isNotBlank())
                if (validInputs()){
                    Log.d("TAGG","Valid::: ${nameET.text} , ${emailET.text} , ${phoneET.text} , ${passwordET.text}")
                    userModel.addUser(nameET.text.toString(),emailET.text.toString(),phoneET.text.toString(),passwordET.text.toString())
                    toast("User Added")
                    startActivity(Intent(applicationContext, HomeActivity::class.java))
//                    CoroutineScope(Dispatchers.IO).launch {
//                        val users = userModel.getAll()
//                        for (user in users){
//
////                        val user = userModel.findUser(phone)
////                        if (userModel.findUser(phone) == null)
//                    }
//                    }

//                    var notFound = true
//                    db.collection("users").get().addOnSuccessListener {
//                        for (doc in it)
//                            if (phone == doc.data["phone"]){
//                                toast("Phone number already exists")
//                                notFound = false
//                            }
//                        if (notFound){
//                            userModel.addUser(name,email,phone,password,db)
//                            toast("User Added")
//                            startActivity(Intent(applicationContext,WelcomeActivity::class.java))
//                        }
//                    }
                }
        }
    }

    private fun init(){
        toolbar = findViewById(R.id.toolBar)
        nameET = findViewById(R.id.nameET)
        emailET = findViewById(R.id.emailET)
        phoneET = findViewById(R.id.phoneET)
        passwordET = findViewById(R.id.passwordET)
        submitBU = findViewById(R.id.submitBU)
        name = nameET.text.toString()
        email = emailET.text.toString()
        phone = phoneET.text.toString()
        password = passwordET.text.toString()
        userModel = ViewModelProvider(this)[UserModel::class.java]
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
//            emailET.setTextColor(R.color.red)
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

    private fun validInputs(): Boolean {
        var valid = true
        if (!userModel.validName(name)){
            toast("Wrong name")
            valid = false
        }
        if (!userModel.validEmail(email)){
            toast("Wrong Email")
            valid = false
        }
        if (!userModel.validPhone(phone)){
            toast("Wrong Phone")
            valid = false
        }
        if (!userModel.validPassword(password)){
            toast("Wrong Password")
            valid = false
        }
        return valid
    }

    private fun toast(msg: String){
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
}