@file:SuppressLint("UnusedBoxWithConstraintsScope")
package com.gaby.planificadorasientosgraduacion.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gaby.planificadorasientosgraduacion.R
import com.gaby.planificadorasientosgraduacion.model.Asiento
import com.gaby.planificadorasientosgraduacion.viewmodels.PlanificadorViewModel
import kotlinx.coroutines.launch
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color


@Composable
fun PantallaPlanoAsientos(
    navController: NavController,
    viewModel: PlanificadorViewModel = viewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val listadoAsientos by remember { derivedStateOf { viewModel.listadoAsientos } }

    LaunchedEffect(Unit) {
        viewModel.inicializar(context)
    }

    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    var asientoSeleccionado by remember { mutableStateOf<Asiento?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.scrim.copy(alpha = 0.6f))
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(30.dp)
                .zIndex(10f)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Cerrar",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.medium
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTransformGestures { _, pan, zoom, _ ->
                            scale = (scale * zoom).coerceIn(0.5f, 4f)
                            offset += pan
                        }
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.teatro01),
                    contentDescription = "Plano del Teatro",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )

                BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                    val density = LocalDensity.current
                    val screenWidth = constraints.maxWidth.toFloat()
                    val screenHeight = constraints.maxHeight.toFloat()

                    listadoAsientos.forEach { asiento ->
                        val baseColor = when (asiento.carrera) {
                            "Software" -> MaterialTheme.colorScheme.primary
                            "Educacion" -> MaterialTheme.colorScheme.tertiary
                            "Administracion" -> Color(0xFFFFB74D)
                            "Cibersecurity" ->  Color(0xFF3949AB)
                            else -> MaterialTheme.colorScheme.surfaceVariant
                        }

                        val colorAsiento = when {
                            asiento.idEstudiante != null -> baseColor
                            asiento.carrera != null -> baseColor.copy(alpha = 0.3f)
                            else -> MaterialTheme.colorScheme.surfaceVariant
                        }

                        val offsetX = with(density) { (screenWidth * asiento.x).toInt().toDp() }
                                                //screenWidth * asiento.x calcula la posición en píxeles del asiento en el eje X
                        val offsetY = with(density) { (screenHeight * asiento.y).toInt().toDp() }
                            //with(density) hace la conversión entre píxeles usando la densidad del phoone (tamanito)
                        Box(
                            modifier = Modifier
                                .offset(x = offsetX, y = offsetY)
                                .size(15.dp)
                                .background(colorAsiento, shape = CircleShape)
                                .clickable {
                                    asientoSeleccionado = asiento
                                }
                        )
                    }
                }

                asientoSeleccionado?.let { asiento ->
                    val estudiantesAsignadosIds = listadoAsientos.mapNotNull { it.idEstudiante }.toSet()

                    // Filtra los estudiantes disponibles: solo los que NO están asignados o el que ya está asignado a este asiento.
                    val estudiantesDisponiblesFiltrados = viewModel.listadoEstudiantes.filter {
                        it.id == asiento.idEstudiante || it.id !in estudiantesAsignadosIds
                    }

                    PopupGestionAsiento(
                        asiento = asiento,
                        estudiantesDisponibles = estudiantesDisponiblesFiltrados,
                        onDismiss = { asientoSeleccionado = null },
                        onActualizarAsiento = { nuevoAsiento ->
                            coroutineScope.launch {
                                viewModel.actualizarAsiento(nuevoAsiento, context)
                                asientoSeleccionado = null
                            }
                        }
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .zIndex(10f)
        ) {
            LeyendaColoresCarreras()
        }
    }
}






@Composable
fun LeyendaColoresCarreras() {
    val carrerasConColor = listOf(
        "Software" to MaterialTheme.colorScheme.primary,
        "Educacion" to MaterialTheme.colorScheme.tertiary,
        "Administracion" to Color(0xFFFFB74D),
        "Cibersecurity" to  Color(0xFF3949AB)
    )

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.3f), shape = RoundedCornerShape(8.dp))
            .padding(12.dp)
            .width(IntrinsicSize.Max)
    ) {
        Text("Leyenda de Carreras", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))
        carrerasConColor.forEach { (nombre, color) ->
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 4.dp)) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(color, shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(nombre, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
