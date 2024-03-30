package com.sunit.upstox.feature.portfolio.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sunit.upstox.feature.portfolio.ui.models.PortfolioUiState

@Composable
fun PortfolioRoute(
    modifier: Modifier = Modifier,
    viewModel: PortfolioViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) {
        viewModel.getPortfolio()
    }

    when (uiState) {
        is PortfolioUiState.Error -> Text(text = "Error")

        is PortfolioUiState.Loading -> CircularProgressIndicator(
            modifier = modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )

        is PortfolioUiState.Success -> PortfolioScreen(
            portfolioUiState = (uiState as PortfolioUiState.Success).data
        )
    }
}
