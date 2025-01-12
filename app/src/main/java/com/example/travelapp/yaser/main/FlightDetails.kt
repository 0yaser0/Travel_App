package com.example.travelapp.yaser.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelapp.components.TravelAppBar
import com.example.travelapp.ui.theme.TravelAppTheme
import com.example.travelapp.yaser.components.DownloadETicketComponents
import com.example.travelapp.yaser.components.MockAppBar
import com.example.travelapp.yaser.components.TermsConditionComponents
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

@Preview
@Composable
fun FlightDetailsScaffold() {
    Scaffold(
        modifier = Modifier.background(color = Color(0xFFF8F8F8)),
        topBar = {
            MockAppBar()
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(15.dp)
                    .background(color = Color(0xFFF8F8F8))
            ) {

                TicketCardComponents(
                    modifier = Modifier.padding(bottom = 15.dp)
                )

                TermsConditionComponents(
                    modifier = Modifier.padding(bottom = 15.dp).background(color = Color(0xFFF8F8F8))
                )

                DownloadETicketComponents(
                    modifier = Modifier.padding(bottom = 5.dp).background(color = Color(0xFFF8F8F8))
                )
            }
        }
    )
}
