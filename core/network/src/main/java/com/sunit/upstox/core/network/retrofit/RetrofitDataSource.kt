package com.sunit.upstox.core.network.retrofit

import com.sunit.upstox.core.model.Portfolio
import com.sunit.upstox.core.network.NetworkDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitDataSource @Inject constructor(
    private val api: UpstoxApi
) : NetworkDataSource {
    override suspend fun getPortfolio(): Portfolio {
        return api.getPortfolio()
    }
}
