package com.example.rickmorty.domain.repository

import com.example.rickmorty.data.remote.dto.CharacterDetailDto
import com.example.rickmorty.data.remote.dto.CharacterResponseDto

interface CharacterRepository {

    suspend fun getCharacters(): CharacterResponseDto

    suspend fun getCharacterById(id: Int): CharacterDetailDto
}