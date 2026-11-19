package com.example.gestordetareas1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Navegacion()
            }
        }
    }
}

@Composable
fun GestorApp() {
    Text(text = "¡Bienvenido a Gestor de Tareas!")
}