package com.example.kotlin2lesson2.di

import com.example.kotlin2lesson2.data.repository.everthing.EverythingRepositoriesImpl
import com.example.kotlin2lesson2.data.repository.topnews.TopNewsRepositoriesImpl
import com.example.kotlin2lesson2.domain.repository.everthing.EverythingRepositories
import com.example.kotlin2lesson2.domain.repository.topNews.TopNewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun provideTopNewsRepository(
        topHeadlinesInTheUSRepositoriesImpl: TopNewsRepositoriesImpl,
    ): TopNewsRepository

    @Binds
    abstract fun provideEverythingRepositories(
        everythingRepositoriesImpl: EverythingRepositoriesImpl,
    ): EverythingRepositories
}