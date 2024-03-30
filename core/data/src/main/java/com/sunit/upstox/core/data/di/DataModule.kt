package com.sunit.upstox.core.data.di

import com.sunit.upstox.core.data.repository.PortfolioRepository
import com.sunit.upstox.core.data.repository.PortfolioRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindPortfolioRepository(
        repository: PortfolioRepositoryImpl
    ): PortfolioRepository
}
