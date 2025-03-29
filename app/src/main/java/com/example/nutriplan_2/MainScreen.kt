package com.example.nutriplan_2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var objetivo by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "NutriPlan", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        OutlinedTextField(value = peso, onValueChange = { peso = it }, label = { Text("Peso (kg/lb)") })
        OutlinedTextField(value = altura, onValueChange = { altura = it }, label = { Text("Altura (cm/ft)") })
        OutlinedTextField(value = edad, onValueChange = { edad = it }, label = { Text("Edad") })
        OutlinedTextField(value = objetivo, onValueChange = { objetivo = it }, label = { Text("Objetivo") })

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("details/$nombre/$peso/$altura/$edad/$objetivo")
            }
        ) {
            Text("Generar Plan de Alimentación")
        }
    }
}
