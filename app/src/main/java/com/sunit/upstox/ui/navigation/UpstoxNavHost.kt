package com.sunit.upstox.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sunit.upstox.feature.portfolio.ui.PortfolioScreen

@Composable
fun UpstoxNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = TopLevelDestination.PORTFOLIIO.route,
        modifier = modifier
    ) {
        composable(route = TopLevelDestination.PORTFOLIIO.route) {
            PortfolioScreen()
        }
    }
}
