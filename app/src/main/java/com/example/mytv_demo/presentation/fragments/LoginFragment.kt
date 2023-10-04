package com.example.mytv_demo.presentation.fragments

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.mytv_demo.R
import com.example.mytv_demo.databinding.FragmentLoginBinding
import com.example.mytv_demo.presentation.viewmodels.LoginViewModel

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.btnLogin.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.navigate_to_main)
        }

        initializeBackground()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initializeBackground() {
        val animateBackground = binding.layoutLogin.background as AnimationDrawable
        animateBackground.setEnterFadeDuration(10)
        animateBackground.setExitFadeDuration(3000)
        animateBackground.start()
    }
}