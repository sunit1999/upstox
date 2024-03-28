package com.sunit.upstox.core.network.retrofit

import retrofit2.http.GET

interface Api {
    @GET
    suspend fun getPortfolio()
}
