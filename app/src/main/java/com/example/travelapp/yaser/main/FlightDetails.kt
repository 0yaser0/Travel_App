package com.example.travelapp.yaser.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.travelapp.ui.theme.TravelAppTheme
import com.example.travelapp.yaser.components.TicketCardComponents

class FlightDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelAppTheme {
                FlightDetailsScaffold()
            }
        }
    }
}

@Composable
fun FlightDetailsScaffold() {
    Scaffold(
        content = { innerPadding ->
            TicketCardComponents(
                modifier = Modifier.padding(innerPadding).padding(15.dp)
            )
        }
    )
}
