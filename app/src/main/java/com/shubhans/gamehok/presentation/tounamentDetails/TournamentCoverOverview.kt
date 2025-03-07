package com.shubhans.gamehok.presentation.tounamentDetails

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shubhans.gamehok.R
import com.shubhans.gamehok.presentation.components.GameHokImage
import com.shubhans.gamehok.presentation.components.RegistrationStatus
import com.shubhans.gamehok.presentation.components.TournamentInfo
import com.shubhans.gamehok.presentation.theme.ButtonSurface
import com.shubhans.gamehok.presentation.theme.DarkBackground
import com.shubhans.gamehok.presentation.theme.TextGrey
import com.shubhans.gamehok.presentation.theme.TextWhite

@Composable
fun TournamentCoverOverview(
    tournamentInfo: TournamentInfo,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBackground)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Tournament Banner Image with Overlay
            Box(modifier = Modifier.fillMaxWidth()) {
                GameHokImage(
                    imageRes = tournamentInfo.backgroundImage,
                    contentDescription = tournamentInfo.game,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(300.dp)
                )
                // Top Bar with Back and Share buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .background(Color(0xFF011C0D).copy(alpha = 0.4f), CircleShape)
                            .size(40.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }

                    IconButton(
                        onClick = onShareClick,
                        modifier = Modifier
                            .background(ButtonSurface, CircleShape)
                            .size(40.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_share),
                            contentDescription = "Share",
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                }

                // Tournament Info Overlay
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .background(Color.Transparent)
                        .padding(16.dp)
                ) {
                    // Registration Time and Players Count
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RegistrationStatusBadge(
                            status = tournamentInfo.registrationStatus
                        )

                        Surface(
                            color = Color(0xFF001208).copy(alpha = 0.8f),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 18.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Groups,
                                    contentDescription = "Players",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "${tournamentInfo.currentPlayers}/${tournamentInfo.maxPlayers}",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = TextWhite,
                                    fontWeight = FontWeight(400)
                                )
                            }
                        }
                    }
                }
            }
            // Tournament Title and Organizer
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = tournamentInfo.game,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        fontWeight = FontWeight(700),
                    )
                    Text(
                        text = "By ${tournamentInfo.organizer}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.8f),
                        fontWeight = FontWeight(600),
                    )
                }

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(TextWhite, CircleShape)
                ) {
                    GameHokImage(
                        imageRes = tournamentInfo.organizerLogo,
                        contentDescription = "Organizer Logo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )
                }
            }

            // Game Tags Items
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    color = ButtonSurface,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = tournamentInfo.gameName,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                    )
                }

                Surface(
                    color = ButtonSurface,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "Entry-${tournamentInfo.entryFee}",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_coin_home),
                            contentDescription = "Entry fee",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Navigation Tabs
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkBackground)
            ) {
                var selectedTab = 0  // 0 for Overview
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    val tabs = listOf("Overview", "Players", "Rules")
                    tabs.forEachIndexed { index, tab ->
                        Text(
                            text = tab,
                            color = if (index == selectedTab) TextWhite else TextGrey,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                    }
                }

                // Bottom divider with indicator
                Box(modifier = Modifier.fillMaxWidth()) {
                    // Gray divider line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(Color.Gray.copy(alpha = 0.2f))
                    )

                    // Green indicator for selected tab
                    Box(
                        modifier = Modifier
                            .width(180.dp)
                            .height(3.dp)
                            .background(Color(0xFF00B167))
                    )
                }
            }

            // Details Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Details",
                    style = MaterialTheme.typography.titleLarge,
                    color = TextWhite,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Team Size
                DetailItem(
                    icon = R.drawable.ic_team,
                    label = "TEAM SIZE",
                    value = tournamentInfo.gameMode
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Format
                DetailItem(
                    icon = R.drawable.ic_connect,
                    label = "FORMAT",
                    value = "Single Elimination"
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Tournament Start
                DetailItem(
                    icon = R.drawable.ic_calender,
                    label = "TOURNAMENT STARTS",
                    value = tournamentInfo.startTime
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Check-in
                DetailItem(
                    icon = R.drawable.ic_time,
                    label = "CHECK-IN",
                    value = "10 mins before the match starts"
                )
            }
        }
    }
}

@Composable
fun RegistrationStatusBadge(
    status: RegistrationStatus,
    modifier: Modifier = Modifier
) {
    val (backgroundColor, text) = when (status) {
        RegistrationStatus.OPEN -> Color(0xFF00B167) to "Registration Open • 2hr 32min"
        RegistrationStatus.CLOSED -> Color.Red to "Registration Closed"
        RegistrationStatus.OPENING_SOON -> Color(0xFF001208).copy(0.8f) to "Registration Opens in 2d 15h 10m"
    }
    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
    ) {
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 6.dp)
        )
    }
}

@Composable
fun DetailItem(
    @DrawableRes icon: Int,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color(0xFF00B167),
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = label,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFFA8A8A8)
            )
            Text(
                text = value,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite
            )
        }
    }
}
