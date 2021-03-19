package com.example.jagratiapp.volunteers.ui.main.view

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import com.example.jagratiapp.HomePage
import com.example.jagratiapp.R
import com.example.jagratiapp.databinding.SplashScreenFragmentBinding
import com.example.jagratiapp.login_page
import com.example.jagratiapp.volunteers.ui.main.viewmodel.SplashScreenViewModel

class SplashScreen : Fragment() {

    companion object {
        fun newInstance() = SplashScreen()
    }

    private lateinit var viewModel: SplashScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding : SplashScreenFragmentBinding =
                DataBindingUtil.inflate(inflater,R.layout.splash_screen_fragment,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashScreenViewModel::class.java)
        viewModel.userLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("SplashScreen", "onActivityCreated: $it ")
            if (it?.isEmailVerified == true)
                startActivity(Intent(activity, HomePage::class.java))
            else{
                Toast.makeText(activity, "Not Signed In", Toast.LENGTH_SHORT).show()
                startActivity(Intent(activity, login_page::class.java))
            }

        })

    }

}