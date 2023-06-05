package com.example.rickmorty.ui.character_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.rickmorty.ui.common.components.ErrorFullScreen
import com.example.rickmorty.ui.common.components.Label
import com.example.rickmorty.ui.common.components.LoadingFullScreen

@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    if (state.isLoading) {
        LoadingFullScreen()
    } else if (state.error.isNotBlank()) {
        ErrorFullScreen(errorMessage = state.error)
    } else if (state.characterDetail != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    PaddingValues(16.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp, top = 64.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = state.characterDetail.image,
                    contentDescription = state.characterDetail.name,
                    modifier = Modifier.clip(CircleShape)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 32.sp,
                    text = state.characterDetail.name
                )
            }
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    Label(text = "Gender")
                    Text(fontSize = 18.sp, text = state.characterDetail.gender)
                    Spacer(modifier = Modifier.padding(16.dp))

                    Label(text = "Species")
                    Text(fontSize = 18.sp, text = state.characterDetail.species)
                    Spacer(modifier = Modifier.padding(16.dp))

                    Label(text = "Origin")
                    Text(fontSize = 18.sp, text = state.characterDetail.origin.name)
                    Spacer(modifier = Modifier.padding(16.dp))

                    Label(text = "Current location")
                    Text(fontSize = 18.sp, text = state.characterDetail.location.name)
                    Spacer(modifier = Modifier.padding(16.dp))

                    Label(text = "Status")
                    Text(fontSize = 18.sp, text = state.characterDetail.status)
                }
            }
        }
    }
}