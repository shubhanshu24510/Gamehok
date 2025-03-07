package com.shubhans.gamehok.domain

import com.shubhans.gamehok.presentation.components.RegistrationStatus
import java.util.UUID

data class TournamentInfo(
    val id: String = UUID.randomUUID().toString(),
    val game: String,
    val organizer: String,
    val registrationStatus: RegistrationStatus,
    val currentPlayers: Int,
    val maxPlayers: Int,
    val gameMode: String,
    val gameName: String,
    val entryFee: Int,
    val startTime: String,
    val prizePool: Int,
    val backgroundImage: Int,
    val organizerLogo: Int
)