package com.example.kotlin2lesson2.di

import com.example.kotlin2lesson2.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Provides
    @Singleton
    fun provideNewsApiService() = retrofitClient.provideNewsApiService()

    @Provides
    @Singleton
    fun provideEverythingApiService() = retrofitClient.provideEverythingApiService()
}