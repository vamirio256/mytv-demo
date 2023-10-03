package com.example.mytv_demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mytv_demo.databinding.ActivityMainBinding
import com.example.mytv_demo.presentation.fragments.ChannelFragment
import com.example.mytv_demo.presentation.fragments.HomeFragment
import com.example.mytv_demo.presentation.fragments.MovieFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeToolBar()
        initializeBottomNavigate()

        // for session token
        val sharePreferences =
            androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext)

        sharePreferences.edit().putString("token", "").commit()
        sharePreferences.getString("token", "")
    }

    private fun initializeToolBar() {
        binding.myToolbar.title = null
        setSupportActionBar(binding.myToolbar)
    }

    private fun initializeBottomNavigate() {
        //initial the first fragment
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
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
                else -> {
                    false
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    private fun toast(context: String) {
        Toast.makeText(applicationContext, context, Toast.LENGTH_SHORT).show()
    }
}

