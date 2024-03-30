package com.sunit.upstox.feature.portfolio.ui.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sunit.upstox.feature.portfolio.R
import com.sunit.upstox.feature.portfolio.ui.models.PortfolioUiSuccessState

@Composable
fun Summary(
    portfolioUiState: PortfolioUiSuccessState,
    modifier: Modifier = Modifier,
) {
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.animateContentSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            if (isExpanded)
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.clickable { isExpanded = !isExpanded }
                )
            else
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = null,
                    modifier = Modifier.clickable { isExpanded = !isExpanded }
                )
        }
        if (isExpanded) {
            SummaryField(
                key = stringResource(id = R.string.current_value),
                value = stringResource(
                    id = R.string.amount_decimal_format,
                    portfolioUiState.totalCurrentValue
                )
            )
            SummaryField(
                key = stringResource(id = R.string.total_investment),
                value = stringResource(
                    id = R.string.amount_decimal_format,
                    portfolioUiState.totalInvestment
                )
            )
            SummaryField(
                key = stringResource(id = R.string.todays_p_and_l),
                value = stringResource(
                    id = R.string.amount_decimal_format,
                    portfolioUiState.todayPAndL
                )
            )
        }
        SummaryField(
            key = stringResource(id = R.string.total_p_and_l),
            value = stringResource(
                id = R.string.amount_decimal_format,
                portfolioUiState.totalPAndL
            ),
            modifier = Modifier.padding(top = if (isExpanded) 16.dp else 0.dp)
        )
    }
}

@Composable
fun SummaryField(
    key: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = key, fontWeight = FontWeight.Bold)
        Text(text = value)
    }
}
