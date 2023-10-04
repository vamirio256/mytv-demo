package com.example.mytv_demo.di

import android.content.Context
import com.example.mytv_demo.base.BaseApi
import com.example.mytv_demo.data.db.ChannelDatabase
import com.example.mytv_demo.data.repositories.ChannelRepository
import com.example.mytv_demo.domain.apis.ChannelApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideChannelRepo(
        api: ChannelApi,
        @ApplicationContext context: Context
    ): ChannelRepository {
        return ChannelRepository(ChannelDatabase.invoke(context), api)
    }
}