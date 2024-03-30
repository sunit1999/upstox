package com.sunit.upstox.feature.portfolio.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunit.upstox.core.data.repository.PortfolioRepository
import com.sunit.upstox.core.model.Portfolio
import com.sunit.upstox.feature.portfolio.ui.models.PortfolioUiState
import com.sunit.upstox.feature.portfolio.ui.models.PortfolioUiSuccessState
import com.sunit.upstox.feature.portfolio.ui.models.UserHoldingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    val portfolioRepository: PortfolioRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PortfolioUiState>(PortfolioUiState.Loading)
    val uiState: StateFlow<PortfolioUiState> = _uiState

    fun getPortfolio() {
        viewModelScope.launch {
            val result = portfolioRepository.getPortfolio()
            _uiState.value = result.fold(
                onSuccess = ::onGetPortfolioSuccess,
                onFailure = { PortfolioUiState.Error }
            )
        }
    }

    private fun onGetPortfolioSuccess(portfolio: Portfolio): PortfolioUiState.Success {
        val holdings = portfolio.data.userHolding.map { userHolding ->
            UserHoldingUiState(
                avgPrice = userHolding.avgPrice,
                close = userHolding.close,
                ltp = userHolding.ltp,
                quantity = userHolding.quantity,
                symbol = userHolding.symbol
            )
        }

        return PortfolioUiState.Success(
            PortfolioUiSuccessState(holdings)
        )
    }
}
