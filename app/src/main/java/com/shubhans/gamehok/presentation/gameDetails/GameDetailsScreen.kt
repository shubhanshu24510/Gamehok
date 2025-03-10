package com.shubhans.gamehok.presentation.gameDetails

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Group
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shubhans.gamehok.R
import com.shubhans.gamehok.domain.GameStats
import com.shubhans.gamehok.domain.TournamentInfo
import com.shubhans.gamehok.presentation.components.GameHokImage
import com.shubhans.gamehok.presentation.components.RegistrationStatus
import com.shubhans.gamehok.presentation.components.TournamentCard
import com.shubhans.gamehok.presentation.theme.DarkBackground
import com.shubhans.gamehok.presentation.theme.Green
import com.shubhans.gamehok.presentation.theme.PrizeGreen

@Composable
fun GameDetailsScreen(
    gameId: Int,
    onBackClick: () -> Unit,
    onTournamentClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val gameImage = when (gameId) {
        1 -> R.drawable.ic_bgmi_player
        2 -> R.drawable.ic_call_duty
        else -> R.drawable.ic_counter_strike
    }

    val gameName = when (gameId) {
        1 -> "PUBG"
        2 -> "Call of Duty"
        else -> "Counter Strike"
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBackground)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                GameBanner(
                    gameImage = gameImage,
                    gameName = gameName,
                    onBackClick = onBackClick
                )
            }
            item {
                QuickStats()
            }
            item {
                Text(
                    text = "Active Tournaments",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            }

            item {
                ActiveTournaments(onTournamentClick = onTournamentClick)
            }
            item {
                AchievementsSection()
            }
            item {
                GameTipsSection()
            }
        }
    }
}

@Composable
private fun GameBanner(
    gameImage: Int,
    gameName: String,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        GameHokImage(
            imageRes = gameImage,
            contentDescription = gameName,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Black.copy(alpha = 0.5f), CircleShape)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }
        Text(
            text = gameName,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )
    }
}

@Composable
private fun QuickStats() {
    val stats = listOf(
        GameStats("Active Players", "2.5M", R.drawable.ic_group),
        GameStats("Tournaments", "156", R.drawable.ic_trophy),
        GameStats("Prize Pool", "250K", R.drawable.ic_coin)
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = PrizeGreen
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            stats.forEach { stat ->
                StatItem(stat = stat)
            }
        }
    }
}

@Composable
private fun StatItem(stat: GameStats) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = stat.icon),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = stat.value,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stat.label,
            style = MaterialTheme.typography.bodySmall,
            color = Color.White.copy(alpha = 0.7f)
        )
    }
}

@Composable
private fun ActiveTournaments(
    onTournamentClick: (String) -> Unit
) {
    val tournaments = remember {
        listOf(
            TournamentInfo(
                game = "Weekend Warriors",
                organizer = "ESL",
                registrationStatus = RegistrationStatus.OPEN,
                currentPlayers = 450,
                maxPlayers = 500,
                gameMode = "Squad",
                gameName = "PUBG",
                entryFee = 20,
                startTime = "This Weekend",
                prizePool = 5000,
                backgroundImage = R.drawable.pubg_tournament,
                organizerLogo = R.drawable.ic_red_bull
            ),
        )
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(tournaments) { tournament ->
            TournamentCard(
                tournamentInfo = tournament,
                onTournamentClick = onTournamentClick
            )
        }
    }
}


@Composable
private fun AchievementsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Achievements",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AchievementCard(
                title = "Win 10 Matches",
                progress = 0.7f,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            AchievementCard(
                title = "Top 10 Finishes",
                progress = 0.4f,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun AchievementCard(
    title: String,
    progress: Float,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = DarkBackground
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth(),
                color = Green,
                trackColor = Color.White.copy(alpha = 0.1f),
            )
            Text(
                text = "${(progress * 100).toInt()}%",
                style = MaterialTheme.typography.bodyMedium,
                color = Green
            )
        }
    }
}

@Composable
private fun GameTipsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Pro Tips",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            colors = CardDefaults.cardColors(
                containerColor = PrizeGreen
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                TipItem(
                    tip = "Master recoil control for better accuracy",
                    number = 1
                )
                Spacer(modifier = Modifier.height(8.dp))
                TipItem(
                    tip = "Always keep moving to avoid being an easy target",
                    number = 2
                )
                Spacer(modifier = Modifier.height(8.dp))
                TipItem(
                    tip = "Communicate effectively with your team",
                    number = 3
                )
            }
        }
    }
}

@Composable
private fun TipItem(
    tip: String,
    number: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            shape = CircleShape,
            color = Green
        ) {
            Text(
                text = number.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = tip,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }
}
