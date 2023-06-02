package com.example.rickmorty.domain.use_case

import com.example.rickmorty.common.Resource
import com.example.rickmorty.domain.model.CharacterDetail
import com.example.rickmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(id: String): Flow<Resource<CharacterDetail>> = flow {
        try {
            emit(Resource.Loading())
            val character = repository.getCharacterById(id)
            emit(Resource.Success(character))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        }
    }
}