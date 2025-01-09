package com.example.travelapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text

@Composable
fun TravelAppBottomBar() {
    BottomAppBar(
        modifier = Modifier.padding(16.dp),
        content = {
            Text(text = "Bottom Bar Content")
        }
    )
}
