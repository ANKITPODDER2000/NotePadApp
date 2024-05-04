package com.android.notepadapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.android.notepadapp.ui.screen.MainScreen
import com.android.notepadapp.ui.theme.NotePadAppTheme
import com.android.notepadapp.viewmode.BottomSheetHandlerViewModel

class MainActivity : ComponentActivity() {
    private val bottomSheetHandlerViewModel by viewModels<BottomSheetHandlerViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotePadAppTheme {
                MainScreen(bottomSheetHandlerViewModel)
            }
        }
    }
}