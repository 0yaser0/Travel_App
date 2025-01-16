package com.example.travelapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.components.NavigationItem
import com.example.travelapp.ui.theme.TravelAppTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = { TravelAppTopBar() },
                        bottomBar = { TravelAppBottomBar() }
                    ) { innerPadding ->
                        FlightBookingScreen(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelAppTopBar() {
//    FlightTicketScreen()
    CenterAlignedTopAppBar(
        title = { Text("") },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier.size(36.dp),
                    tint = Color(0xFF674DEE)
                )
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User",
                    modifier = Modifier.size(32.dp),
                    tint = Color.Unspecified
                )
            }
        }
    )
}

//@Preview(showBackground = true)
@Composable
fun FlightBookingScreen(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }
    var adultCount by remember { mutableIntStateOf(1) }
    var childCount by remember { mutableIntStateOf(0) }

    val items = listOf(
        NavigationItem(R.drawable.places, "Places"),
        NavigationItem(R.drawable.flights, "Flights"),
        NavigationItem(R.drawable.trains, "Trains"),
        NavigationItem(R.drawable.buses, "Buses"),
        NavigationItem(R.drawable.taxies, "Taxi")
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp)
    ) {
        item {
            WelcomeSection()
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar(searchQuery) { searchQuery = it }
            Spacer(modifier = Modifier.height(16.dp))
            NavigationCards(items)
            Spacer(modifier = Modifier.height(24.dp))
            BookingForm(
                selectedDate = selectedDate,
                onDateChange = { newDate -> selectedDate = newDate },
                adultCount = adultCount,
                childCount = childCount,
                onAdultCountChange = { adultCount = it },
                onChildCountChange = { childCount = it }
            )
            Spacer(modifier = Modifier.height(24.dp))

            SectionHeader(title = "Best offers")

            OffersList()

            Spacer(modifier = Modifier.height(16.dp))

            SectionHeader(title = "Winter Journey")

            WinterJourney()

            Spacer(modifier = Modifier.height(16.dp))

            SectionHeader(title = "Popular Location")

            PopularLocations()

            Spacer(modifier = Modifier.height(16.dp))

            SectionHeader(title = "My Achievements")

            BtnJournies()

        }
    }
}



@Composable
fun SearchBar(searchQuery: String, onSearchQueryChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            placeholder = { Text("Search Places") },
            modifier = Modifier
                .weight(1f)
                .height(55.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            },
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFE8E8E8),
                focusedBorderColor = Color(0xFF5669FF)
            )
        )

        FilledIconButton(
            onClick = { },
            modifier = Modifier
                .padding(start = 10.dp)
                .wrapContentSize(),
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color(0xFF5669FF)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Filter",
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

@Composable
fun BookingForm(
    modifier: Modifier = Modifier,
    selectedDate: String,
    onDateChange: (String) -> Unit,
    adultCount: Int = 0,
    childCount: Int = 0,
    onAdultCountChange: (Int) -> Unit = {},
    onChildCountChange: (Int) -> Unit = {}
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("One Way", "Round Trip", "Multicity")
    val context = LocalContext.current
    var showDatePickerDialog by remember { mutableStateOf(false) }

    if (showDatePickerDialog) {
        OpenDatePickerDialog(context) { date ->
            onDateChange(date)
            showDatePickerDialog = true
        }
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Book your Flight",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF4F4F4), RoundedCornerShape(8.dp))
                    .padding(4.dp)
            ) {
                tabs.forEachIndexed { index, title ->
                    Text(
                        text = title,
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                if (selectedTab == index) Color(0xFF5669FF) else Color.Transparent,
                                RoundedCornerShape(6.dp)
                            )
                            .padding(vertical = 8.dp)
                            .clickable { selectedTab = index },
                        color = if (selectedTab == index) Color.White else Color.Gray,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "From",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontWeight = FontWeight.Medium
            )
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                placeholder = { Text("Choose Departure from") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFE8E8E8),
                    focusedBorderColor = Color(0xFF5669FF)
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .size(55.dp)
                            .background(Color(0xFF5669FF), CircleShape)
                            .padding(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.up_down_arrow),
                            contentDescription = "Switch",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }

            Text(
                text = "To",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontWeight = FontWeight.Medium
            )
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                placeholder = { Text("Choose Arrival at") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFE8E8E8),
                    focusedBorderColor = Color(0xFF5669FF)
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Text(
                text = "Departure Date",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 16.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = selectedDate,
                    onValueChange = {},
                    placeholder = { Text("Select Date") },
                    modifier = Modifier
                        .weight(1f)
                        .height(55.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFE8E8E8),
                        focusedBorderColor = Color(0xFF5669FF)
                    )
                )

                FilledIconButton(
                    onClick = { },
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .wrapContentSize(),
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = Color(0xFF5669FF)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.date),
                        contentDescription = "Filter",
                        tint = Color.White,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PassengerCounter(
                    label = "Adult (12+)",
                    count = adultCount,
                    onCountChange = onAdultCountChange,
                    modifier = Modifier.weight(0.3f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                PassengerCounter(
                    label = "Child (2-12)",
                    count = childCount,
                    onCountChange = onChildCountChange,
                    modifier = Modifier.weight(0.3f)
                )
            }

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .padding(8.dp)
                    .height(50.dp)
                    .fillMaxWidth(),
                border = BorderStroke(2.dp, Color(0xFF5669FF)),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Search Flight",
                    color = Color(0xFF5669FF),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun OpenDatePickerDialog(context: Context, onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()

    val datePickerDialog = remember {
        android.app.DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                onDateSelected(selectedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    datePickerDialog.show()
}

@Composable
fun PassengerCounter(
    label: String,
    count: Int,
    onCountChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(10.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { if (count > 0) onCountChange(count - 1) },
                modifier = Modifier
                    .size(32.dp)
                    .shadow(4.dp, RoundedCornerShape(8.dp))
                    .background(Color(0xFFFFFFFF), RoundedCornerShape(8.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = "Decrease",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
            }

            Text(
                textAlign = TextAlign.Center,
                text = String.format("%02d", count),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )

            IconButton(
                onClick = { onCountChange(count + 1) },
                modifier = Modifier
                    .size(20.dp)
                    .shadow(4.dp, RoundedCornerShape(8.dp))
                    .background(Color(0xFF5669FF), RoundedCornerShape(8.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "Increase",
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}



@Composable
fun WelcomeSection() {
    Column {
        Text(
            text = "Good Morning, Shreya...",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF898989),
            fontWeight = FontWeight.Normal
        )
        Text(
            text = "Make a plan for the weekend",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF222222),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun NavigationCards(items: List<NavigationItem>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        items(items) { item ->
            NavigationCard(item)
        }
    }
}

@Composable
fun NavigationCard(item: NavigationItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(80.dp)
    ) {
        Card(
            modifier = Modifier
                .size(64.dp)
                .border(
                    2.dp,
                    if (item.title == "Flights") Color(0xFF5669FF) else Color.White,
                    MaterialTheme.shapes.extraLarge
                ),
            shape = MaterialTheme.shapes.extraLarge,
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (item.title == "Flights") Color(0xFFFFFFFF) else Color.White
            )
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.title,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Text(
            text = item.title,
            style = MaterialTheme.typography.bodyMedium,
            color = if (item.title == "Flights") Color(0xFF5669FF) else Color(0xFF898989),
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun SectionHeader(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "See all",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF674DEE),
                modifier = Modifier.clickable { }
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = Color(0xFF674DEE),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun OffersList() {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(vertical = 8.dp)
    ) {
        OfferCard(
            title = "Cupid's Gift for Couples",
            discount = "Up to 30% OFF",
            buttonText = "View Detail",
            imageRes = R.drawable.your_image
        )
        OfferCard(
            title = "Jaisi Zindagi Offers",
            discount = "Up to 40% OFF",
            buttonText = "View Detail",
            imageRes = R.drawable.your_second_image
        )
    }
}

@Composable
fun OfferCard(title: String, discount: String, buttonText: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .width(280.dp)
            .padding(end = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                    fontSize = 12.sp
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = discount,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = buttonText,
                        style = TextStyle(
                            color = Color(0xFF674DEE),
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            textDecoration = TextDecoration.Underline
                        ),
                        modifier = Modifier
                            .clickable { }
                    )
                }
            }
        }
    }
}


@Composable
fun WinterJourney() {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(vertical = 8.dp)
    ) {
        LocationCard(
            name = "Shimla Best Kept",
            location = "Seceret",
            imageRes = R.drawable.shimla
        )
        LocationCard(
            name = "Charming Kasol",
            location = "Vibes",
            imageRes = R.drawable.kasol
        )
    }
}

@Composable
fun LocationCard(name: String, location: String, @DrawableRes imageRes: Int) {
    Card(
        modifier = Modifier
            .width(220.dp)
            .padding(end = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .height(150.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
                Text(
                    text = location,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
        }
    }
}

@Composable
fun PopularLocations() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            LocationCard(
                imageRes = R.drawable.eiffel_tower,
                title = "Eiffel Tower",
                location = "Paris Eyfel Kulesi",
                distance = "2450 KMS"
            )
            Spacer(modifier = Modifier.width(16.dp))
            LocationCard(
                imageRes = R.drawable.beautiful_china,
                title = "Beautiful China",
                location = "Shanghai, China",
                distance = "2450 KMS"
            )
        }
    }
}

@Composable
fun LocationCard(
    @DrawableRes imageRes: Int,
    title: String,
    location: String,
    distance: String
) {
    Card(
        modifier = Modifier.width(210.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.height(290.dp)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
            }

            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )

                    Image(
                        painter = painterResource(id = R.drawable.bookmarkborder),
                        contentDescription = "Bookmark",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(Color(0xFF674DEE))
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = location,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                        Text(
                            text = distance,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFF674DEE)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun BtnJournies() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF7E57FF),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center // Ensures the Row is centered
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.wrapContentWidth() // Ensures Row only takes up space it needs
            ) {
                Image(
                    painter = painterResource(R.drawable.cartgift),
                    contentDescription = "Journies",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "1/10 Journies",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun TravelAppBottomBar() {
    BottomAppBar(
        containerColor = Color.White,
        contentColor = Color(0xFF898989)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { }) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF6C19D8), shape = CircleShape)
                        .padding(12.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "Home",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.briefcase),
                    contentDescription = "Briefcase",
                    tint = Color(0xFF898989),
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.bookmark),
                    contentDescription = "Bookmark",
                    tint = Color(0xFF898989),
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "Profile",
                    tint = Color(0xFF898989),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}


@Composable
fun SelectedDate(){

    var showDatePickerDialog by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = "selectedDate",
            onValueChange = { },
            modifier = Modifier
                .padding(vertical = 8.dp)
                .clickable { showDatePickerDialog = true },
            placeholder = { Text("Select Date") },
            readOnly = true,

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Decimal
            ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFE8E8E8),
                focusedBorderColor = Color(0xFF5669FF)
            ),
            shape = RoundedCornerShape(8.dp)
        )

        FilledIconButton(
            onClick = { },
            modifier = Modifier
                .padding(start = 10.dp)
                .wrapContentSize(),
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color(0xFF5669FF)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.date),
                contentDescription = "Filter",
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
        }

    }
}