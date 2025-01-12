package com.example.travelapp.yaser.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@Composable
fun TermsConditionComponents(modifier: Modifier) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(0.dp,10.dp)
    ) {
        Column {
            Text(
                text = "Terms & Condition",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Curabitur ultrices nisi ac vulputate lacinia. Donec pharetra\ntincidunt velit, sed iaculis est sollicitudin ac.",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF848484),
                )
            )
        }
    }
}


@Preview(backgroundColor = 0xFF000000, showBackground = true)
@Composable
fun TermsConditionComponentsPreview() {
    TermsConditionComponents(modifier = Modifier)
}