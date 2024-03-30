package com.sunit.upstox.core.network

import com.sunit.upstox.core.network.models.Portfolio

interface NetworkDataSource {
    suspend fun getPortfolio(): Portfolio
}
