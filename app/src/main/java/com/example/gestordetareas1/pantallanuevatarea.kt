package com.example.gestordetareas1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaNuevaTarea(
    onTareaGuardada: () -> Unit = {}
) {
    var titulo by remember { mutableStateOf("") }
    var asignatura by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Nueva tarea",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título de la tarea") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = asignatura,
            onValueChange = { asignatura = it },
            label = { Text("Asignatura") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                error = when {
                    titulo.isBlank() -> "El título es obligatorio."
                    titulo.trim().length < 3 -> "El título debe tener al menos 3 caracteres."
                    asignatura.isBlank() -> "La asignatura es obligatoria."
                    descripcion.isBlank() -> "La descripción es obligatoria."
                    else -> ""
                }

                if (error.isEmpty()) {
                    Datostarea.agregar(
                        titulo.trim(),
                        asignatura.trim(),
                        descripcion.trim()
                    )

                    mensaje = "¡Tarea registrada correctamente!"
                    titulo = ""
                    asignatura = ""
                    descripcion = ""

                    onTareaGuardada()
                } else {
                    mensaje = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar tarea")
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (error.isNotEmpty()) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error
            )
        }

        if (mensaje.isNotEmpty()) {
            Text(
                text = mensaje,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
