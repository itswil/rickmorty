package com.example.rickmorty.ui.character_list

import com.example.rickmorty.domain.model.Character

data class CharacterListState(
    val characters: List<Character> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
