package com.shubhans.gamehok.presentation.tounamentDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shubhans.gamehok.presentation.theme.PrizeGreen
import com.shubhans.gamehok.R
import com.shubhans.gamehok.presentation.theme.ButtonGreen
import com.shubhans.gamehok.presentation.theme.ButtonSurface
import com.shubhans.gamehok.presentation.theme.Green
import com.shubhans.gamehok.presentation.theme.LinearGreen

data class PrizeInfo(
    val position: String,
    val amount: Int
)

@Composable
fun TournamentPrizeSection(
    totalPrize: Int,
    prizes: List<PrizeInfo>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Green.copy(alpha = 0.1f),
        ),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Total Prize Row
            PrizeRow(
                title = "Total Tournament Prize",
                amount = totalPrize,
                isTotal = true
            )

            // Divider after total
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                color = Color(0xFF001208)
            )

            // Individual prize rows
            prizes.forEachIndexed { index, prize ->
                PrizeRow(
                    title = prize.position,
                    amount = prize.amount
                )

                if (index < prizes.size - 1) {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        color = Color(0xFF001208)
                    )
                }
            }
        }
    }
}

@Composable
private fun PrizeRow(
    modifier: Modifier = Modifier,
    title: String,
    amount: Int,
    isTotal: Boolean = false
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (!isTotal) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cup),
                    contentDescription = null,
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(24.dp)
                )
            }
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = if (isTotal) FontWeight.Bold else FontWeight.Normal,
                color = Color.White
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = amount.toString(),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = if (isTotal) FontWeight.Bold else FontWeight.Normal,
                color = Color.White
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_g_logo),
                contentDescription = "coins",
                tint = Color.Unspecified,
                modifier = if (isTotal) Modifier.size(22.dp) else Modifier.size(18.dp)
            )
        }
    }
}