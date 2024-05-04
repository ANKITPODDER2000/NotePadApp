package com.android.notepadapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.notepadapp.ui.screen.MainScreen
import com.android.notepadapp.ui.theme.NotePadAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotePadAppTheme {
                MainScreen()
            }
        }
    }
}