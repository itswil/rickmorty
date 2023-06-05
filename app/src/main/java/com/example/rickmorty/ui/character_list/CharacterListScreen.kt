package com.example.rickmorty.ui.character_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.rickmorty.ui.Screen
import com.example.rickmorty.ui.character_list.components.CharacterListItem
import com.example.rickmorty.ui.common.components.ErrorFullScreen
import com.example.rickmorty.ui.common.components.LoadingFullScreen

@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val (characters, isLoading, error) = state

    if (isLoading && characters.isEmpty()) {
        LoadingFullScreen()
    } else if (error.isNotBlank()) {
        ErrorFullScreen(errorMessage = error)
    } else {
        LazyColumn {
            item {
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
}