package com.android.notepadapp.ui.screen.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.notepadapp.ui.screen.homepage.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavScreen(
    sheetState: SheetState,
    isBottomSheetVisible: Boolean,
    navController: NavHostController,
    hideBottomSheet: () -> Unit,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.HOME_SCREE.name,
        modifier = modifier.padding(DimConstant.AROUND_PADDING_16)
    ) {

        composable(NavRoute.HOME_SCREE.name) {
            HomeScreen(sheetState, isBottomSheetVisible, hideBottomSheet) {
                navController.navigate(NavRoute.CREATE_NOTE_SCREEN.name)
            }
        }

        composable(NavRoute.CREATE_NOTE_SCREEN.name) {
            Text(text = "Hello Note Screen 2....")
        }
    }
}