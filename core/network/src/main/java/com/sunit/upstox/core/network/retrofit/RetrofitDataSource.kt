package com.sunit.upstox.core.network.retrofit

import com.sunit.upstox.core.network.NetworkDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitDataSource @Inject constructor(
    api: Api
) : NetworkDataSource {
    override suspend fun getPortfolio() {
        TODO("Not yet implemented")
    }
}
