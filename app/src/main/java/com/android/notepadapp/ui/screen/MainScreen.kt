package com.android.notepadapp.ui.screen

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.android.notepadapp.ui.screen.nav.NavScreen
import com.android.notepadapp.ui.screen.scafoldcomponent.fab.AppFab
import com.android.notepadapp.ui.screen.scafoldcomponent.topbar.AppTopBar
import com.android.notepadapp.viewmode.BottomSheetHandlerViewModel
import com.android.notepadapp.viewmode.NavHandlerViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    bottomSheetHandlerViewModel: BottomSheetHandlerViewModel,
    navHandlerViewModel: NavHandlerViewModel,
) {
    val context = LocalContext.current as Activity
    val navController = rememberNavController()
    navHandlerViewModel.setCurrentBackStackEntryAsState(navController.currentBackStackEntryAsState())
    val isFabVisible by navHandlerViewModel.isFabVisible.collectAsState()
    val topAppBarTitle by navHandlerViewModel.topAppBarTitle.collectAsState()

    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    val isBottomSheetVisible by bottomSheetHandlerViewModel.isBottomSheetVisible.collectAsState()
    bottomSheetHandlerViewModel.setSheetState(sheetState)

    Scaffold(
        topBar = {
            AppTopBar(topAppBarTitle) {
                if (navController.previousBackStackEntry == null) context.finishAffinity()
                else navController.popBackStack()
            }
        },
        floatingActionButton = {
            AppFab(isFabVisible) {
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