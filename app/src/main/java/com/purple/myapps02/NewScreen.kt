package com.purple.myapps02

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.util.UUID

@Composable
fun NewScreen(navController: NavController, itemId: String? = null) {

    val isEditMode = itemId != null

    var title by remember { mutableStateOf("") }
    var shortDescription by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf(0.0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
    ) {
        Text(
            "${if (isEditMode) "Editar" else "Nuevo"} Lugar Turístico",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = shortDescription,
            onValueChange = { shortDescription = it },
            label = { Text("Descripción corta") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Calificación: $rating")
        Slider(
            value = rating.toFloat(),
            onValueChange = { rating = it.toDouble() },
            valueRange = 0f..5f,
            steps = 9
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val newTouristSpot = TouristSpot(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    shortDescription = shortDescription,
                    description = description,
                    rating = rating,
                    bannerUrl = "https://picsum.photos/200/300" // URL de imagen fija
                )

//                navController.navigateUp() // Volver a HomeScreen después de crear el ítem
            }
        ) {
            if (isEditMode) {
                Text("Guardar")
            } else {
                Text("Crear")
            }
        }

        Button(
            onClick = {
                navController.popBackStack(
                    "home",
                    inclusive = false
                )
            }
        ) {
            Text("Volver")
        }
    }
}

@Preview
@Composable
fun NewScreenPreview() {
    NewScreen(navController = rememberNavController())
}