package com.shubhans.gamehok.presentation.tounamentDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shubhans.gamehok.domain.TournamentInfo
import com.shubhans.gamehok.presentation.components.TournamentSection
import com.shubhans.gamehok.presentation.theme.DarkBackground
import com.shubhans.gamehok.presentation.theme.GamehokTheme.bottomBarGradient
import com.shubhans.gamehok.presentation.theme.TextWhite

@Composable
fun TournamentDetailScreen(
    tournaments: List<TournamentInfo>,
    onTournamentClick: (String) -> Unit,
    tournamentInfo: TournamentInfo,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onJoinClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBackground)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                TournamentCoverOverview(
                    tournamentInfo = tournamentInfo,
                    onBackClick = onBackClick,
                    onShareClick = onShareClick
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                val prizes = listOf(
                    PrizeInfo("1st Prize", 1000),
                    PrizeInfo("2nd Prize", 500),
                    PrizeInfo("3rd Prize", 200),
                    PrizeInfo("4th Prize", 100),
                    PrizeInfo("5th Prize", 100)
                )
                TournamentPrizeSection(
                    totalPrize = 2000,
                    prizes = prizes,
                    modifier = Modifier
                        .background(DarkBackground)
                        .padding(horizontal = 16.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                RoundsAndScheduleSection(
                    tournamentInfo = tournamentInfo,
                    modifier = Modifier
                        .background(DarkBackground)
                        .padding(horizontal = 16.dp)
                )
            }

            item {
                HowToJoinSection(
                    onJoinClick = { /* Handle join click */ },
                    modifier = Modifier
                        .background(DarkBackground)
                        .padding(horizontal = 16.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
                OrgnizationContact()
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
                TournamentSection(
                    title = "More tournaments for you",
                    tournaments = tournaments,
                    onViewAllClick = {},
                    onTournamentClick = onTournamentClick
                )
            }

            item {
                Spacer(modifier = Modifier.height(50.dp))
                // Join Button
                Button(
                    onClick = onJoinClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF01B752),
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "JOIN TOURNAMENT",
                        style = MaterialTheme.typography.titleMedium,
                        color = TextWhite
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .shadow(elevation = 2.dp)
                        .background(bottomBarGradient)
                )
            }
        }
    }
}