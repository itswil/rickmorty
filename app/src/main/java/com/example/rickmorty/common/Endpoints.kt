package com.example.rickmorty.common

object Endpoints {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    const val CHARACTERS = "${BASE_URL}character"
    const val CHARACTER_BY_ID = "${BASE_URL}character/{id}"
}