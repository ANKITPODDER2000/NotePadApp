package com.android.notepadapp.ui.screen.scafoldcomponent.fab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppFab() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color.LightGray,
        elevation = FloatingActionButtonDefaults.elevation(0.dp)
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
    }
}

@Preview
@Composable
fun PreviewAppFab() {
    AppFab()
}