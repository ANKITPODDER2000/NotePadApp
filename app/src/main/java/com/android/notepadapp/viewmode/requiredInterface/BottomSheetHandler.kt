package com.android.notepadapp.viewmode.requiredInterface

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState

@OptIn(ExperimentalMaterial3Api::class)
interface BottomSheetHandler {
    fun setSheetState(sheetState: SheetState)
    suspend fun showBottomSheet()
    suspend fun hideBottomSheet()
}