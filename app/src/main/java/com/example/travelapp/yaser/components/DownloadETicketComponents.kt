package com.example.travelapp.yaser.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@Composable
fun DownloadETicketComponents(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            Button(
                onClick = { /* TODO: Handle click */ },
                modifier = Modifier
                    .background(
                        color = Color(0xFF674DEE),
                        shape = RoundedCornerShape(size = 6.dp)
                    )
                    .padding(80.dp, 10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),

                ) {
                Text(
                    text = "Download E-Ticket",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
        }
    }
}


@Preview(backgroundColor = 0xFF000000, showBackground = true)
@Composable
fun DownloadETicketComponentsPreview() {
    DownloadETicketComponents(modifier = Modifier)
}