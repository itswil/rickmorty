package com.example.rickmorty.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rickmorty.ui.character_detail.CharacterDetailScreen
import com.example.rickmorty.ui.character_list.CharacterListScreen
import com.example.rickmorty.ui.theme.RickMortyTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            RickMortyTheme {
                TransparentSystemBars()

                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val selectedDestination =
                    navBackStackEntry?.destination?.route ?: Screen.CharacterListScreen.route

                Scaffold(
                    topBar = {
                        AnimatedVisibility(
                            enter = slideInVertically(
                                initialOffsetY = { -it }
                            ),
                            exit = slideOutVertically(
                                targetOffsetY = { -it }
                            ),
                            visible = TOP_LEVEL_DESTINATIONS.any { it.route == selectedDestination }
                        ) {
                            RMTopAppBar()
                        }
                    },
                    content = { contentPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.CharacterListScreen.route,
                        ) {
                            composable(Screen.CharacterListScreen.route) {
                                Box(modifier = Modifier.padding(contentPadding)) {
                                    CharacterListScreen(navController)
                                }
                            }
                            composable(Screen.CharacterDetailScreen.route + "/{id}") {
                                CharacterDetailScreen()
                            }
                        }
                    },
                    bottomBar = {
                        AnimatedVisibility(
                            enter = slideInVertically(
                                initialOffsetY = { it }
                            ),
                            exit = slideOutVertically(
                                targetOffsetY = { it }
                            ),
                            visible = TOP_LEVEL_DESTINATIONS.any { it.route == selectedDestination }
                        ) { RMNavigationBar(selectedDestination) }
                    }
                )
            }
        }
    }
}

@Composable
fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )

        onDispose {}
    }
}