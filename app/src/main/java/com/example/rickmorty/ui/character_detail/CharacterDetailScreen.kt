package com.example.rickmorty.ui.character_detail

import android.widget.Toast
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.rickmorty.data.remote.dto.Status
import com.example.rickmorty.ui.common.components.ErrorFullScreen
import com.example.rickmorty.ui.common.components.Label
import com.example.rickmorty.ui.common.components.LoadingFullScreen

@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val (characterDetail, isLoading, error) = state

    if (isLoading) {
        LoadingFullScreen()
    } else if (error.isNotBlank()) {
        ErrorFullScreen(errorMessage = error)
    } else if (characterDetail != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    PaddingValues(16.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp, top = 64.dp),
                contentAlignment = Alignment.Center,
            ) {
                AsyncImage(
                    model = characterDetail.image,
                    contentDescription = characterDetail.name,
                    modifier = Modifier.clip(CircleShape)
                )
                StatusDot(characterDetail.status)

            }

            Column(modifier = Modifier.padding(bottom = 32.dp)) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                ) {
                    Text(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 32.sp,
                        lineHeight = 40.sp,
                        text = characterDetail.name,
                        textAlign = TextAlign.Center,
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        contentDescription = "Current location",
                        imageVector = Icons.Rounded.Place,
                        modifier = Modifier
                            .height(20.dp)
                            .padding(end = 4.dp),
                        tint = MaterialTheme.colorScheme.secondary,
                    )
                    Text(
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        text = characterDetail.location.name,
                    )
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    Label(text = "Gender")
                    Text(fontSize = 18.sp, text = characterDetail.gender)
                    Spacer(modifier = Modifier.padding(16.dp))

                    Label(text = "Species")
                    Text(fontSize = 18.sp, text = characterDetail.species)
                    Spacer(modifier = Modifier.padding(16.dp))

                    Label(text = "Origin")
                    Text(fontSize = 18.sp, text = characterDetail.origin.name)
                }
            }
        }
    }
}

@Composable
fun StatusDot(status: Status) {
    val context = LocalContext.current

    val color = when (status) {
        Status.Alive -> Color(0xFF86efac) // Alive: green
        Status.Dead -> Color(0xFFef8686) // Dead: red
        Status.unknown -> Color(0xFF868686) // Unknown: grey
    }

    Canvas(
        modifier = Modifier
            .size(24.dp)
            .offset(x = (40).dp, y = (-40).dp)
            .clip(CircleShape)
            .clickable {
                Toast
                    .makeText(
                        context,
                        "Status: $status",
                        Toast.LENGTH_LONG
                    )
                    .show()
            }
    ) {
        drawCircle(color)
    }
}