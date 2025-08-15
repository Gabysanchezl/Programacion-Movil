package com.gaby.planificadorasientosgraduacion.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.gaby.planificadorasientosgraduacion.viewmodels.PlanificadorViewModel

@Composable
fun PantallaConsultaSeccion(navController: NavController) {
    var matricula by remember { mutableStateOf("") }

    val colorScheme = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography
    val context = LocalContext.current
    val viewModel: PlanificadorViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.inicializar(context)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(top = 30.dp, start = 5.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Volver",
                tint = colorScheme.onBackground
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Consulta tu Sección",
                style = typography.headlineSmall,
                color = colorScheme.primary
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = matricula,
                onValueChange = { matricula = it },
                label = {
                    Text(
                        text = "Matrícula",
                        style = typography.labelLarge,
                        color = colorScheme.onSurfaceVariant
                    )
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                textStyle = typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    val estudiante = viewModel.obtenerEstudiantePorId(matricula)
                    val asiento = viewModel.listadoAsientos.find { it.idEstudiante == matricula }

                    if (estudiante != null && asiento != null) {
                        navController.navigate("resultado_consulta/${estudiante.nombre}/${asiento.codigo}")
                    } else {
                        Toast.makeText(context, "No se encontró asignación para esta matrícula", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.primary,
                    contentColor = colorScheme.onPrimary
                )
            ) {
                Text("Consultar", style = typography.labelLarge)
            }

        }
    }
}
