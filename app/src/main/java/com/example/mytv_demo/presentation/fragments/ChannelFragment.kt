package com.example.mytv_demo.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.mytv_demo.MainActivity
import com.example.mytv_demo.base.BaseFragment
import com.example.mytv_demo.databinding.FragmentChannelBinding
import com.example.mytv_demo.presentation.adapters.ChannelAdapter
import com.example.mytv_demo.presentation.viewmodels.ChannelViewModel
import com.example.mytv_demo.utils.Resource
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ChannelFragment : BaseFragment() {

    companion object {
        fun newInstance() = ChannelFragment()
    }

    lateinit var channelAdapter: ChannelAdapter
    lateinit var binding: FragmentChannelBinding
    val TAG = "ChannelFragment"

    private val channelViewModel: ChannelViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChannelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        channelViewModel.channels.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { channelResponse ->
                        channelAdapter.submitList(channelResponse.data)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "Error: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgessBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        binding.pbChannel.visibility = View.INVISIBLE
    }

    private fun showProgessBar() {
        binding.pbChannel.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        channelAdapter = ChannelAdapter()
        binding.rvChannel.apply {
            adapter = channelAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun foo() {
        TODO("Not yet implemented")
    }
}