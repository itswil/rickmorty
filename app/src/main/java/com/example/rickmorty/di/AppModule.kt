package com.example.rickmorty.di

import com.example.rickmorty.data.repository.CharacterRepositoryImpl
import com.example.rickmorty.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(ContentNegotiation) {
                gson()
            }
        }
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(client: HttpClient): CharacterRepository {
        return CharacterRepositoryImpl(client)
    }
}