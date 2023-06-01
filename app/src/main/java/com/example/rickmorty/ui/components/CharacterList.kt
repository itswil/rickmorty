package com.example.rickmorty.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickmorty.domain.model.Character

@Composable
fun CharacterList(
    characters: List<Character>,
//    navController: NavController,
    isLoading: Boolean,
    error: String?,
//    onItemClick: (Int) -> Unit
) {
    if (isLoading && characters.isEmpty()) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }
    } else if (error != null && characters.isEmpty()) {
        Text(text = "Error: $error")
    } else {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(characters.size) { item ->
                CharacterListItem(
                    character = characters[item],
                )
            }
        }
    }
}