package com.shubhans.gamehok.presentation.tounamentDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shubhans.gamehok.presentation.theme.DarkBackground
import com.shubhans.gamehok.presentation.theme.TextDescription
import com.shubhans.gamehok.presentation.theme.TextWhite

@Composable
fun HowToJoinSection(
    onJoinClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = DarkBackground
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Title
            Text(
                text = "How to Join a Match",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFECECEC),
                fontWeight = FontWeight(700)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Bullet points
            BulletPoint(
                text = "Have your game open already and on the latest version"
            )

            Spacer(modifier = Modifier.height(8.dp))

            BulletPoint(
                text = "Once the match is configured you will receive an invite in-game to join the lobby."
            )
            Spacer(modifier = Modifier.height(8.dp))
            BulletPoint(
                text = "Join the match and wait for the game to start."
            )
            Spacer(modifier = Modifier.height(8.dp))
            BulletPoint(
                text = "When eliminated return to the match room page to be ready to join the next map in the round."
            )
        }
    }
}

@Composable
private fun BulletPoint(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "•",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFFBCBCBC),
            modifier = Modifier.padding(end = 8.dp),
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFFBCBCBC),
            fontWeight = FontWeight(400)
        )
    }
}