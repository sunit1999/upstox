package com.sunit.upstox.feature.portfolio.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunit.upstox.core.data.repository.PortfolioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) : ViewModel() {

    init {
        getPortfolio()
    }

    fun getPortfolio() {
        viewModelScope.launch {
            val portfolio = portfolioRepository.getPortfolio().getOrElse {
                println(it.message)
            }

            println(portfolio)
        }
    }
}
