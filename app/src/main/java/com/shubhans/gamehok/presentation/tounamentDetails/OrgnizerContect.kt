package com.shubhans.gamehok.presentation.tounamentDetails

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubhans.gamehok.R
import com.shubhans.gamehok.presentation.theme.ButtonSurface
import com.shubhans.gamehok.presentation.theme.DarkBackground
import com.shubhans.gamehok.presentation.theme.GamehokTheme.contactGradient
import com.shubhans.gamehok.presentation.theme.Green
import com.shubhans.gamehok.presentation.theme.TextWhite

@Composable
fun OrgnizationContact(
    modifier: Modifier = Modifier
) {
    var isFollowing by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(contactGradient)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(contactGradient)
                    .padding(vertical = 14.dp, horizontal = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Organiser’s Details and contact",
                    color = TextWhite,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.8.sp,
                    fontWeight = FontWeight(400)
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(220.dp)
                    .padding(1.dp),
                shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = DarkBackground
                ),
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_g_logo),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                contentScale = ContentScale.Fit
                            )
                            Text(
                                text = "Gamehok Esports",
                                style = MaterialTheme.typography.bodyLarge,
                                color = TextWhite,
                                fontWeight = FontWeight(600)
                            )
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Text(
                            text = "This is the in house organiser of this platform you can follow our page on this platform for regular updates",
                            color = Color(0xFFBCBCBC),
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight(300),
                            letterSpacing = 0.5.sp,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier.padding(start = 70.dp)
                    ) {
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
                                containerColor = if (isFollowing) ButtonSurface.copy(alpha = 0.2f)
                                else ButtonSurface,
                            ),
                            modifier = Modifier
                                .width(buttonWidthState.value)
                                .height(36.dp)
                        ) {
                            Text(
                                text = if (isFollowing) "Following" else "Follow",
                                fontWeight = FontWeight(500),
                                color = if (isFollowing) Green
                                else TextWhite
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(14.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ContactItem(
                        icon = Icons.Default.PhoneAndroid,
                        value = "9890987754"
                    )
                    ContactItem(
                        icon = Icons.Default.Email,
                        value = "Support@gamehok.com"
                    )
                }
                Box(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    ContactItem(
                        icon = Icons.Default.Whatsapp,
                        value = "9890987754"
                    )
                }
            }
        }
    }
}

@Composable
fun ContactItem(
    icon: ImageVector,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Contact Icon",
            tint = TextWhite,
            modifier = modifier.size(16.dp)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFBCBCBC),
            fontWeight = FontWeight(300),
            letterSpacing = 0.5.sp
        )
    }
}


@Preview(showBackground = false)
@Composable
private fun OrgnizationContactPreview() {
    OrgnizationContact()
}
