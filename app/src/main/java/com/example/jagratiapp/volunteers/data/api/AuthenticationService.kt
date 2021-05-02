package com.example.jagratiapp.volunteers.data.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jagratiapp.volunteers.utils.Status
import com.example.jagratiapp.volunteers.utils.Status.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationService  {
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    var firebaseUser:MutableLiveData<FirebaseUser> = MutableLiveData()
    private val TAG : String = "Authentication Service: "
    private var check:String = ""
    private var signInCheck:String = ""
    var loginSuccess:MutableLiveData<Boolean> = MutableLiveData(false)



    fun signUp(email:String, password:String):String{
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    check = if (it.isSuccessful) {
                        firebaseAuth.currentUser?.sendEmailVerification()
                        firebaseAuth.signOut()
                        "Check Email for Verification"
                    } else {
                        Log.w(TAG, "signUp: failure", it.exception)

                        it.exception.toString()
                    }
                }
            return check

    }

    fun signIn(email:String,password:String):String{
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                     check = if (it.isSuccessful){
                                firebaseUser.postValue(firebaseAuth.currentUser)
                                loginSuccess.postValue(true)
                                it.exception.toString()
                     }
                    else
                         it.exception.toString()
                }
       return check
    }

    }



