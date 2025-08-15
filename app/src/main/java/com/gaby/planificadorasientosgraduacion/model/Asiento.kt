package com.gaby.planificadorasientosgraduacion.model

data class Asiento(
    val codigo: String,
    val idEstudiante: String? = null,
    val carrera: String? = null,
    val x: Float,
    val y: Float,
)