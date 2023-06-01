package com.example.rickmorty.data.remote.dto

data class CharacterResponseDto(
    val info: InfoDto,
    val results: List<CharacterDetailDto>
)