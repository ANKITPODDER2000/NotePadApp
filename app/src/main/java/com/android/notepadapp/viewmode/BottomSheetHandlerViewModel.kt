package com.android.notepadapp.viewmode

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.lifecycle.ViewModel
import com.android.notepadapp.viewmode.requiredInterface.BottomSheetHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
@OptIn(ExperimentalMaterial3Api::class)
class BottomSheetHandlerViewModel @Inject constructor() : ViewModel(), BottomSheetHandler {
    @Volatile
    private var sheetState: SheetState? = null
    private val _isBottomSheetVisible = MutableStateFlow(false)
    val isBottomSheetVisible = _isBottomSheetVisible.asStateFlow()

    override fun setSheetState(sheetState: SheetState) {
        this.sheetState = sheetState
    }

    override suspend fun showBottomSheet() {
        _isBottomSheetVisible.value = true
        sheetState?.show()
    }

    override suspend fun hideBottomSheet() {
        _isBottomSheetVisible.value = false
        sheetState?.hide()
    }

}