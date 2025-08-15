package com.gaby.planificadorasientosgraduacion.ui.screens

 import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
 import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
 import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import com.gaby.planificadorasientosgraduacion.ui.components.DropdownMenuCarrera
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
 import com.gaby.planificadorasientosgraduacion.data.Estudiante
import com.gaby.planificadorasientosgraduacion.model.Asiento
import kotlinx.coroutines.launch
import kotlin.collections.filter
 import androidx.compose.foundation.lazy.items

@Composable
fun PopupGestionAsiento(
    asiento: Asiento,
    estudiantesDisponibles: List<Estudiante>,
    onDismiss: () -> Unit,
    onActualizarAsiento: (Asiento) -> Unit
) {
    val scope = rememberCoroutineScope()                    //pa lanzar coroutines desde este composable
    var carreraSeleccionada by remember { mutableStateOf(asiento.carrera ?: "") }    //vacio sin carrera asignada //Se actualiza al actualziar el drpdnwmenu
    var filtroTexto by remember { mutableStateOf("") }
    var estudianteSeleccionado by remember {
        mutableStateOf(
            estudiantesDisponibles.find { it.id == asiento.idEstudiante }
        )
    }

    val carrerasDisponibles = listOf("Software", "Educacion", "Administracion", "Cibersecurity")

    val estudiantesFiltrados = estudiantesDisponibles
        .filter { it.id.isNotBlank() }      //Filtro estudiantes que tienen ID válido
        .filter { carreraSeleccionada.isBlank() || it.carrera == carreraSeleccionada }
        .filter {                              //búsqueda por nombre o matrícula
            it.nombre.contains(filtroTexto, ignoreCase = true) ||
                    it.id.contains(filtroTexto, ignoreCase = true)
        }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Gestionar Asiento", style = MaterialTheme.typography.headlineSmall)
        },
        text = {
            Column {
                Text("Carrera asignada:")
                Spacer(modifier = Modifier.height(8.dp))

                DropdownMenuCarrera(
                    opciones = carrerasDisponibles,
                    seleccionActual = carreraSeleccionada,
                    onSeleccionar = { carreraSeleccionada = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = filtroTexto,
                    onValueChange = { filtroTexto = it },
                    label = { Text("Buscar estudiante") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn(modifier = Modifier.height(200.dp)) {
                    items(estudiantesFiltrados) { estudiante ->
                        EstudianteItem(
                            estudiante = estudiante,
                            isSelected = estudianteSeleccionado?.id == estudiante.id,
                            onClick = { estudianteSeleccionado = estudiante
                                if (carreraSeleccionada.isBlank()) { //Aunque no seleccione carrera primero, el asiento tomara el del estudiante seleccionado
                                    carreraSeleccionada = estudiante.carrera
                                }
                            }
                        )
                    }
                }

                if (estudiantesFiltrados.isEmpty()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        "No hay estudiantes disponibles para esta carrera.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            val nuevoAsiento = asiento.copy(
                                idEstudiante = estudianteSeleccionado?.id,
                                carrera = carreraSeleccionada
                            )
                            scope.launch { onActualizarAsiento(nuevoAsiento) }
                        },
                        enabled = estudianteSeleccionado != null || carreraSeleccionada.isNotBlank()
                    ) {
                        Text("Asignar / Actualizar")
                    }

                    OutlinedButton(
                        onClick = {
                            val nuevoAsiento = asiento.copy(idEstudiante = null)
                            scope.launch { onActualizarAsiento(nuevoAsiento) }
                        },
                        enabled = asiento.idEstudiante != null
                    ) {
                        Text("Desasignar estudiante")
                    }

                    OutlinedButton(
                        onClick = {
                            val nuevoAsiento = asiento.copy(idEstudiante = null, carrera = null)
                            scope.launch { onActualizarAsiento(nuevoAsiento) }
                        }
                    ) {
                        Text("Vaciar asiento")
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Cerrar")
            }
        }
    )
}

@Composable
fun EstudianteItem(
    estudiante: Estudiante,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor by animateColorAsState(
        if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f) else Color.Transparent
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Column {

            Text("👤 ${estudiante.nombre}", style = MaterialTheme.typography.bodyLarge)
            Text("📚 Matrícula: ${estudiante.id}", style = MaterialTheme.typography.bodySmall)
            Text("🏫 Carrera: ${estudiante.carrera}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
