package com.example.gestordetareas1
data class Tarea(
    val id: Int,
    val titulo: String,
    val asignatura: String,
    val descripcion: String,
    val completada: Boolean = false
)
