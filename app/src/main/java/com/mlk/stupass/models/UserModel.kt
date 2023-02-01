package com.mlk.stupass.models


import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

class UserModel: ViewModel() {
    val db = Firebase.firestore

    fun validName(name: String): Boolean {
        return when{
            else -> true
        }
    }
    fun validEmail(email: String): Boolean {
        return when{
            else -> true
        }
    }
    fun validPhone(phone: String): Boolean {
        return when{
            else -> true
        }
    }
    fun validPassword(password: String): Boolean {
        return when{
            else -> true
        }
    }

    fun findUser(phone: String) = callbackFlow {
//        var user: User? = null
        db.collection("users")
            .whereEqualTo("phone", "1234567890")
            .get()
            .addOnSuccessListener {
            for (document in it) {
                if (document.data["phone"] == phone){
                    Log.d("TAG_USER", "findUser: $document")
                    trySend(document.toObject(User::class.java))
                }
            }
                trySend(null)
        }
//            .addOnSuccessListener {
//            for (doc in it){
//                if(doc.data["phone"] == phone){
//                    return@addOnSuccessListener User(doc.data["name"],doc.data["email"],doc.data["phone"],doc.data["password"])
//                }
//            }
//        }
//        return user
        this.awaitClose()
    }

    fun getAll() = callbackFlow{
        val users = arrayListOf<User>()
        db.collection("users").get().addOnSuccessListener {
            for (doc in it ){
                users.add(doc.toObject(User::class.java))
            }
            trySend(users)
        }
        this.awaitClose()
    }

    fun addUser(name: String, email: String, phone: String, password: String) {
        val user = hashMapOf(
            "name" to name,
            "email" to email,
            "phone" to phone,
            "password" to password
        )
        db.collection("users").add(user).addOnSuccessListener { documentReference ->
            Log.d("TAGGG", "DocumentSnapshot added with ID: ${documentReference.id}")
        }
            .addOnFailureListener { e ->
                Log.w("TAGGG", "Error adding document", e)
            }
    }
}