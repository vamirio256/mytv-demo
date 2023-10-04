package com.example.mytv_demo.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mytv_demo.MainActivity
import com.example.mytv_demo.R
import com.example.mytv_demo.databinding.FragmentMainBinding
import com.example.mytv_demo.presentation.viewmodels.LoginViewModel
import com.example.mytv_demo.presentation.viewmodels.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var activity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        activity = requireActivity() as MainActivity
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeToolBar()
        initializeBottomNavigate()
    }

    private fun initializeToolBar() {
        activity.setSupportActionBar(binding.toolbar.myToolbar)
        activity.supportActionBar?.title = ""
    }

    private fun initializeBottomNavigate() {
        //initial the first fragment
        replaceFragment(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.getItemId()) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.nav_movie -> {
                    replaceFragment(MovieFragment())
                    true
                }
                R.id.nav_channel -> {
                    replaceFragment(ChannelFragment())
                    true
                }
                R.id.nav_more -> {
                    replaceFragment(UserFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}