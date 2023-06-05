package com.example.rickmorty.data.repository

import com.example.rickmorty.common.Endpoints
import com.example.rickmorty.data.remote.dto.CharacterDetailDto
import com.example.rickmorty.data.remote.dto.CharacterResponseDto
import com.example.rickmorty.data.remote.dto.toCharacter
import com.example.rickmorty.data.remote.dto.toCharacterDetail
import com.example.rickmorty.domain.model.Character
import com.example.rickmorty.domain.model.CharacterDetail
import com.example.rickmorty.domain.repository.CharacterRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class CharacterRepositoryImpl(
    private val client: HttpClient
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        val response: CharacterResponseDto = client.get {
            url(Endpoints.CHARACTERS)
        }.body()
        return response.results.map { it.toCharacter() }
    }

    override suspend fun getCharacterById(id: String): CharacterDetail {
        val response: CharacterDetailDto = client.get {
            url(Endpoints.CHARACTER_BY_ID.replace("{id}", id))
        }.body()
        return response.toCharacterDetail()
    }
}
