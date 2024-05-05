package com.android.notepadapp.viewmode

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import com.android.notepadapp.ui.screen.nav.NavRoute
import com.android.notepadapp.viewmode.requiredInterface.NavHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NavHandlerViewModel @Inject constructor() : ViewModel(), NavHandler {

    private val _topAppBarTitle = MutableStateFlow("NotePadApp")
    val topAppBarTitle = _topAppBarTitle.asStateFlow()

    private val _isFabVisible = MutableStateFlow(true)
    val isFabVisible = _isFabVisible.asStateFlow()

    override fun setCurrentBackStackEntryAsState(currentBackStackEntryAsState: State<NavBackStackEntry?>) {
        when (currentBackStackEntryAsState.value?.destination?.route) {
            NavRoute.HOME_SCREE.name -> {
                _isFabVisible.value = true
                _topAppBarTitle.value = "NotePadApp"
            }

            NavRoute.CREATE_NOTE_SCREEN.name -> {
                _isFabVisible.value = false
                _topAppBarTitle.value = "Create your note..."
            }

            else -> {
                _isFabVisible.value = false
                _topAppBarTitle.value = "NotePadApp"
            }
        }
    }
}