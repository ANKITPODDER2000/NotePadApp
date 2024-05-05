package com.android.notepadapp.ui.screen

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.android.notepadapp.testhelper.AppBottomSheetTestHelper
import com.android.notepadapp.testhelper.AppFabTestHelper
import com.android.notepadapp.viewmode.BottomSheetHandlerViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainScreenKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    private lateinit var bottomSheetHandlerViewModel: BottomSheetHandlerViewModel

    @Before
    fun setUp() {
        bottomSheetHandlerViewModel = BottomSheetHandlerViewModel()
    }

    @Test
    fun bottomSheet_not_visible() {
        composeRule.setContent {
            MainScreen(bottomSheetHandlerViewModel = bottomSheetHandlerViewModel)
        }

        composeRule.onNodeWithTag(AppBottomSheetTestHelper.MODAL_BOTTOM_SHEET_TEST_TAG)
            .assertDoesNotExist()
    }

    @Test
    fun bottomSheet_visible_afterClickingFab() {
        composeRule.setContent {
            MainScreen(bottomSheetHandlerViewModel = bottomSheetHandlerViewModel)
        }

        composeRule.onNodeWithTag(AppFabTestHelper.FAB_TEST_TAG).performClick()
        composeRule.onNodeWithTag(AppBottomSheetTestHelper.MODAL_BOTTOM_SHEET_TEST_TAG)
            .assertExists()
    }
}