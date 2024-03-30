package com.sunit.upstox.core.data.repository

import com.sunit.upstox.core.network.models.Portfolio

interface PortfolioRepository {
    suspend fun getPortfolio(): Result<Portfolio>
}
