package com.android.notepadapp.ui.screen.scafoldcomponent.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomSheet(sheetState: SheetState) {
    ModalBottomSheet(
        onDismissRequest = {
            CoroutineScope(Dispatchers.IO).launch {
                if (sheetState.isVisible) sheetState.hide()
            }
        },
        sheetState = sheetState
    ) {
        Column(modifier = Modifier.padding(32.dp, 8.dp, 32.dp, 48.dp)) {
            Icon(
                imageVector = Icons.Filled.AddCircle,
                contentDescription = "Add some note",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Which type of document you want to create?",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Text("Smart Note")
                }
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    Text("Text Note")
                }
            }
        }
    }
}