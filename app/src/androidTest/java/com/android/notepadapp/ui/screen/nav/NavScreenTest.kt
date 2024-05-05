package com.android.notepadapp.ui.screen.nav

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.android.notepadapp.testhelper.AppBottomSheetTestHelper
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@OptIn(ExperimentalMaterial3Api::class)
class NavScreenTest {

    @get:Rule
    val composeRule = createComposeRule()

    private lateinit var navController: TestNavHostController

    @Test
    fun check_homeScreen_with_bottomSheet() {
        composeRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())

            NavScreen(
                sheetState = rememberModalBottomSheetState(),
                isBottomSheetVisible = true,
                navController = navController,
                hideBottomSheet = { }
            )
        }
        composeRule
            .onNodeWithTag(AppBottomSheetTestHelper.MODAL_BOTTOM_SHEET_TEST_TAG)
            .assertExists("Bottom sheet should Exists")
    }

    @Test
    fun check_homeScreen_withOut_bottomSheet() {
        composeRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            NavScreen(
                sheetState = rememberModalBottomSheetState(),
                isBottomSheetVisible = false,
                navController = navController,
                hideBottomSheet = { }
            )
        }
        composeRule
            .onNodeWithTag(AppBottomSheetTestHelper.MODAL_BOTTOM_SHEET_TEST_TAG)
            .assertDoesNotExist()
    }

    @Test
    fun check_notePage_after_navigateToNotePage() {
        composeRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            NavScreen(
                sheetState = rememberModalBottomSheetState(),
                isBottomSheetVisible = true,
                navController = navController,
                hideBottomSheet = { }
            )
            navController.navigate(NavRoute.CREATE_NOTE_SCREEN.name)
        }

        composeRule
            .onNodeWithTag(AppBottomSheetTestHelper.MODAL_BOTTOM_SHEET_TEST_TAG)
            .assertDoesNotExist()
    }
}