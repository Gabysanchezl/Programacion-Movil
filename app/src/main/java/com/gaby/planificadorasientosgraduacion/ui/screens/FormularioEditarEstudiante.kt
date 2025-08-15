package com.gaby.planificadorasientosgraduacion.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gaby.planificadorasientosgraduacion.data.Estudiante
import com.gaby.planificadorasientosgraduacion.viewmodels.PlanificadorViewModel
import com.gaby.planificadorasientosgraduacion.ui.components.DropdownMenuCarrera

@Composable
fun FormularioEditarEstudiante(
    estudiante: Estudiante,
    onDismiss: () -> Unit,
    onGuardar: (Estudiante) -> Unit,
    viewModel: PlanificadorViewModel = viewModel()
) {
    var nombre by remember { mutableStateOf(estudiante.nombre) }
    var matricula by remember { mutableStateOf(estudiante.id) }
    var carreraSeleccionada by remember { mutableStateOf(estudiante.carrera) }
    var merito by remember { mutableStateOf(estudiante.merito) }

    var guardando by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (guardando) 0.95f else 1f, label = "")

    val carrerasDisponibles = listOf("Sin carrera") + viewModel.listadoEstudiantes
        .mapNotNull { it.carrera }
        .distinct()
        .sorted()

    val camposValidos = nombre.isNotBlank() && matricula.isNotBlank()

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = if (estudiante.id.isBlank()) "Agregar Estudiante" else "Editar Estudiante",
                style = MaterialTheme.typography.headlineSmall
            )
        },
        text = {
            Column {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre completo") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = matricula,
                    onValueChange = { matricula = it },
                    label = { Text("Matrícula") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))

                DropdownMenuCarrera(
                    opciones = carrerasDisponibles,
                    seleccionActual = carreraSeleccionada.ifBlank { "Sin carrera" },
                    onSeleccionar = { carreraSeleccionada = it }
                )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = merito,
                    onValueChange = { merito = it },
                    label = { Text("Mérito") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (camposValidos) {
                        guardando = true
                        val estudianteEditado = estudiante.copy(
                            nombre = nombre.trim(),
                            id = matricula.trim(),
                            carrera = if (carreraSeleccionada == "Sin carrera") "" else carreraSeleccionada.trim(),
                            merito = merito.trim()
                        )
                        onGuardar(estudianteEditado)
                        onDismiss()
                    }
                },
                modifier = Modifier.scale(scale),
                enabled = camposValidos
            ) {
                Text("Guardar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}
