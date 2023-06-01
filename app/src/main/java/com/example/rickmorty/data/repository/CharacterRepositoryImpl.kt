package com.example.rickmorty.data.repository

import com.example.rickmorty.common.Endpoints
import com.example.rickmorty.data.remote.dto.CharacterDetailDto
import com.example.rickmorty.data.remote.dto.CharacterResponseDto
import com.example.rickmorty.domain.repository.CharacterRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class CharacterRepositoryImpl(
    private val client: HttpClient
) : CharacterRepository {

    override suspend fun getCharacters(): CharacterResponseDto {
        return client.get {
            url(Endpoints.CHARACTERS)
        }.body()
    }

    override suspend fun getCharacterById(id: Int): CharacterDetailDto {
        return client.get {
            url(Endpoints.CHARACTER_BY_ID.replace("{id}", id.toString()))
        }.body()
    }
}
