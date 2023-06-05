package com.example.rickmorty.ui.character_detail

import com.example.rickmorty.domain.model.CharacterDetail

data class CharacterDetailState(
    val characterDetail: CharacterDetail? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
