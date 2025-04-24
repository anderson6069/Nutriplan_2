package com.example.nutriplan_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.nutriplan_2.ui.theme.Nutriplan_2Theme
import com.example.nutriplan_2.MainScreen
import com.example.nutriplan_2.DetailsScreen
import com.example.nutriplan_2.SettingsScreen
import com.example.nutriplan_2.LoginScreen
import com.example.nutriplan_2.RegisterScreen
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nutriplan_2Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(navController = navController, startDestination = "login", Modifier.padding(innerPadding)) {
            // Pantalla de login
            composable("login") { LoginScreen(navController) }

            // Pantalla de registro
            composable("register") { RegisterScreen(navController) }

            // Pantalla principal
            composable("main") { MainScreen(navController) }

            // Pantalla de detalles
            composable(
                "details/{nombre}/{peso}/{altura}/{edad}/{objetivo}",
                arguments = listOf(
                    navArgument("nombre") { type = NavType.StringType },
                    navArgument("peso") { type = NavType.StringType },
                    navArgument("altura") { type = NavType.StringType },
                    navArgument("edad") { type = NavType.StringType },
                    navArgument("objetivo") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
                val peso = backStackEntry.arguments?.getString("peso") ?: "0"
                val altura = backStackEntry.arguments?.getString("altura") ?: "0"
                val edad = backStackEntry.arguments?.getString("edad") ?: "0"
                val objetivo = backStackEntry.arguments?.getString("objetivo") ?: ""

                DetailsScreen(navController, nombre, peso, altura, edad, objetivo)
            }

            // Pantalla de configuración
            composable("settings") { SettingsScreen() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    Nutriplan_2Theme {
        MyApp()
    }
}
