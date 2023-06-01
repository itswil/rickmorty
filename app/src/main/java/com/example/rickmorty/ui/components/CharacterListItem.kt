package com.example.rickmorty.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.rickmorty.domain.model.Character

@Composable
fun CharacterListItem(
    character: Character
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .clickable { onItemClick(character.id) }
    ) {
        Card {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column {
                    Row {
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = character.name
                        )
                    }
                    Row {
                        Text(text = character.species)
                    }
                }

            }
        }
    }
}