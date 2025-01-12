package com.example.travelapp.yaser.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.travelapp.R

@Composable
fun MockAppBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.mock_top_bar),
            contentDescription = "Top Bar Image",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth
        )
    }
}