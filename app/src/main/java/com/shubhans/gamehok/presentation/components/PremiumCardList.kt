package com.shubhans.gamehok.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubhans.gamehok.presentation.theme.ButtonGreen
import com.shubhans.gamehok.presentation.theme.ButtonOrange
import com.shubhans.gamehok.presentation.theme.GamehokTheme.premiumGradient
import com.shubhans.gamehok.presentation.theme.TextBlack
import com.shubhans.gamehok.presentation.theme.TextGrey
import com.shubhans.gamehok.presentation.theme.TextWhite
import com.shubhans.gamehok.presentation.utils.TrapezoidShape

@Composable
fun PremiumCardList(modifier: Modifier = Modifier) {
    val lazyListState = rememberLazyListState()

    val currentPage = remember {
        derivedStateOf {
            val firstVisibleItem = lazyListState.firstVisibleItemIndex
            val centerOffset = lazyListState.firstVisibleItemScrollOffset
            val itemSize = lazyListState.layoutInfo.visibleItemsInfo.firstOrNull()?.size ?: 0

            if (centerOffset > itemSize / 2) firstVisibleItem + 1 else firstVisibleItem
        }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            state = lazyListState,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(3) { index ->
                Box(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(end = if (index < 4) 16.dp else 0.dp)
                ) {
                    PremiumFeatureCard(
                        title = "Gamehok",
                        description = when (index) {
                            0 -> "Upgrade to premium membership and get 100 🎟️ and many other premium features."
                            1 -> "Access exclusive tournaments and win premium rewards!"
                            else -> "Join premium gaming communities"
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(3) { index ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(8.dp)
                        .background(
                            color = if (currentPage.value == index)
                                TextWhite
                            else TextGrey,
                            shape = CircleShape
                        )
                )
            }
        }
    }
}

@Composable
fun PremiumFeatureCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF8DC)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight(700),
                        color = TextBlack
                    )
                    val shape = TrapezoidShape()
                    Surface(
                        modifier = modifier
                            .clip(shape)
                            .clip(RoundedCornerShape(6.dp))
                            .background(premiumGradient),
                        color = Color.Transparent
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 2.dp)
                                .height(24.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Premium",
                                color = TextBlack,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Button(
                    onClick = {},
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ButtonOrange
                    ),
                    contentPadding = PaddingValues(horizontal = 18.dp, vertical = 6.dp)
                ) {
                    Text(
                        fontSize = 18.sp,
                        text = "Get Now",
                        style = MaterialTheme.typography.labelLarge,
                        color = Color.White,
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                fontSize = 14.sp,
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = TextBlack,
                fontWeight = FontWeight(500),
                modifier = Modifier.weight(1f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "View All Feature",
                    style = MaterialTheme.typography.labelLarge,
                    color = ButtonGreen
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "View all",
                    tint = ButtonGreen,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
