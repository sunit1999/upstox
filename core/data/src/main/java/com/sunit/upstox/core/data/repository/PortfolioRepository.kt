package com.sunit.upstox.core.data.repository

import com.sunit.upstox.core.model.Portfolio

interface PortfolioRepository {
    suspend fun getPortfolio(): Result<Portfolio>
}
