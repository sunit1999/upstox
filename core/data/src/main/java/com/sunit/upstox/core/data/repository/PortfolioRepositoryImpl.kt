package com.sunit.upstox.core.data.repository

import com.sunit.upstox.core.data.util.suspendRunCatching
import com.sunit.upstox.core.model.Portfolio
import com.sunit.upstox.core.network.NetworkDataSource
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
