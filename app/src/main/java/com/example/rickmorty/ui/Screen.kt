package com.example.rickmorty.ui

object ScreenName {
    const val CHARACTER_LIST = "character_list_screen"
    const val CHARACTER_DETAIL = "character_detail_screen"
    const val LOCATION_LIST = "location_list_screen"
}

open class Screen(val route: String) {
    object CharacterListScreen : Screen(ScreenName.CHARACTER_LIST)
    object CharacterDetailScreen : Screen(ScreenName.CHARACTER_DETAIL)
    object LocationListScreen : Screen(ScreenName.LOCATION_LIST)
}