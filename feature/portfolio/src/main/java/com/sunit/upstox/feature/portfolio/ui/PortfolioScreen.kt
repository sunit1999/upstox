package com.sunit.upstox.feature.portfolio.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sunit.upstox.feature.portfolio.ui.composable.StockList
import com.sunit.upstox.feature.portfolio.ui.composable.Summary

@Composable
fun PortfolioScreen(
    modifier: Modifier = Modifier,
    viewModel: PortfolioViewModel = hiltViewModel()
) {
    Scaffold(
        bottomBar = {
            Summary(
                modifier = modifier
                    .padding(horizontal = 16.dp)
            )
        }
    ) { padding ->
        StockList(
            modifier = modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
        )
    }
}
