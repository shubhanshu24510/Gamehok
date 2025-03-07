package com.shubhans.gamehok.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shubhans.gamehok.presentation.theme.ButtonGreen
import com.shubhans.gamehok.presentation.theme.ChatIcon
import com.shubhans.gamehok.presentation.theme.GamehokTheme
import com.shubhans.gamehok.presentation.theme.GamehokTheme.navigationGradient
import com.shubhans.gamehok.presentation.theme.HomeIcon
import com.shubhans.gamehok.presentation.theme.SocialIcon
import com.shubhans.gamehok.presentation.theme.TextWhite
import com.shubhans.gamehok.presentation.theme.TounaumentIcon

@Composable
fun GameNavBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = HomeIcon, contentDescription = "Home",
                    tint = ButtonGreen
                )
            },
            label = { Text("Home", color = TextWhite) },
            selected = true,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                indicatorColor = MaterialTheme.colorScheme.background
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = TounaumentIcon, contentDescription = "Tounaument Icon"
                )
            },
            label = { Text("Tournament") },
            selected = false,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                indicatorColor = MaterialTheme.colorScheme.background
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = SocialIcon, contentDescription = "Sicial Icon"
                )
            },
            label = { Text("Social") },
            selected = false,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                indicatorColor = MaterialTheme.colorScheme.background
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = ChatIcon, contentDescription = "Chat Icon"
                )
            },
            label = { Text("Chats") },
            selected = false,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                indicatorColor = MaterialTheme.colorScheme.background
            )
        )
    }
}

@Preview
@Composable
private fun BottomNavBarPreview() {
    GamehokTheme {
        GameNavBar()
    }
}
