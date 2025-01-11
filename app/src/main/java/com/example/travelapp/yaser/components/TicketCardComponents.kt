package com.example.travelapp.yaser.components

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R

val PoppinsBold = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold)
)
val PoppinsSemiBold = FontFamily(
    Font(R.font.poppins_semibold, FontWeight.SemiBold)
)
val PoppinsMedium = FontFamily(
    Font(R.font.poppins_medium, FontWeight.Normal)
)

@Composable
fun TicketCardComponents(modifier: Modifier) {
    Box(
        modifier = Modifier
            .width(360.dp)
            .height(530.dp)
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.subtract),
            contentDescription = "Ticket Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "20 December 2022",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = PoppinsSemiBold,
                    color = Color(0xFF000000),
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "DEL",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontFamily = PoppinsBold,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF000000),
                        )
                    )
                    Text(
                        text = "Delhi International Airport",
                        style = TextStyle(
                            fontSize = 6.sp,
                            fontFamily = PoppinsMedium,
                            color = Color(0xFF000000),
                        )
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.li_plane_line),
                    contentDescription = "Wrap Content Image",
                    modifier = Modifier.wrapContentSize(),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text(
                        text = "BLR",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontFamily = PoppinsBold,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF000000),
                        )
                    )
                    Text(
                        text = "Bengaluru Airport India",
                        style = TextStyle(
                            fontSize = 6.sp,
                            fontFamily = PoppinsMedium,
                            color = Color(0xFF000000),
                        )
                    )
                }
            }
            Text(
                text = "04h30m",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(14.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Meal Icon",
                        tint = Color.Black
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "01 Adult Meal",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.li_drumstick),
                        contentDescription = "Meal Icon",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Meal",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Passenger Name",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF848484),
                        )
                    )
                    Text(
                        text = "Shreya Kumar",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "Flight Type",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF848484),
                        )
                    )
                    Text(
                        text = "Economy",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Flight Code",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF848484),
                        )
                    )
                    Text(
                        text = "IG-2105",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Boarding Time",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF848484),
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "06:15 AM",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )
                }

                Column {
                    Text(
                        text = "Gate",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF848484),
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "A5",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )
                }

                Column {
                    Text(
                        text = "Terminal",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF848484),
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "T2",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )
                }

                Column {
                    Text(
                        text = "Seat Number",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF848484),
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "A5",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(65.dp))

            Image(
                painter = painterResource(id = R.drawable.line_down),
                contentDescription = "QR Code",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Image(
                painter = painterResource(id = R.drawable.bar_code),
                contentDescription = "QR Code",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "1  2  5  8  4  6  2  4  2  7  5  3  1  3  5  0  6  7  5  9",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}


@Preview(backgroundColor = 0xFF000000, showBackground = true)
@Composable
fun TicketCardComponentsPreview() {
    TicketCardComponents(modifier = Modifier)
}