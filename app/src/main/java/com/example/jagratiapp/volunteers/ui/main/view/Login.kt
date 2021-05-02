package com.example.jagratiapp.volunteers.ui.main.view

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.transition.TransitionInflater
import com.example.jagratiapp.HomePage
import com.example.jagratiapp.R
import com.example.jagratiapp.databinding.LoginFragmentBinding
import com.example.jagratiapp.volunteers.ui.main.viewmodel.LoginViewModel

class Login : Fragment() {

    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = android.transition.TransitionInflater.from(context).inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding:LoginFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.login_fragment,container,false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.toast.observe(viewLifecycleOwner, Observer {
            if (it.trim().isEmpty())
                Toast.makeText(activity, it,Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(activity, "Check your Internet Connection",Toast.LENGTH_SHORT).show()
        })
        viewModel.loginSuccess.observe(viewLifecycleOwner, Observer {
            if(it == true)
             startActivity(Intent( activity,HomePage::class.java))
        })
        binding.viewModel = viewModel
        return binding.root
    }
}