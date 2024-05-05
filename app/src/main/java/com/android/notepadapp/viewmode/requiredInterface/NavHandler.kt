package com.android.notepadapp.viewmode.requiredInterface

import androidx.compose.runtime.State
import androidx.navigation.NavBackStackEntry

interface NavHandler {
    fun setCurrentBackStackEntryAsState(currentBackStackEntryAsState: State<NavBackStackEntry?>)
}