package com.example.jagratiapp.volunteers.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.jagratiapp.R
import com.example.jagratiapp.databinding.ActivityAuthenticationBinding


class Authentication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityAuthenticationBinding =   DataBindingUtil.setContentView(this, R.layout.activity_authentication)
    }
}