package com.example.gestordetareas1

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navegacion() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lista"
    ) {

        composable("lista") {
            PantallaTareas(
                onNuevaTarea = {
                    navController.navigate("nueva")
                },
                onVerDetalle = { id ->
                    navController.navigate("detalle/$id")
                }
            )
        }


        composable("nueva") {
            PantallaNuevaTarea(
                onTareaGuardada = { navController.popBackStack() }
            )
        }

        composable("detalle/{id}") { backStackEntry ->
            val idString = backStackEntry.arguments?.getString("id")
            val id = idString?.toIntOrNull() ?: -1
            val tarea = Datostarea.buscar(id)

            if (tarea != null) {
                PantallaDetalle(
                    titulo = tarea.titulo,
                    asignatura = tarea.asignatura,
                    descripcion = tarea.descripcion,
                    onVolver = { navController.popBackStack() }
                )
            } else {
                androidx.compose.material3.Text(
                    text = "No se encontró la tarea."
                )
            }
        }

        composable("detalle") {
            PantallaDetalle(
                titulo = "Investigar Kotlin",
                asignatura = "Programación",
                descripcion = "Investigar los fundamentos de Kotlin",
                onVolver = { navController.popBackStack() }
            )
        }
    }
}