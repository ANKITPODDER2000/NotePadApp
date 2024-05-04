package com.android.notepadapp.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.android.notepadapp.ui.screen.nav.NavScreen
import com.android.notepadapp.ui.screen.scafoldcomponent.fab.AppFab
import com.android.notepadapp.ui.screen.scafoldcomponent.topbar.AppTopBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { AppTopBar() },
        floatingActionButton = { AppFab() }
    ) { paddingValues ->
        NavScreen(navController, Modifier.padding(paddingValues))
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}