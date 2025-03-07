package com.shubhans.gamehok.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shubhans.gamehok.R
import com.shubhans.gamehok.presentation.theme.ButtonGreen
import com.shubhans.gamehok.presentation.theme.GamehokTheme
import com.shubhans.gamehok.presentation.theme.Green
import com.shubhans.gamehok.presentation.theme.LinearGreen
import com.shubhans.gamehok.presentation.theme.TextWhite

@Composable
fun GameAppBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.padding(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile_icon),
                    contentDescription = "User Profile Image",
                    alignment = Alignment.Center,
                    modifier = modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(R.drawable.ic_profile_dot),
                    contentDescription = "Edit Icon",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(12.dp)
                        .background(Color.White, CircleShape)
                        .clip(CircleShape)
                        .border(0.5.dp, Color.White, CircleShape)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .background(
                            color = ButtonGreen,
                            shape = MaterialTheme.shapes.extraLarge
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_two_ticket),
                            contentDescription = "vouchers",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "245",
                            color = TextWhite,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .height(24.dp)
                            .width(1.dp)
                            .background(LinearGreen)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_coins),
                            contentDescription = "Coins",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "2456",
                            color = TextWhite,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                IconButton(
                    onClick = { /* Handle notification click */ },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Notifications",
                        tint = TextWhite
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = false)
@Composable
private fun TopAppBarPreview() {
    GamehokTheme {
        GameAppBar()
    }
}