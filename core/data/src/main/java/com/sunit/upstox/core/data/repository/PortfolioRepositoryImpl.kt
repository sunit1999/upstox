package com.sunit.upstox.core.data.repository

import com.sunit.upstox.core.data.util.suspendRunCatching
import com.sunit.upstox.core.network.NetworkDataSource
import com.sunit.upstox.core.network.models.Portfolio
import javax.inject.Inject

class PortfolioRepositoryImpl @Inject constructor(
    val dataSource: NetworkDataSource
) : PortfolioRepository {
    override suspend fun getPortfolio(): Result<Portfolio> {
        return suspendRunCatching {
            dataSource.getPortfolio()
        }
    }
}
