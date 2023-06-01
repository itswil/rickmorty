package com.example.rickmorty.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickmorty.ui.character_list.CharacterListViewModel
import com.example.rickmorty.ui.components.CharacterList

@Composable
fun CharacterListScreen(
//    navController: NavController,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    CharacterList(
        characters = state.characters,
//        navController = navController,
        isLoading = state.isLoading,
        error = state.error,
//        onItemClick = onItemClick
    )
}