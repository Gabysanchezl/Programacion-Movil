package com.gaby.planificadorasientosgraduacion.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.draw.scale
import com.gaby.planificadorasientosgraduacion.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun EncabezadoAdmin() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Perfil",
            modifier = Modifier
                .size(60.dp)
                .padding(top = 1.dp, end = 12.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Column {
            Text("Administrador", style = MaterialTheme.typography.labelLarge)
            Text("Bienvenido al Dashboard!", style = MaterialTheme.typography.titleMedium)

        }
    }
}



@Composable
fun AdminHomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            EncabezadoAdmin()
            Buscador()

            Spacer(modifier = Modifier.height(32.dp))

            PlanoDeAsientosCard {
                navController.navigate("plano_asientos")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Gestionar",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(start = 12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CardVerticalGestion(
                    titulo = "Estudiantes",
                    descripcion = "Ver lista de estudiantes, agregar nuevos y consultar sus asientos asignados.",
                    imageId = R.drawable.ic_estudiante,
                    onClick = { navController.navigate("lista_estudiantes") },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun Buscador() {
    Spacer(modifier = Modifier.height(16.dp))
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Search Name / ID") },
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun PlanoDeAsientosCard(onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Asignar Asientos",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Haz click para ver el mapa de asientos y asignar un estudiante.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Image(
                painter = painterResource(id = R.drawable.preview_teatro),
                contentDescription = "Preview teatro",
                modifier = Modifier.size(130.dp)
            )
        }
    }

}

@Composable
fun CardVerticalGestion(
    titulo: String,
    descripcion: String,
    imageId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var pressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = (if (pressed) 0.95f else 1f) )  //mi animacion de push :v
    val scope = rememberCoroutineScope()

    Card(
        modifier = modifier
            .height(220.dp)
            .scale(scale) // aqui se aplica mi escala "animada"
            .clickable {
                scope.launch {
                    pressed = true
                    delay(100)
                    pressed = false
                    onClick()
                }
            },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = titulo,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = descripcion,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                maxLines = 3
            )
            Spacer(modifier = Modifier.width(50.dp))

            Image(
                painter = painterResource(id = imageId),
                contentDescription = titulo,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            )
        }
    }
}

