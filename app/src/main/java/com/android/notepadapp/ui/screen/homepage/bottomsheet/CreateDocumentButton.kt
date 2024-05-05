package com.android.notepadapp.ui.screen.homepage.bottomsheet

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.notepadapp.ui.screen.homepage.bottomsheet.DimConstant.Companion.BUTTON_PADDING_END
import com.android.notepadapp.ui.screen.homepage.bottomsheet.DimConstant.Companion.BUTTON_PADDING_START
import com.android.notepadapp.ui.screen.homepage.bottomsheet.DimConstant.Companion.BUTTON_WEIGHT

@Composable
fun CreateDocumentButton(hideBottomSheet: () -> Unit, createNewTextDocument: () -> Unit) {
    Row {
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .weight(BUTTON_WEIGHT)
                .padding(end = BUTTON_PADDING_END)
        ) {
            Text("Smart Note")
        }
        Button(
            onClick = {
                // Hide the bottom sheet before opening new screen
                hideBottomSheet()
                // Opening create new text file screen
                createNewTextDocument()
            }, modifier = Modifier
                .weight(BUTTON_WEIGHT)
                .padding(start = BUTTON_PADDING_START)
        ) {
            Text("Text Note")
        }
    }
}