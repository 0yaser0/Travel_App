package com.example.travelapp.hamza

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R

fun message(context:Context,mess:String){
    Toast.makeText(context,mess,Toast.LENGTH_SHORT).show()
}

@Composable
fun TopBar(title: String = "") {
    val context = LocalContext.current
    Box (
    ){
        Image(
            painter = painterResource(id = R.drawable.rectangle_18),
            contentDescription = ""
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
           Column (
               verticalArrangement = Arrangement.Bottom
           ){
               Icon(
                   painter = painterResource(id = R.drawable.li_chevron_left),
                   contentDescription = "Back",
                   modifier = Modifier
                       .size(24.dp)
                       .clickable {message(context,"hhh") }
               )
           }

            Column {
                Icon(
                    painter = painterResource(id = R.drawable.li_edit),
                    contentDescription = "edit",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {message(context,"hhh") }
                )
            }
            // end row
        }
    }
}

@Composable
fun DateDisplay(date: String) {
    Text(
        text = date,
        modifier = Modifier
            .fillMaxWidth(),
        fontSize = 16.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun AirportInfo(source: String, destination: String, sourceDesc: String, destinationDesc: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = source, fontSize = 36.sp)
            Text(text = sourceDesc,fontSize = 8.sp)
        }
        Icon(
            painter = painterResource(id = R.drawable.li_plane),
            contentDescription = "Flight Icon",
            modifier = Modifier.size(37.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = destination,fontSize = 36.sp)
            Text(text = destinationDesc,fontSize = 8.sp)
        }
    }
}

@Composable
fun FlightDuration(duration: String) {
    Text(
        text = duration,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun PassengerCount(passengers: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Person Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = passengers,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun BrandingSection(brandName: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = brandName,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, fontSize = 30.sp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FlightListingHeader() {
    Column {
        TopBar(title = "")
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        DateDisplay(date = "20 December 2022")
        Spacer(modifier = Modifier.height(16.dp))
        AirportInfo(
            source = "DEL",
            destination = "BLR",
            sourceDesc = "Delhi International Airport",
            destinationDesc = "Bengaluru Airport India"
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlightDuration(duration = "04h 30m")
        Spacer(modifier = Modifier.height(16.dp))
        PassengerCount(passengers = "01 Adult")
    }
}

@Preview(showBackground = true)
@Composable
fun FlightDetails(){
    Image(
        painter = painterResource(id=R.drawable.indigo),
        contentDescription = "",
        modifier = Modifier.fillMaxSize()
    )
}