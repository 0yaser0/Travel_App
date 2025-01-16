package com.example.travelapp.hamza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import com.example.travelapp.R

class FlightListing : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(0.dp)) {
        FlightTicketScreen()

        Spacer(modifier = Modifier.width(4.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        HorizontalButtonInterface()

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(sampleItems) { item ->
                ItemRow(item = item)
            }
        }
    }
}

@Composable
fun HorizontalButtonInterface() {
    HorizontalDivider(thickness = 1.dp, color = Color.Gray)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .height(40.dp)
                .weight(1f),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Low to high", fontSize = 9.sp, color = Color.Black)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .height(40.dp)
                .weight(1f),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("High to low", fontSize = 10.sp, color = Color.Black)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .height(40.dp)
                .weight(1f),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Airlines Type", fontSize = 10.sp, color = Color.Black)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.filtre),
            contentDescription = "Filter",
            modifier = Modifier
                .size(30.dp)
        )
    }
    HorizontalDivider(thickness = 1.dp, color = Color.Gray)
}

@Composable
fun ItemRow(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)

        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = "Image",
                    modifier = Modifier
                        .size(35.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = item.title,
                    fontSize = 10.sp,
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.del,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                        Text(
                            text = item.time,
                            fontSize = 16.sp,
                            color = Color(0xFF955CE1)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.d_time,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.blr,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = R.drawable.pricetag),
                            contentDescription = "Flight Icon",
                            modifier = Modifier
                                .size(24.dp)
                        )
                        Text(
                            text = item.nbr,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.a_time,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Free Meal",
                    fontSize = 9.sp,
                    color = Color.LightGray
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = item.description,
                    fontSize = 10.sp,
                    color = Color.Green
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
    ) {
        MainScreen()
    }
}

val sampleItems = listOf(
    Item(R.drawable.icon1, "Indigo", "DEL", "06:30", "04h 15m", "BLR", "10:45", "7,319", "Use Code : Flyaway60 and get 60% instant cashback"),
    Item(R.drawable.icon2, "Vistara", "DEL", "07:15", "02h 25m", "BLR", "09:40", "7,319", "Use Code : Flyaway60 and get 60% instant cashback"),
    Item(R.drawable.icon3, "Spicejet", "DEL", "07:55", "02h 10m", "BLR ", "10:05", "7,319", "User GIUNIQUE and get Rs.250 instant discount"),
    Item(R.drawable.icon1, "Indigo", "DEL", "06:30", "04h 15m", "BLR", "10:45", "7,319", "Use Code : Flyaway60 and get 60% instant cashback"),
    Item(R.drawable.icon2, "Vistara", "DEL", "07:15", "02h 25m", "BLR", "09:40", "7,319", "Use Code : Flyaway60 and get 60% instant cashback"),
    Item(R.drawable.icon3, "Spicejet", "DEL", "07:55", "02h 10m", "BLR ", "10:05", "7,319", "User GIUNIQUE and get Rs.250 instant discount")
)
