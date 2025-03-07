package com.shubhans.gamehok.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubhans.gamehok.R
import com.shubhans.gamehok.domain.TournamentInfo
import com.shubhans.gamehok.presentation.theme.BorderColor
import com.shubhans.gamehok.presentation.theme.ButtonGreen
import com.shubhans.gamehok.presentation.theme.ButtonSurface
import com.shubhans.gamehok.presentation.theme.DarkBackground
import com.shubhans.gamehok.presentation.theme.GamehokTheme
import com.shubhans.gamehok.presentation.theme.GamehokTheme.primaryGradient
import com.shubhans.gamehok.presentation.theme.GamehokTheme.tournamentGradient
import com.shubhans.gamehok.presentation.theme.LinearGreen
import com.shubhans.gamehok.presentation.theme.TextWhite
import com.shubhans.gamehok.presentation.theme.TitleWhite
import com.shubhans.gamehok.presentation.theme.TournamentGreen
import java.util.UUID

enum class RegistrationStatus {
    OPEN,
    CLOSED,
    OPENING_SOON
}

@Composable
fun TournamentSection(
    title: String,
    tournaments: List<TournamentInfo>,
    modifier: Modifier = Modifier,
    onViewAllClick: () -> Unit,
    onTournamentClick: (String) -> Unit
) {
    val lazyListState = rememberLazyListState()
    val flingBehavior = rememberSnapperFlingBehavior(lazyListState)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = TitleWhite,
                letterSpacing = 0.5.sp
            )
            Text(
                text = "View All",
                style = MaterialTheme.typography.bodyMedium,
                color = LinearGreen,
                modifier = Modifier.clickable { onViewAllClick() }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            state = lazyListState,
            flingBehavior = flingBehavior,
            modifier = Modifier.snapToCenter(lazyListState),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(
                count = tournaments.size,
                key = { index -> tournaments[index].id }
            ) { index ->
                TournamentCard(
                    tournamentInfo = tournaments[index],
                    onTournamentClick = onTournamentClick,
                    modifier = Modifier.animateItem(fadeInSpec = null, fadeOutSpec = null)
                )
            }
        }
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun TournamentCard(
    tournamentInfo: TournamentInfo,
    onTournamentClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val cardModifier = remember(modifier) {
        modifier.width(300.dp)
    }

    val statusColor = remember(tournamentInfo.registrationStatus) {
        when (tournamentInfo.registrationStatus) {
            RegistrationStatus.OPEN -> ButtonGreen
            RegistrationStatus.CLOSED -> Color.Red
            RegistrationStatus.OPENING_SOON -> Color.Gray
        }
    }

    Card(
        modifier = cardModifier.clickable { onTournamentClick(tournamentInfo.id) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = BorderColor
        )
    ) {
        Column {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(primaryGradient)
            ) {
                GameHokImage(
                    imageRes = tournamentInfo.backgroundImage,
                    contentDescription = tournamentInfo.game,
                    modifier = modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Surface(
                        color = statusColor,
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = when (tournamentInfo.registrationStatus) {
                                RegistrationStatus.OPEN -> "Registration Open"
                                RegistrationStatus.CLOSED -> "Registration Closed"
                                RegistrationStatus.OPENING_SOON -> "Registration Opening Soon"
                            },
                            style = MaterialTheme.typography.labelMedium,
                            color = TextWhite,
                            letterSpacing = 0.5.sp,
                            modifier = modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }

                    Surface(
                        color = Color.Black.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            modifier = modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Groups,
                                contentDescription = "Players",
                                tint = TextWhite,
                                modifier = modifier.size(16.dp)
                            )
                            Text(
                                text = "${tournamentInfo.currentPlayers}/${tournamentInfo.maxPlayers}",
                                style = MaterialTheme.typography.labelMedium,
                                color = TextWhite
                            )
                        }
                    }
                }
                // Organizer Logo
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .padding(8.dp)
                        .align(Alignment.BottomEnd)
                        .background(Color.Transparent, CircleShape)
                ) {
                    GameHokImage(
                        imageRes = tournamentInfo.organizerLogo,
                        contentDescription = tournamentInfo.organizer,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                    )
                }
            }
            TournamentDetails(
                tournamentInfo = tournamentInfo,
                onTournamentClick = onTournamentClick
            )
        }
    }
}


@Composable
private fun TournamentDetails(
    tournamentInfo: TournamentInfo,
    onTournamentClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(tournamentGradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Game Name
            Text(
                text = tournamentInfo.game,
                fontWeight = FontWeight(600),
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite
            )
            //Organizer name
            Text(
                text = "By ${tournamentInfo.organizer}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight(500),
                color = TextWhite.copy(alpha = 0.7f)
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Game Mode and Entry Fee
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf(
                    tournamentInfo.gameName,
                    tournamentInfo.gameMode,
                ).forEach { text ->
                    Surface(
                        color = ButtonSurface,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = text,
                            color = TextWhite,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight(500),
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }
                Surface(
                    color = ButtonSurface,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "Entry-${tournamentInfo.entryFee}",
                            color = TextWhite,
                            fontWeight = FontWeight(500),
                            style = MaterialTheme.typography.bodySmall
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_coin_home),
                            contentDescription = "coins",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_timer),
                    contentDescription = "time",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Starts ${tournamentInfo.startTime}",
                    color = TextWhite,
                    fontWeight = FontWeight(400),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_thophy),
                        contentDescription = "prize",
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Prize Pool- ${tournamentInfo.prizePool}",
                        color = TextWhite,
                        fontWeight = FontWeight(400),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_coin_home),
                        contentDescription = "coins",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(16.dp)
                    )
                }

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "View details",
                    tint = LinearGreen,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onTournamentClick(tournamentInfo.id) }
                )
            }
        }
    }
}
