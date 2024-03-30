package com.sunit.upstox.core.network.di

import com.sunit.upstox.core.network.NetworkDataSource
import com.sunit.upstox.core.network.retrofit.RetrofitDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkDataSourceModule {

    @Binds
    fun bindNetworkDataSource(
        dataSource: RetrofitDataSource
    ): NetworkDataSource
}
