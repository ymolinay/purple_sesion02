package com.purple.myapps02

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun DetailScreen(itemId: String?) {
    val touristSpot = TouristSpotData.touristSpots.find { it.id == itemId }

    if (touristSpot != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(touristSpot.bannerUrl)
                    .crossfade(true)
                    .placeholder(R.drawable.placeholder_gray)
                    .build(),
                contentDescription = touristSpot.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = touristSpot.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            RatingDisplay(rating = touristSpot.rating, small = false)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = touristSpot.description)

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }
        }
    } else {
        Text("Lugar turístico no encontrado")
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(itemId = TouristSpotData.touristSpots.first().id)
}