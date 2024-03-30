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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Summary(
    modifier: Modifier = Modifier
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.animateContentSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
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
            SummaryField(key = "Current value:", value = "78900.00")
            SummaryField(key = "Total investment:", value = "32474.68")
            SummaryField(key = "Today’s Profit & Loss:", value = "-9637.15")
        }
        SummaryField(
            key = "Profit & Loss:",
            value = "46425.32",
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
        Text(text = "$ $value")
    }
}
