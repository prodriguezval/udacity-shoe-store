package com.udacity.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import timber.log.Timber


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false )

        binding.btnLogin.setOnClickListener {
            signUp()
        }
        binding.btnCreateAccount.setOnClickListener {
            signIn()
        }

        return binding.root
    }

    private fun signUp() {
        Timber.i("Sing Up Button clicked")
        markAsLogged()
        navigateToRoute()
    }

    private fun signIn() {
        Timber.i("Sing In Button clicked")
        markAsLogged()
        navigateToRoute()
    }

    private fun markAsLogged() {
        val viewModel: LoginViewModel by activityViewModels()
        viewModel.onLogin()
    }

    private fun navigateToRoute() {
        val viewModel: LoginViewModel by activityViewModels()
        if (viewModel.isOnboarded.value == true) {
            Timber.i("Navigating to Shoe list")
            findNavController().navigate(R.id.action_loginFragment_to_shoeListFragment)
        } else {
            Timber.i("Navigating to welcome fragment")
            findNavController().navigate(R.id.action_loginFragment_to_welcome)
        }

    }
}