package com.example.gestordetareas1

import androidx.compose.runtime.mutableStateListOf

object Datostarea {
    val tareas = mutableStateListOf(
        Tarea(
            1,
            "Investigar Kotlin",
            "Programación",
            "Investigar las características de Kotlin"
        ),
        Tarea(
            2,
            "Crear una base de datos",
            "Base de Datos",
            "Diseñar una base de datos relacional"
        ),
        Tarea(
            3,
            "Realizar exposición",
            "Ingeniería de Software",
            "Preparar presentación del proyecto"
        )
    )

    private var siguienteId = 4

    fun agregar(
        titulo: String,
        asignatura: String,
        descripcion: String
    ) {
        val nuevaTarea = Tarea(
            id = siguienteId++,
            titulo = titulo,
            asignatura = asignatura,
            descripcion = descripcion
        )

        tareas.add(nuevaTarea)
    }

    fun buscar(id: Int): Tarea? {
        return tareas.find { it.id == id }
    }
}