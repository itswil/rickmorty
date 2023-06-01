package com.example.rickmorty.ui.character_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rickmorty.domain.model.Character
import com.example.rickmorty.ui.Screen
import com.example.rickmorty.ui.common.components.ErrorFullScreen
import com.example.rickmorty.ui.common.components.LoadingFullScreen

@Composable
fun CharacterList(
    characters: List<Character>,
    navController: NavController,
    isLoading: Boolean,
    error: String?,
) {
    if (isLoading && characters.isEmpty()) {
        LoadingFullScreen()
    } else if (error != null && characters.isEmpty()) {
        ErrorFullScreen(errorMessage = error)
    } else {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            characters.forEach { character ->
                CharacterListItem(
                    character = character,
                    onItemClick = {
                        navController.navigate(Screen.CharacterDetailScreen.route + "/${character.id}")
                    }
                )
            }
        }
    }
}