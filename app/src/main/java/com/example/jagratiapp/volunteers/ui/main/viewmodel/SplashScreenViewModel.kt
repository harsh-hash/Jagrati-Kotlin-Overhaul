package com.example.jagratiapp.volunteers.ui.main.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jagratiapp.volunteers.data.repository.AuthRepository
import com.example.jagratiapp.volunteers.utils.Status
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class SplashScreenViewModel : ViewModel() {

    init {
        Log.i("SplashScreenViewModel", ": Created ")
    }
    var authRepository:AuthRepository = AuthRepository()

    var userLiveData : MutableLiveData<FirebaseUser> = getUser()


    private fun getUser(): MutableLiveData<FirebaseUser> {
        authRepository.getUser()
        return authRepository.users
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("SplashScreenView", ": Destroyed ")
    }


}