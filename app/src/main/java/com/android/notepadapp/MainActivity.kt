package com.android.notepadapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.android.notepadapp.ui.screen.MainScreen
import com.android.notepadapp.ui.theme.NotePadAppTheme
import com.android.notepadapp.viewmode.BottomSheetHandlerViewModel
import com.android.notepadapp.viewmode.NavHandlerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val bottomSheetHandlerViewModel by viewModels<BottomSheetHandlerViewModel>()
    private val navHandlerViewModel by viewModels<NavHandlerViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotePadAppTheme {
                MainScreen(bottomSheetHandlerViewModel, navHandlerViewModel)
            }
        }
    }
}