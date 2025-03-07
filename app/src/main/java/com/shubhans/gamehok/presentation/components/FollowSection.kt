package com.shubhans.gamehok.presentation.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shubhans.gamehok.R
import com.shubhans.gamehok.presentation.theme.ButtonSurface
import com.shubhans.gamehok.presentation.theme.Green
import com.shubhans.gamehok.presentation.theme.LinearGreen
import com.shubhans.gamehok.presentation.theme.TextWhite
import com.shubhans.gamehok.presentation.theme.TitleWhite

data class Gamer(
    val id: Int,
    val name: String,
    val image: Int
)

@Composable
fun PeopleToFollowSection(
    modifier: Modifier = Modifier,
    onViewMoreClick: () -> Unit
) {
    val gamers = remember {
        listOf(
            Gamer(1, "Legend Gamer", R.drawable.ic_random3),
            Gamer(2, "Ninja", R.drawable.ic_random1),
            Gamer(3, "PewDiePie", R.drawable.ic_random2)
        )
    }

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
                text = "People to follow",
                style = MaterialTheme.typography.titleMedium,
                color = TitleWhite
            )
            Text(
                text = "View More",
                style = MaterialTheme.typography.bodyMedium,
                color = LinearGreen,
                modifier = Modifier.clickable { onViewMoreClick() }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(height = 200.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(gamers) { gamer ->
                GamerCard(gamer = gamer)
            }
        }
    }
}

@Composable
fun GamerCard(
    gamer: Gamer,
    modifier: Modifier = Modifier
) {
    var isFollowing by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = gamer.image),
                contentDescription = "Profile picture of ${gamer.name}",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = gamer.name,
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite,
                fontWeight = FontWeight(400)
            )
        }
        val buttonWidthState = animateDpAsState(
            targetValue = if (isFollowing) 120.dp else 100.dp,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ),
            label = "button width"
        )

        Button(
            onClick = { isFollowing = !isFollowing },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFollowing)
                    ButtonSurface.copy(alpha = 0.2f)
                else ButtonSurface,
            ),
            modifier = Modifier
                .width(buttonWidthState.value)
                .height(36.dp)
        ) {
            Text(
                text = if (isFollowing) "Following" else "Follow",
                fontWeight = FontWeight(500),
                color = if (isFollowing)
                   Green
                else TextWhite
            )
        }
    }
}
