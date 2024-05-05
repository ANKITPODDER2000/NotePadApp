package com.android.notepadapp.ui.screen.homepage

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.android.notepadapp.testhelper.AppBottomSheetTestHelper
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@OptIn(ExperimentalMaterial3Api::class)
class HomeScreenTest {

    @get:Rule
    val composeRule = createComposeRule()


    @Test
    fun check_bottomSheet_in_the_homeScreen_available() {
        composeRule.setContent {
            HomeScreen(
                sheetState = rememberModalBottomSheetState(),
                isBottomSheetVisible = true
            ) { }
        }
        composeRule.onNodeWithTag(AppBottomSheetTestHelper.MODAL_BOTTOM_SHEET_TEST_TAG).assertExists("Bottom Sheet should be available when isBottomSheetVisible is true")
    }

    @Test
    fun check_bottomSheet_in_the_homeScreen_not_available() {
        composeRule.setContent {
            HomeScreen(
                sheetState = rememberModalBottomSheetState(),
                isBottomSheetVisible = false
            ) { }
        }
        composeRule.onNodeWithTag(AppBottomSheetTestHelper.MODAL_BOTTOM_SHEET_TEST_TAG).assertDoesNotExist()
    }

}