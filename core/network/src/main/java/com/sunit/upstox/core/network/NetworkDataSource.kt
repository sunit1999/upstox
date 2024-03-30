package com.sunit.upstox.core.network

import com.sunit.upstox.core.model.Portfolio

interface NetworkDataSource {
    suspend fun getPortfolio(): Portfolio
}
