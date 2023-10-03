package com.example.mytv_demo.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytv_demo.data.repositories.ChannelRepository
import com.example.mytv_demo.domain.models.APIResponse
import com.example.mytv_demo.domain.models.channels.Channel
import com.example.mytv_demo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ChannelViewModel @Inject constructor(
    private val channelRepo: ChannelRepository
) : ViewModel() {
    val channels: MutableLiveData<Resource<APIResponse<List<Channel>>>> = MutableLiveData()

    init{
        getAllChannels()
    }

    fun getAllChannels() = viewModelScope.launch {
        channels.postValue(Resource.Loading())
        val response = channelRepo.getAllChannels()
        channels.postValue(handleGetAllChannelsResponse(response))
    }

    private fun handleGetAllChannelsResponse(response: Response<APIResponse<List<Channel>>>): Resource<APIResponse<List<Channel>>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(message = response.message())
    }

    override fun onCleared() {
        super.onCleared()
    }
}