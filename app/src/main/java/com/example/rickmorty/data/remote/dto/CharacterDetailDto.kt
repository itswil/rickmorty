package com.example.rickmorty.data.remote.dto

import com.example.rickmorty.domain.model.Character
import com.example.rickmorty.domain.model.CharacterDetail

data class CharacterDetailDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDetailDto.toCharacter(): Character {
    return Character(
        id,
        name,
        image,
    )
}

fun CharacterDetailDto.toCharacterDetail(): CharacterDetail {
    return CharacterDetail(
        id,
        name,
        species,
        gender,
        status,
        image,
        origin,
        location,
        episode,
        url
    )
}