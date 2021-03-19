package com.example.jagratiapp.volunteers.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jagratiapp.volunteers.data.api.AuthenticationService
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepository {
    private val TAG : String = "AuthRepository:"
    var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    var users : MutableLiveData<FirebaseUser> = MutableLiveData(firebaseAuth.currentUser)
    var auth = AuthenticationService()



    fun signUp (email:String, password:String):String{
        return auth.signUp(email,password)
    }

//    fun signUp(email:String, password:String){
//        firebaseAuth.createUserWithEmailAndPassword(email,password)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful)
//                    {
//                        firebaseAuth.signOut()
//                        signUpSuccess.postValue("Check Email for Verification")
//                    //  users.postValue(firebaseAuth.currentUser)
//                    }
//                    else {
//                        Log.w(TAG, "signUp: failure", task.exception)
//                        signUpSuccess.postValue("Authentication Failed")
//                    }
//                }
//
//    }
//
//    fun signIn(email:String,password:String){
//        firebaseAuth.signInWithEmailAndPassword(email,password)
//                .addOnCompleteListener {task ->
//                    if (task.isSuccessful){
//                        if (firebaseAuth.currentUser.isEmailVerified)
//                        {
//                            users.postValue(firebaseAuth.currentUser)
//                            isSignedIn.postValue("Logged in Successfully")
//                        }
//                        else
//                        {
//                            isSignedIn.postValue("Please Verify your Email")
//                        }
//                    }
//                    else
//                        isSignedIn.postValue("Login Credential Incorrect")
//                }
//    }








//    var isUserVerified = MutableLiveData<Boolean>(
//            isUserVerified()
//    )
//
//    private fun isUserVerified():Boolean{
//        if (users.value?.isEmailVerified == true)
//            return true
//        return false
//    }


}