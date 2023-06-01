package com.example.rickmorty.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickmorty.ui.character_list.CharacterListViewModel
import com.example.rickmorty.ui.components.CharacterList

@Composable
fun CharacterListScreen(
//    navController: NavController,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val heightStatusBar = WindowInsets.systemBars.asPaddingValues().calculateTopPadding()
    val heightNavigationBar =
        WindowInsets.systemBars.asPaddingValues().calculateBottomPadding()

    LazyColumn(
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            bottom = heightNavigationBar + 0.dp,
            top = heightStatusBar + 16.dp
        ),
    ) {
        item {
            Row {
                Text(
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Black,
                    text = "Hello there!"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            CharacterList(
                characters = state.characters,
//        navController = navController,
                isLoading = state.isLoading,
                error = state.error,
//        onItemClick = onItemClick
            )
        }
    }
}