package com.android.notepadapp.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.android.notepadapp.ui.screen.nav.NavScreen
import com.android.notepadapp.ui.screen.scafoldcomponent.fab.AppFab
import com.android.notepadapp.ui.screen.scafoldcomponent.topbar.AppTopBar
import com.android.notepadapp.viewmode.BottomSheetHandlerViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(bottomSheetHandlerViewModel: BottomSheetHandlerViewModel) {
    val navController = rememberNavController()
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    val isBottomSheetVisible by bottomSheetHandlerViewModel.isBottomSheetVisible.collectAsState()
    bottomSheetHandlerViewModel.setSheetState(sheetState)
    Scaffold(
        topBar = { AppTopBar() },
        floatingActionButton = {
            AppFab {
                coroutineScope.launch {
                    bottomSheetHandlerViewModel.showBottomSheet()
                }
            }
        }
    ) { paddingValues ->
        NavScreen(
            sheetState,
            isBottomSheetVisible,
            navController,
            {
                coroutineScope.launch {
                    bottomSheetHandlerViewModel.hideBottomSheet()
                }
            },
            Modifier.padding(paddingValues)
        )
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun PreviewMainScreen() {
//    MainScreen()
//}