package com.example.jagratiapp.volunteers.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.jagratiapp.HomePage
import com.example.jagratiapp.R
import com.example.jagratiapp.databinding.SplashScreenFragmentBinding
import com.example.jagratiapp.volunteers.ui.main.viewmodel.SplashScreenViewModel


class SplashScreen : Fragment() {

    private lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding : SplashScreenFragmentBinding =
                DataBindingUtil.inflate(inflater, R.layout.splash_screen_fragment, container, false)

        viewModel = ViewModelProvider(this).get(SplashScreenViewModel::class.java)
        viewModel.userLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("SplashScreen", "onActivityCreated: $it ")

            when (it?.isEmailVerified) {
                true -> startActivity(Intent( activity,HomePage::class.java))
                false -> gotoLogin()
            }
        })
        return binding.root
    }

    private fun gotoLogin() {
        findNavController().navigate(R.id.action_splashScreen_to_login)
    }

}