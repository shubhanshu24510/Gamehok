package com.shubhans.gamehok.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shubhans.gamehok.R
import com.shubhans.gamehok.presentation.theme.LineGrey
import com.shubhans.gamehok.presentation.theme.LinearGreen
import com.shubhans.gamehok.presentation.theme.TextWhite

@Composable
fun GameSection(
    navController: NavController,
    onViewAllClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Play Tournament by Games",
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite
            )

            Text(
                text = "View All",
                style = MaterialTheme.typography.bodyMedium,
                color = LinearGreen,
                modifier = Modifier.clickable { onViewAllClick() }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            GameCard(
                gameImage = R.drawable.ic_bgmi_player,
                gameName = "PUBG",
                onClick = {
//                    navController.navigate(
//                        Screens.GameDetail.route.replace(
//                            "{gameId}",
//                            "1"
//                        )
//                    )
                }
            )
            GameCard(
                gameImage = R.drawable.ic_call_duty,
                gameName = "Call of Duty",
                onClick = {
//                    navController.navigate(
//                        Screens.GameDetail.route.replace(
//                            "{gameId}",
//                            "2"
//                        )
//                    )
                }
            )
            GameCard(
                gameImage = R.drawable.ic_counter_strike,
                gameName = "Counter Strike",
                onClick = {
//                    navController.navigate(
//                        Screens.GameDetail.route.replace(
//                            "{gameId}",
//                            "3"
//                        )
//                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(1.dp)
                .background(LineGrey)
        )
    }
}

@Composable
fun GameCard(
    modifier: Modifier = Modifier,
    gameImage: Int,
    gameName: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .width(110.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.1f)
            )
        ) {
            Image(
                painter = painterResource(id = gameImage),
                contentDescription = gameName,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = gameName,
            style = MaterialTheme.typography.bodyMedium,
            color = TextWhite,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
