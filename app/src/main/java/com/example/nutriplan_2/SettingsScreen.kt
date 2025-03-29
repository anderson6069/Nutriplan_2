package com.example.nutriplan_2

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    var color by remember { mutableStateOf("Azul") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Pantalla de Configuración", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { color = if (color == "Azul") "Rojo" else "Azul" }) {
            Text("Cambiar Color ($color)")
        }
    }
}