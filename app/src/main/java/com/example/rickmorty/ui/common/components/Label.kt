package com.example.rickmorty.ui.common.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun Label(text: String) {
    Text(
        color = MaterialTheme.colorScheme.tertiary,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        text = text.uppercase(Locale.getDefault()),
    )
}
