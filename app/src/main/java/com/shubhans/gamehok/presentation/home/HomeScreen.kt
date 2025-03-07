package com.shubhans.gamehok.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.shubhans.gamehok.presentation.components.CourseSection
import com.shubhans.gamehok.presentation.components.GameAppBar
import com.shubhans.gamehok.presentation.components.GameNavBar
import com.shubhans.gamehok.presentation.components.GameSection
import com.shubhans.gamehok.presentation.components.PeopleToFollowSection
import com.shubhans.gamehok.presentation.components.PremiumCardList
import com.shubhans.gamehok.presentation.components.TournamentInfo
import com.shubhans.gamehok.presentation.components.TournamentSection
import com.shubhans.gamehok.presentation.theme.GamehokTheme
import com.shubhans.gamehok.presentation.theme.TextWhite

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    tournaments: List<TournamentInfo>,
    onTournamentClick: (String) -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            //TOP PROFILE BAR
            GameAppBar()

            //CONTENT
            LazyColumn(
                modifier = modifier
                    .weight(1f)
                    .fillMaxWidth(),
                state = rememberLazyListState(),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                item { PremiumCardList() }
                item {
                    GameSection(
                        navController = navController,
                        onViewAllClick = {})
                }
                item {
                    TournamentSection(
                        title = "Compete in Battles",
                        tournaments = tournaments,
                        onViewAllClick = {},
                        onTournamentClick = onTournamentClick
                    )
                }
                item { PeopleToFollowSection(onViewMoreClick = {}) }
            }

            //BOTTOM NAVIGATION BAR
            GameNavBar(
                modifier = Modifier.navigationBarsPadding()
            )
        }
    }
}
