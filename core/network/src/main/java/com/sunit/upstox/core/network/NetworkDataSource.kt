package com.sunit.upstox.core.network

interface NetworkDataSource {
    suspend fun getPortfolio()
}
