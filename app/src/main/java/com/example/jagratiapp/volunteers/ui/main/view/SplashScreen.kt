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
import com.example.jagratiapp.HomePage
import com.example.jagratiapp.R
import com.example.jagratiapp.databinding.SplashScreenFragmentBinding
import com.example.jagratiapp.volunteers.ui.main.viewmodel.SplashScreenViewModel


class SplashScreen : Fragment() {

    companion object {
        fun newInstance() = SplashScreen()
    }

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
                true -> {
                    startActivity(Intent( activity,HomePage::class.java))
                }
//                    startActivity(Intent(activity, HomePage::class.java))
                false -> {
                    Toast.makeText(activity, "Check Verification Email", Toast.LENGTH_SHORT).show()
                    val view: View = binding.splashLogoFragment
                    val extras = FragmentNavigatorExtras(
                            binding.splashLogoFragment to "splash_logo_fragment")
                    view.findNavController().navigate(R.id.action_splashScreen_to_login,null,null,extras)
                }
                else -> {
//                    val handler = Handler()
//                    handler.postDelayed(Runnable { // Do something after 5s = 5000ms
                        val view: View = binding.splashLogoFragment
                        view.findNavController().navigate(R.id.action_splashScreen_to_login)
//                        ViewCompat.setTransitionName(binding.splashLogoFragment, "splash_logo_fragment")
//                    }, 500)


                }
            }
        })
        return binding.root
    }

}