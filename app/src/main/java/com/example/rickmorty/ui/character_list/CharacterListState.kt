package com.example.rickmorty.ui.character_list

import com.example.rickmorty.domain.model.Character

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = ""
)
