package com.example.mytv_demo.di

import com.example.mytv_demo.base.BaseApi
import com.example.mytv_demo.domain.apis.ChannelApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun channelApiService(retrofit: Retrofit): BaseApi {
        return retrofit.create(BaseApi::class.java)
    }
}