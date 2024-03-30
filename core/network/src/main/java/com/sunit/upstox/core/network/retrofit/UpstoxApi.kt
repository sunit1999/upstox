package com.sunit.upstox.core.network.retrofit

import com.sunit.upstox.core.model.Portfolio
import retrofit2.http.GET

interface UpstoxApi {

    @GET("/")
    suspend fun getPortfolio(): Portfolio
}
