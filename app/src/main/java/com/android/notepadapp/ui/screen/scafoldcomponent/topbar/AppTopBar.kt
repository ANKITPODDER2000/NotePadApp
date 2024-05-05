package com.android.notepadapp.ui.screen.scafoldcomponent.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(topAppBarTitle: String, appNavigationHandler: () -> Unit) {
    TopAppBar(
        title = { AppBarTitle(topAppBarTitle) },
        navigationIcon = { AppBarNavigation(appNavigationHandler) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray)
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewAppTopBar() {
    AppTopBar("NotePadApp") { }
}