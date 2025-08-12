package com.gaby.laboratorio11

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Routes {
    const val Splash = "splash"
    const val Home = "home"
}

@Composable
fun AppNavigation(splashViewModel: SplashViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Splash) {
        composable(Routes.Splash) {
            SplashScreen(navController, splashViewModel)
        }
        composable(Routes.Home) {
            HomeScreen()
        }
    }
}
