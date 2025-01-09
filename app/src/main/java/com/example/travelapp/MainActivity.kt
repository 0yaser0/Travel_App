package com.example.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.travelapp.components.TravelAppBar
import com.example.travelapp.components.TravelAppBottomBar
import com.example.travelapp.components.MainContent
import com.example.travelapp.ui.theme.TravelAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelAppTheme {
                TravelAppScaffold()
            }
        }
    }
}

@Composable
fun TravelAppScaffold() {
    Scaffold(
        topBar = { TravelAppBar() },
        bottomBar = { TravelAppBottomBar() },
        content = { innerPadding ->
            MainContent(modifier = Modifier.padding(innerPadding).fillMaxSize())
        }
    )
}
