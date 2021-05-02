package com.example.jagratiapp.volunteers.data.repository

import android.app.Application
import android.text.BoringLayout
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jagratiapp.volunteers.data.api.AuthenticationService
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepository {
    //private val TAG: String = "AuthRepository:"
    var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    var users: MutableLiveData<FirebaseUser> = MutableLiveData()
    var auth = AuthenticationService()
    var loginSuccess:MutableLiveData<Boolean> = auth.loginSuccess


    fun getUser(){
        users.postValue(firebaseAuth.currentUser)
    }

    fun signUp(email: String, password: String): String {
        return auth.signUp(email, password)
    }

    fun signIn(email: String, password: String): String {
        return auth.signIn(email, password)
    }
}