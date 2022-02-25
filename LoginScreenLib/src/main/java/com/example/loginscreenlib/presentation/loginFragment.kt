package com.example.loginscreenlib.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import com.example.loginscreenlib.databinding.FragmentLoginBinding
import kotlinx.coroutines.flow.collect

class loginFragment : Fragment() {

    private lateinit var _binding: FragmentLoginBinding
    val binding: FragmentLoginBinding
        get() = _binding!!

    val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.contentScrolling.loginButton.setOnClickListener {
          login()
        }

       /* lifecycle.coroutineScope.launchWhenCreated {
            loginViewModel.loginResponse.collect {
                if (it.isLoading) {

                }
                if (it.error.isNotBlank()) {

                }
                it.data?.let {
                    // call homescreen
                    Toast.makeText(requireActivity(), it.data.toString(), Toast.LENGTH_LONG)
                }
            }
        }*/
    }

    private fun login() {
        val userName = binding.contentScrolling.etLogin.text.toString().trim()
        val passwd = binding.contentScrolling.etPaswd.text.toString().trim()
        if (userName.isNotEmpty() && passwd.isNotEmpty())
            loginViewModel.login(userName, passwd.toInt())
    }
}