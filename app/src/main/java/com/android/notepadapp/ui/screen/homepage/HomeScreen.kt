package com.android.notepadapp.ui.screen.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.notepadapp.ui.screen.homepage.bottomsheet.AppBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(sheetState: SheetState, isBottomSheetVisible: Boolean, hideBottomSheet: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home Page 1....")
        AppBottomSheet(sheetState, isBottomSheetVisible, hideBottomSheet)
    }
}