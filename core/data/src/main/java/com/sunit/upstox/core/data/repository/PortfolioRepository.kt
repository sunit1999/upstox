package com.sunit.upstox.core.data.repository

interface PortfolioRepository {
    suspend fun getPortfolio()
}
