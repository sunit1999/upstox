package com.sunit.upstox.feature.portfolio.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sunit.upstox.feature.portfolio.ui.composable.StockList
import com.sunit.upstox.feature.portfolio.ui.composable.Summary
import com.sunit.upstox.feature.portfolio.ui.models.PortfolioUiSuccessState

@Composable
fun PortfolioScreen(
    portfolioUiState: PortfolioUiSuccessState,
    modifier: Modifier = Modifier
) {
    Scaffold(
        bottomBar = {
            Summary(
                portfolioUiState = portfolioUiState
            )
        },
        modifier = modifier.padding(horizontal = 16.dp)
    ) { padding ->
        StockList(
            portfolioUiState = portfolioUiState,
            modifier = modifier
                .fillMaxWidth()
                .padding(padding)
        )
    }
}
