package com.purple.myapps02

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.max
import kotlin.math.min

@Composable
fun RatingDisplay(rating: Double, small: Boolean = true) {
    val maxRating = 5
    val clampedRating = min(max(0.0, rating), maxRating.toDouble())
    val filledStars = clampedRating.toInt()
    val showHalfStar = clampedRating - filledStars >= 0.5
    val starSize = if (small) 18.dp else 24.dp

    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        // Estrellas completas
        for (i in 1..filledStars) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Estrella completa",
                modifier = Modifier.size(starSize),
                tint = Color.Yellow
            )
        }

        // Media estrella
        if (showHalfStar) {
            Icon(
                imageVector = Icons.Filled.StarHalf,
                contentDescription = "Media estrella",
                modifier = Modifier.size(starSize),
                tint = Color.Yellow
            )
        }

        // Estrellas vacías
        val emptyStars = max(0, maxRating - filledStars - if (showHalfStar) 1 else 0)
        for (i in 1..emptyStars) {
            Icon(
                imageVector = Icons.Outlined.StarBorder,
                contentDescription = "Estrella vacía",
                modifier = Modifier.size(starSize),
                tint = Color.Yellow
            )
        }
    }
}

@Preview
@Composable
fun RatingDisplayPreview() {
    Column {
        RatingDisplay(rating = 0.7)
        RatingDisplay(rating = 4.6)
        RatingDisplay(rating = 3.5)
        RatingDisplay(rating = 2.3)
        RatingDisplay(rating = 23.5)
        RatingDisplay(rating = 0.0, small = false)
        RatingDisplay(rating = -3.2)
    }
}