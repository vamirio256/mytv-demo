package com.example.mytv_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mytv_demo.databinding.ActivityMainBinding
import com.example.mytv_demo.databinding.FragmentMainBinding
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

        // for session token
        val sharePreferences =
            androidx.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext)

        sharePreferences.edit().putString("token", "").commit()
        sharePreferences.getString("token", "")
    }
}

