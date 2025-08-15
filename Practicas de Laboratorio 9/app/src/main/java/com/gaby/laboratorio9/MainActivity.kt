package com.gaby.laboratorio9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
 import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
 import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
 import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val scrollState = rememberScrollState()

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(scrollState)
            ){
                Spacer(modifier = Modifier.height(10.dp))

                ContadorDeClics()
                Spacer(modifier = Modifier.height(5.dp))

                MensajeSecreto()
                Spacer(modifier = Modifier.height(10.dp))

                EspejoDeTexto ()
                Spacer(modifier = Modifier.height(10.dp))

                AppDeSaludos()
                Spacer(modifier = Modifier.height(5.dp))

                ContadorDeClicsTWOTWO()
                Spacer(modifier = Modifier.height(5.dp))

                CambiadorDeColor ()
                Spacer(modifier = Modifier.height(5.dp))


                FormularioSimple()
                Spacer(modifier = Modifier.height(5.dp))

                TarjetaExpandible ()
                Spacer(modifier = Modifier.height(5.dp))

                //ListaDeTareas()
           //     Spacer(modifier = Modifier.height(5.dp))

                EditorDeTextoConContador()

            }
            }

        }
    }


@Composable
fun ContadorDeClics( ) {

    var contador by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text( text = "$contador")

            Button(
                onClick = {
                    contador++
                }
            ){
                Text("Click Me!")
            }
        }
    }
}

@Composable
fun MensajeSecreto(){

    var mostrarMensaje by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Button(
                onClick = {
                    mostrarMensaje = !mostrarMensaje

                }
            ){
                Text("Revelar Secreto!")
            }

            if (mostrarMensaje){
                Text(text= "Le tienes miedos a las hormigas!", modifier = Modifier.padding(top=10.dp) )
            }
        }
    }
}

@Composable
fun EspejoDeTexto (){

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var texto by remember { mutableStateOf("") }
            TextField(texto, { texto = it }, modifier = Modifier.height(45.dp))
            Text("Estas escribiendo: $texto", modifier = Modifier.padding(top = 5.dp))
        }
    }
}

@Composable
fun AppDeSaludos(){

    var nombre by remember { mutableStateOf("") }
    var saludo by remember { mutableStateOf("") }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Escriba su  nombre por favor:!", style= MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(5.dp))

            TextField(nombre, { nombre = it }, modifier = Modifier.height(45.dp))
            Button( modifier = Modifier.padding(top=  5.dp),

                onClick = {
                    saludo = "¡Hola, $nombre!"
                }
            ) {
                Text("Saludar!", style= MaterialTheme.typography.bodySmall)
            }

            Text(saludo, style= MaterialTheme.typography.bodySmall)
        }
    }
}


@Composable
fun ContadorDeClicsTWOTWO() {

    var contador by rememberSaveable { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text( text = "$contador")

            Button(
                onClick = {
                    contador++
                }
            ){
                Text("Click Me!")
            }
        }
    }
}


@Composable
fun CambiadorDeColor () {

    var color by remember { mutableStateOf(Color.Gray) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().align(Alignment.Center).background(color),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                    Button(
                        onClick = {
                            color = Color(
                                Random.nextInt(256),
                                Random.nextInt(256),
                                Random.nextInt(256))

                        }
                    ) {
                        Text("Cambia Color")
                    }
            }
        }
    }

@Composable
fun FormularioSimple(){

    var miTexto by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            miTexto,
            { miTexto = it },
            label = { Text("Define este botón") },
            modifier = Modifier.height(45.dp)
        )
        Spacer(modifier = Modifier.height(16.dp)) // Un poco de espacio entre el TextField y el botón

        Button(
            enabled = miTexto.isNotEmpty(),
            onClick = {
                println(miTexto)
            }
        ) {
            Text(miTexto)
        }
    }
}

@Composable
fun TarjetaExpandible () {
    var expandido by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.padding(start = 50.dp, top = 10.dp, ).border(width = 1.dp, color = Color.Black)
                .clickable { expandido = !expandido },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(text = "Haz clic para ver más", modifier = Modifier.padding(20.dp))
            if (expandido) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Aquí está el contenido expandido...", modifier = Modifier.padding(20.dp))
            }

        }
    }


/*
@Composable
fun ListaDeTareas() {
    var nuevaTarea by remember { mutableStateOf("") }
    val tareas = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.padding(16.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = nuevaTarea,
                onValueChange = { nuevaTarea = it },
                label = { Text("Agrega una nueva tarea") },
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    if (nuevaTarea.isNotBlank()) {
                        tareas.add(nuevaTarea)
                        nuevaTarea = ""
                    }
                }
            ) {
                Text("Añadir")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(tareas) { tarea ->
                Text(text = "• $tarea", modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}
*/


@Composable
fun EditorDeTextoConContador(){

    var texto2 by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(texto2, { texto2 = it }, modifier = Modifier.height(45.dp))

        Text("Caracteres escritos: ${texto2.length} / 140", modifier = Modifier.align(Alignment.End))

    }

}