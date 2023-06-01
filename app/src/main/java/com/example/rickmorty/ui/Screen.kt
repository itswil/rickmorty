package com.example.rickmorty.ui

sealed class Screen(val route: String) {
    object CharacterListScreen : Screen("character_list_screen")
    object CharacterDetailScreen : Screen("character_detail_screen")
}