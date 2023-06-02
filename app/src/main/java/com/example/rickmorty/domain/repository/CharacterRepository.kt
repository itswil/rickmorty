package com.example.rickmorty.domain.repository

import com.example.rickmorty.domain.model.Character
import com.example.rickmorty.domain.model.CharacterDetail

interface CharacterRepository {

    suspend fun getCharacters(): List<Character>

    suspend fun getCharacterById(id: String): CharacterDetail
}