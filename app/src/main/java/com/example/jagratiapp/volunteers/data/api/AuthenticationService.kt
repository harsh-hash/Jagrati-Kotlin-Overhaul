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
    var firebaseUser = MutableLiveData<FirebaseUser>(getUser())
    private val TAG : String = "Authentication Service: "
    private var check:String = ""


    private fun getUser(): FirebaseUser?{
        return firebaseAuth.currentUser
    }
    fun signUp(email:String, password:String):String{
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if (it.isSuccessful)
                    {
                        firebaseAuth.signOut()
                        check  = "Check Email for Verification"
                    }
                    else {
                        Log.w(TAG, "signUp: failure", it.exception)
//                        signUpSuccess.postValue("Authentication Failed")
                        check = it.exception.toString()

                    }
                }
            return check

    }

    fun signIn(email:String,password:String){
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        if (firebaseAuth.currentUser.isEmailVerified)
                        {
                            firebaseUser.postValue(firebaseAuth.currentUser)
//                            isSignedIn.postValue("Logged in Successfully")
                        }
                        else
                        {
//                            isSignedIn.postValue("Please Verify your Email")
                            firebaseAuth.signOut()
                        }
                    }
                    else
                        Log.w(TAG, "signIn: ${task.exception.toString()}", task.exception)
//                        isSignedIn.postValue("Login Credential Incorrect")
                }
    }

    }



