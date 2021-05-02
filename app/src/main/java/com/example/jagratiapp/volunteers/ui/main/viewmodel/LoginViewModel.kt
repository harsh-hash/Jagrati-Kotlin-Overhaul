package com.example.jagratiapp.volunteers.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jagratiapp.volunteers.data.repository.AuthRepository

class LoginViewModel : ViewModel() {
    var email : String = ""
    var password : String = ""
    var toast:MutableLiveData<String> = MutableLiveData()
    val auth:AuthRepository = AuthRepository()
    var loginSuccess: MutableLiveData<Boolean>  = auth
            .loginSuccess
    var check:String=""

    fun onLoginClicked(){
        Log.d("LoginViewModel", "onLoginClicked: $email and $password ")
        if (email.isNotEmpty() && password.isNotEmpty())
        {
            check= auth.signIn(email,password)
            Log.d("LoginViewModel", "onLoginClicked: $check")
        }
        toast.postValue(check)
    }
}
