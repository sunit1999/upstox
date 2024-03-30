package com.sunit.upstox.feature.portfolio.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StockList(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(15) { stock ->
            StockRow(modifier = Modifier.fillMaxWidth())
            HorizontalDivider()
        }
    }
}

@Composable
fun StockRow(
    modifier: Modifier = Modifier
) {
    val ltp = "200.15"
    val annotatedString = buildAnnotatedString {
        val str = "LTP: ₹ $ltp"
        val startIndex = str.indexOf(ltp)
        val endIndex = startIndex + ltp.length
        append(str)
        addStyle(
            style = SpanStyle(fontWeight = FontWeight.Bold),
            start = startIndex,
            end = endIndex
        )
    }

    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
        ) {
            Text(text = "BANDHANBANK", fontWeight = FontWeight.Bold)
            Text(text = annotatedString)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
        ) {
            Text(text = "575")
            Text(text = "P/L: $ -749.70")
        }
    }
}

