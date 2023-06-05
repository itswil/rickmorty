package com.example.rickmorty.ui.character_list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.rickmorty.ui.character_list.components.CharacterList

@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
    ) {
        item {
            CharacterList(
                characters = state.characters,
                navController = navController,
                isLoading = state.isLoading,
                error = state.error,
            )
        }
    }
}