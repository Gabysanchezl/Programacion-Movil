package com.gaby.planificadorasientosgraduacion.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gaby.planificadorasientosgraduacion.data.Estudiante
import com.gaby.planificadorasientosgraduacion.viewmodels.PlanificadorViewModel
import com.gaby.planificadorasientosgraduacion.ui.components.DropdownMenuCarrera

@Composable
fun PantallaListaEstudiantes(
    navController: NavController,
    viewModel: PlanificadorViewModel = viewModel()
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.inicializar(context)
    }

    val estudiantes = viewModel.listadoEstudiantes
    val asientos = viewModel.listadoAsientos

    var searchText by remember { mutableStateOf("") }
    var carreraSeleccionada by remember { mutableStateOf("Todas") }
    var estudianteSeleccionado by remember { mutableStateOf<Estudiante?>(null) }

    val carrerasDisponibles = listOf("Todas") + estudiantes.mapNotNull { it.carrera }.distinct()

    val estudiantesFiltrados = estudiantes.filter {
        (carreraSeleccionada == "Todas" || it.carrera == carreraSeleccionada) &&
                (it.nombre.contains(searchText, ignoreCase = true) || it.id.contains(searchText, ignoreCase = true))
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                estudianteSeleccionado = Estudiante(id = "", nombre = "", carrera = "", merito = "")
            }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar Estudiante")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(top = 30.dp, start = 8.dp)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp, start = 16.dp, end = 16.dp)
            ) {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    label = { Text("Buscar por nombre o matrícula") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                DropdownMenuCarrera(
                    opciones = carrerasDisponibles,
                    seleccionActual = carreraSeleccionada,
                    onSeleccionar = { carreraSeleccionada = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(estudiantesFiltrados) { estudiante ->
                        val asiento = asientos.find { it.idEstudiante == estudiante.id }

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            elevation = CardDefaults.cardElevation(4.dp),
                            colors = if (asiento != null)
                                CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
                            else
                                CardDefaults.cardColors()
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(estudiante.nombre, style = MaterialTheme.typography.titleMedium)
                                    Text("🎓 Carrera: ${estudiante.carrera}")
                                    Text("📚 Matrícula: ${estudiante.id}")
                                    Text("⭐ Mérito: ${estudiante.merito}")
                                    Text("🪑 Asiento: ${asiento?.codigo ?: "Sin asignar"}")
                                }
                                Column(horizontalAlignment = Alignment.End) {
                                    IconButton(onClick = {
                                        estudianteSeleccionado = estudiante
                                    }) {
                                        Icon(Icons.Default.Edit, contentDescription = "Editar")
                                    }
                                    asiento?.let {
                                        IconButton(onClick = {
                                            val asientoDesasignado = it.copy(idEstudiante = null, carrera = null)
                                            viewModel.actualizarAsiento(asientoDesasignado, context)
                                        }) {
                                            Icon(Icons.Default.Delete, contentDescription = "Desasignar asiento")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            estudianteSeleccionado?.let { estudiante ->
                FormularioEditarEstudiante(
                    estudiante = estudiante,
                    onDismiss = { estudianteSeleccionado = null },
                    onGuardar = { estudianteEditado ->
                        viewModel.actualizarEstudianteYGuardar(context, estudianteEditado)
                        estudianteSeleccionado = null
                    }
                )
            }
        }
    }
}

