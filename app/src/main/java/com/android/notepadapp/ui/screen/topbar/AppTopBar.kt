package com.android.notepadapp.ui.screen.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    TopAppBar(
        title = { AppBarTitle() },
        navigationIcon = { AppBarNavigation() },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray)
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewAppTopBar() {
    AppTopBar()
}