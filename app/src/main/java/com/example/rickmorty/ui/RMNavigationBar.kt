package com.example.rickmorty.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.rickmorty.R

data class TopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val iconTextId: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = Screen.CharacterListScreen.route,
        selectedIcon = Icons.Rounded.Face,
        iconTextId = R.string.navigation_item_characters
    ),
    TopLevelDestination(
        route = Screen.LocationListScreen.route,
        selectedIcon = Icons.Rounded.Map,
        iconTextId = R.string.navigation_item_locations
    ),
)

@Composable
fun RMNavigationBar(selectedDestination: String) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        TOP_LEVEL_DESTINATIONS.forEach { destination ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = stringResource(destination.iconTextId)
                    )
                },
                label = { Text(text = stringResource(destination.iconTextId)) },
                selected = destination.route == selectedDestination,
                onClick = {}
            )
        }
    }
}