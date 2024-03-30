package com.sunit.upstox.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Portfolio(
    val data: Data
)

@Serializable
data class Data(
    val userHolding: List<UserHolding>
)

@Serializable
data class UserHolding(
    val avgPrice: Double,
    val close: Double,
    val ltp: Double,
    val quantity: Int,
    val symbol: String
)
