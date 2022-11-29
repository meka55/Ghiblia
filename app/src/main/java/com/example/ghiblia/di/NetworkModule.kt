package com.example.ghiblia.di

import com.example.ghiblia.data.remote.RetrofitClient
import com.example.ghiblia.data.remote.apiservices.GhibliaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    private var retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideGhibliaApi(): GhibliaApi {
        return retrofitClient.provideGhibliaApi()
    }
}