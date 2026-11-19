package com.example.gestordetareas1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaTareas(
    onNuevaTarea: () -> Unit = {},
    onVerDetalle: (Int) -> Unit = {}
) {
    val tareas = Datostarea.tareas
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Mis tareas",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onNuevaTarea,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("+ Nueva tarea")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(tareas) { tarea ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable { onVerDetalle(tarea.id) }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = tarea.titulo,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(text = "Asignatura: ${tarea.asignatura}")
                        Text(text = tarea.descripcion)
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Button(onClick = { onVerDetalle(tarea.id) }) {
                            Text("Ver detalle")
                        }
                    }
                }
            }
        }
    }
}

