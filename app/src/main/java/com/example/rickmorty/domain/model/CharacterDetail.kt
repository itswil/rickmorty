package com.example.rickmorty.domain.model

import com.example.rickmorty.data.remote.dto.LocationDto
import com.example.rickmorty.data.remote.dto.OriginDto

data class CharacterDetail(
    val id: Int,
    val name: String,
    val species: String,
    val gender: String,
    val status: String,
    val image: String,
    val origin: OriginDto,
    val location: LocationDto,
    val episode: List<String>,
    val url: String,
)
