package com.gaby.planificadorasientosgraduacion.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlin.math.hypot
@Composable
fun SplashScreen(navController: NavHostController) {
    val transitionProgress = remember { Animatable(0f) }

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenDiagonal = with(LocalDensity.current) {
        hypot(screenWidth.toPx(), screenHeight.toPx()) * 1.2f
    }

    LaunchedEffect(Unit) {
        transitionProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
        // Luego de la animación, navega al menú principal
        navController.navigate("main_menu") {
            popUpTo("splash") { inclusive = true } // elimina splash del backstack
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        MainMenuScreen(navController) // Lo revela gradualmente

        Canvas(modifier = Modifier.fillMaxSize()) {
            val radius = screenDiagonal * (1f - transitionProgress.value)
            drawCircle(
                color = Color(0xFF8C4E28),
                radius = radius,
                center = Offset(size.width / 2, size.height / 2)
            )
        }
    }
}
