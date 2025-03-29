package com.example.nutriplan_2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, nombre: String, peso: String, altura: String, edad: String, objetivo: String) {
    val plan = generarPlanNutricional(peso.toDoubleOrNull() ?: 0.0, altura.toDoubleOrNull() ?: 0.0, edad.toIntOrNull() ?: 0, objetivo)

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Hola $nombre,", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Tu plan nutricional es:", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = plan, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Regresar")
        }
    }
}

fun generarPlanNutricional(peso: Double, altura: Double, edad: Int, objetivo: String?): String {
    return when (objetivo?.lowercase()) {
        "perder peso" -> "Dieta baja en carbohidratos con 1500 kcal/día."
        "mantener" -> "Dieta balanceada con 2000 kcal/día."
        "ganar músculo" -> "Dieta alta en proteínas con 2500 kcal/día."
        else -> "Por favor, ingresa un objetivo válido."
    }
}

