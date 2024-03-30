package com.sunit.upstox.feature.portfolio.ui.models

data class PortfolioUiSuccessState(
    val holdings: List<UserHoldingUiState>
) {
    val totalCurrentValue: Double
        get() = holdings.sumOf { it.currentValue }

    val totalInvestment: Double
        get() = holdings.sumOf { it.investmentValue }

    val totalPAndL: Double
        get() = totalCurrentValue - totalInvestment

    val todayPAndL: Double
        get() = holdings.sumOf {
            (it.close - it.ltp) * it.quantity
        }
}

data class UserHoldingUiState(
    val avgPrice: Double,
    val close: Double,
    val ltp: Double,
    val quantity: Int,
    val symbol: String
) {
    val currentValue: Double
        get() = ltp * quantity

    val investmentValue: Double
        get() = avgPrice * quantity

    val pAndL: Double
        get() = currentValue - investmentValue
}

sealed interface PortfolioUiState {
    data object Loading : PortfolioUiState

    data class Success(
        val data: PortfolioUiSuccessState
    ) : PortfolioUiState

    data object Error : PortfolioUiState
}
