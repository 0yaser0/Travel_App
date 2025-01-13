package com.example.travelapp.hamza

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R


@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {  }) {
            Icon(
                painter = painterResource(id=R.drawable.li_chevron_left),
                contentDescription = "Back",
                tint = Color.White
            )
        }

        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id=R.drawable.li_edit),
                contentDescription = "Edit",
                tint = Color.White
            )
        }
    }
}

@Composable
fun TicketContent() {
    Column(
        modifier = Modifier
            .padding(18.dp)
            .padding(horizontal = 12.dp, vertical = 33.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "20 December 2022",
            color = Color.White,
            fontSize = 16.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "DEL",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            FlightIcon()

            Text(
                text = "BLR",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
            "Bengaluru Airport India",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 10.sp
            )

            Text(
                text = "04h 30m",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Delhi International Airport",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 10.sp
            )
        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Icon(
                painter = painterResource(id=R.drawable.li_user),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = "01 Adult",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Composable
fun FlightIcon() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(2.dp)
                .background(Color.White.copy(alpha = 0.5f))
        )
        Icon(
            painter = painterResource(id= R.drawable.li_plane),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(2.dp)
                .background(Color.White.copy(alpha = 0.5f))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FlightTicketScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.rectangle_18),
            contentDescription = "bg",
            modifier = Modifier.fillMaxWidth()
        )
        TopBar()
        TicketContent()
    }
}

@Preview(showBackground = true)
@Composable
fun IndiGoLogo() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.rectangle_18),
            contentDescription = "bg",
            modifier = Modifier.fillMaxWidth()
        )

        Row (
            modifier = Modifier
                .padding(vertical = 10.dp)
        ){
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(id=R.drawable.li_chevron_left),
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }

        Row (
            modifier = Modifier
                .padding(horizontal = 110.dp, vertical = 80.dp)
        ){
            Text(
                text = "IndiGo",
                color = Color.White,
                fontSize = 52.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
