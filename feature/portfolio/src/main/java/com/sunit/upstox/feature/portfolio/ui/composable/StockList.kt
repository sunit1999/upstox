package com.sunit.upstox.feature.portfolio.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sunit.upstox.feature.portfolio.R
import com.sunit.upstox.feature.portfolio.ui.models.PortfolioUiSuccessState
import com.sunit.upstox.feature.portfolio.ui.models.UserHoldingUiState

@Composable
fun StockList(
    portfolioUiState: PortfolioUiSuccessState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items = portfolioUiState.holdings, key = { it.symbol }) {
            StockRow(stock = it, modifier = Modifier.fillMaxWidth())
            HorizontalDivider()
        }
    }
}

@Composable
fun StockRow(
    stock: UserHoldingUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
        ) {
            Text(text = stock.symbol, fontWeight = FontWeight.Bold)
            Text(
                text = createAnnotatedString(
                    firstPart = stringResource(id = R.string.ltp),
                    secondPart = stringResource(id = R.string.amount_decimal_format, stock.ltp)
                )
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
        ) {
            Text(text = stock.quantity.toString())
            Text(
                text = createAnnotatedString(
                    firstPart = stringResource(id = R.string.p_and_l),
                    secondPart = stringResource(id = R.string.amount_decimal_format, stock.pAndL)
                )
            )
        }
    }
}

@Composable
fun createAnnotatedString(firstPart: String, secondPart: String): AnnotatedString {
    return buildAnnotatedString {
        append("$firstPart ")
        pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
        append(secondPart)
        pop()
    }
}
