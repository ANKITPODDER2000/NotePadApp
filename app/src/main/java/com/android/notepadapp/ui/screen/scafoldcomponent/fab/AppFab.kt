package com.android.notepadapp.ui.screen.scafoldcomponent.fab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.notepadapp.testhelper.AppFabTestHelper

@Composable
fun AppFab(btnClickHandler: () -> Unit) {
    FloatingActionButton(
        onClick = {
            btnClickHandler()
        },
        containerColor = Color.LightGray,
        elevation = FloatingActionButtonDefaults.elevation(0.dp),
        modifier = Modifier.testTag(AppFabTestHelper.FAB_TEST_TAG)
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
    }
}

@Preview
@Composable
fun PreviewAppFab() {
    AppFab {}
}