package com.sunit.upstox.core.data.di

import com.sunit.upstox.core.data.repository.PortfolioRepository
import com.sunit.upstox.core.data.repository.PortfolioRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindPortfolioRepository(
        repository: PortfolioRepositoryImpl
    ): PortfolioRepository
}
