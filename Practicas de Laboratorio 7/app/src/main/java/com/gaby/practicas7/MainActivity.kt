package com.gaby.practicas7

import android.os.Bundle

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.ui.res.stringResource
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scrollState = rememberScrollState()
                Column(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .verticalScroll(scrollState)
            ) {
                MiPrimerComposable(
                    name = "Jetpack Compose",
                )
                TarjetaDePresentacion(
                    name = "Laura Gabriela Sanchez",
                    titulo = "Estudiante de Software",
                    email = "lgab.sanchez@gmail.com"
                )
                IconosSociales(
                    heart = "🧡",
                    smile = "😁😁",
                    chick = "🐥",
                    )
                Spacer(modifier = Modifier.height(4.dp))


                ArticuloSimple()
                Spacer(modifier = Modifier.height(1.dp))

                PerfilDeUsuario()
                Spacer(modifier = Modifier.height(1.dp))

                CuadriculaSimple()
                Spacer(modifier = Modifier.height(1.dp))

                Column {
                    Spacer(modifier = Modifier.height(6.dp))
                    ItemDeRecibo()
                    ItemDeRecibo()
                    ItemDeRecibo()
                    ItemDeRecibo()
                }
               Column{
                   Spacer(modifier = Modifier.height(6.dp))
                   BarraDeProgreso(0.8F)
                   Spacer(modifier = Modifier.height(4.dp))
                   BarraDeProgreso(0.5F)
                   Spacer(modifier = Modifier.height(6.dp))

               }

                TarjetaDeNoticia()

                PantallaLogin()

        }
    }
    }

}


@Composable
fun MiPrimerComposable(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "¡Hola, $name!",
        modifier = Modifier.fillMaxWidth().padding(start = 50.dp, top= 50.dp, end = 50.dp),
        style = TextStyle(
            fontSize = 25.sp)
    )
}

@Composable
fun TarjetaDePresentacion(name:String, titulo:String, email:String, modifier: Modifier = Modifier){


    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 2.dp, end = 20.dp)      //bottom.number.dp)
    //   .padding(100.dp),
    ){

        Text(
            text = " $name",
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF700A37),
                letterSpacing = 2.sp
            ),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = " $titulo",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Serif,
                color = Color.Gray,
                letterSpacing = 2.sp
            ),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Correo: $email",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Serif,
                color = Color.Gray,
            ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))


    }
}

@Composable
fun IconosSociales(heart: String, smile: String, chick: String, modifier: Modifier = Modifier) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 2.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = " $heart", fontSize = 20.sp)
        Text(text = " $smile", fontSize = 20.sp)
        Text(
            text = " $chick",
            fontSize = 20.sp
        )
    }
}

@Composable
fun ArticuloSimple(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, top = 2.dp, end = 30.dp) ){

        Text(text= "Aprendiendo Jetpack Compose", style = TextStyle (fontSize = 20.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(R.string.parrafo1), textAlign = TextAlign.Justify, fontSize = 16.sp)

    }
}

@Composable
fun PerfilDeUsuario(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, top = 2.dp, end = 30.dp) ){

        Row(  verticalAlignment = Alignment.CenterVertically ){
            Text(text = "👤", style = TextStyle (fontSize = 40.sp, ))
            Spacer(modifier = Modifier.width(10.dp))
                Column (modifier = Modifier.padding(start = 5.dp)){
                    Text(text = "Gabysanchezl", style = TextStyle (fontSize = 30.sp))
                    Text(text = "En linea", style = TextStyle (fontSize = 20.sp))
                }
        }
    }
}

@Composable
fun CuadriculaSimple(){
    Column(modifier = Modifier
        .padding(start = 50.dp, top = 2.dp, end = 50.dp)
        .width(100.dp)
        .height(100.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
            )
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier.weight(1f)
                    .fillMaxHeight()
                    .background(Color.LightGray)
            )
            Box(
                Modifier.weight(1f)
                    .fillMaxHeight()
                    .background(Color.Magenta)
            )
        }
    }
    }

@Composable
fun ItemDeRecibo(){
    Row (modifier = Modifier.fillMaxWidth()
        .padding(start = 50.dp, top = 2.dp, end = 50.dp)

    ){
        Text(text = "Producto: Café Americano")
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Precio: $5.99")

    }

}

@Composable
fun BarraDeProgreso(progreso: Float){
Text(text = "Barra de Progreso")
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .height(16.dp)
    ){
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxWidth(progreso)
                .height(16.dp)
        )
    }

}

@Composable
fun TarjetaDeNoticia(){
    Column(modifier = Modifier
    .padding(start = 10.dp,end = 10.dp)
        .border(width = 2.dp, color= Color(0xFF006B04))
    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color(0xFF003A02))
        )
                Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Breaking News: Attention...",Modifier.padding(start = 10.dp, end = 10.dp), style = TextStyle (fontSize = 28.sp, fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(5.dp))

            Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Periodista: Luis Beras", style = TextStyle (fontSize = 16.sp, fontWeight = FontWeight.Normal))
                Spacer(modifier = Modifier.weight(1F))
            Text(text = "12/05/2025", style = TextStyle (fontSize = 16.sp, fontWeight = FontWeight.Normal)
            )}
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "This morning, a youn man was found dead in a car nearby the area of San Juan's river...",
            Modifier.padding(start = 10.dp, end = 10.dp),
            textAlign = TextAlign.Justify,
            style = TextStyle (fontSize = 20.sp,
            fontWeight = FontWeight.Medium)
        )


    }

}

@Composable
fun PantallaLogin() {

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)
        .border(width = 2.dp, color= Color(0xFF8AC6E1)
    ), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally


    ){
        Text(text = "Bienvenido!",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black)

        Spacer(modifier = Modifier.height(15.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .padding(start = 10.dp,end = 10.dp)
            .border(width = 1.dp, color= Color(0xFF8AC6E1))
        ) {
            Text(
                text = "Usuario",
                style = TextStyle(fontSize = 16.sp),
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 5.dp),
                color = Color.DarkGray
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .padding(start = 10.dp,end = 10.dp)
            .border(width = 1.dp, color= Color(0xFF8AC6E1))
        ) {
            Text(
                text = "Contrasena",
                style = TextStyle(fontSize = 16.sp),
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 5.dp),
                color = Color.DarkGray
            )
        }
            Spacer(modifier = Modifier.height(30 .dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .padding(start = 10.dp,end = 10.dp)
            .background(Color(0xFF009688))
        ) {
            Text(
                text = "Login",
                style = TextStyle(fontSize = 16.sp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 5.dp),
                color = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(30 .dp))

        }
    }


