package com.shubhans.gamehok

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shubhans.gamehok.domain.TournamentInfo
import com.shubhans.gamehok.presentation.components.RegistrationStatus
import com.shubhans.gamehok.presentation.gameDetails.GameDetailsScreen
import com.shubhans.gamehok.presentation.home.HomeScreen
import com.shubhans.gamehok.presentation.tounamentDetails.TournamentDetailScreen

enum class Screens(val route: String) {
    Home("home"),
    TournamentDetail("tournament/{tournamentId}"),
    GameDetail("game/{gameId}")
}

@Composable
fun GameHokNavigation() {
    val navController = rememberNavController()

    //Sample API call to get the list of tournaments
    val tournaments = remember {
        listOf(
            TournamentInfo(
                id = "1",
                game = "PUBG tournament",
                organizer = "Red Bull",
                registrationStatus = RegistrationStatus.OPEN,
                currentPlayers = 670,
                maxPlayers = 800,
                gameName = "BGMI",
                gameMode = "Solo",
                entryFee = 10,
                startTime = "3rd Aug at 10:00 pm",
                prizePool = 1000,
                backgroundImage = R.drawable.ic_bgmi_tounamant,
                organizerLogo = R.drawable.ic_red_bull
            ),
            TournamentInfo(
                id = "2",
                game = "PUBG tournament",
                organizer = "Red Bull",
                registrationStatus = RegistrationStatus.CLOSED,
                currentPlayers = 500,
                maxPlayers = 500,
                gameName = "BGMI",
                gameMode = "Squad",
                entryFee = 20,
                startTime = "4th Aug at 8:00 pm",
                prizePool = 2000,
                backgroundImage = R.drawable.pubg_tournament,
                organizerLogo = R.drawable.ic_red_bull
            ),
            TournamentInfo(
                id = "3",
                game = "Fortnite tournament",
                organizer = "Asus",
                registrationStatus = RegistrationStatus.OPENING_SOON,
                currentPlayers = 0,
                maxPlayers = 1000,
                gameName = "Fortnite",
                gameMode = "Duo",
                entryFee = 15,
                startTime = "5th Aug at 9:00 pm",
                prizePool = 1500,
                backgroundImage = R.drawable.fortnite_tournament,
                organizerLogo = R.drawable.ic_asusrog
            )
        )
    }
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(Screens.Home.route) {
            HomeScreen(
                navController = navController,
                tournaments = tournaments,
                onTournamentClick = { tournamentId ->
                    navController.navigate(
                        Screens.TournamentDetail.route.replace(
                            "{tournamentId}",
                            tournamentId
                        )
                    )
                }
            )
        }

        composable(
            route = Screens.TournamentDetail.route,
            arguments = listOf(
                navArgument("tournamentId") {
                    type = NavType.StringType
                }
            )) { backStackEntry ->
            val tournamentId = backStackEntry.arguments?.getString("tournamentId")
            val tournament = remember(tournamentId) {
                tournaments.find { it.id == tournamentId } ?: tournaments[0]
            }
            TournamentDetailScreen(
                tournamentInfo = tournament,
                onBackClick = {
                    navController.popBackStack()
                },
                onShareClick = {},
                onJoinClick = {},
                onTournamentClick = {},
                tournaments = tournaments
            )
        }

        composable(
            route = Screens.GameDetail.route,
            arguments = listOf(
                navArgument("gameId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getInt("gameId") ?: 1
            GameDetailsScreen(
                gameId = gameId,
                onBackClick = { navController.popBackStack() },
                onTournamentClick = { tournamentId ->
                    navController.navigate(
                        Screens.TournamentDetail.route.replace(
                            "{tournamentId}",
                            tournamentId
                        )
                    )
                }
            )
        }
    }
}