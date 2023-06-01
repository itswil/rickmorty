package com.example.rickmorty.ui.character_detail

import com.example.rickmorty.domain.model.CharacterDetail

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val characterDetail: CharacterDetail? = null,
    val error: String = ""
)
