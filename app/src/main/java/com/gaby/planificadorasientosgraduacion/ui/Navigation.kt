package com.gaby.planificadorasientosgraduacion.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.gaby.planificadorasientosgraduacion.ui.screens.AdminHomeScreen
import com.gaby.planificadorasientosgraduacion.ui.screens.MainMenuScreen
import com.gaby.planificadorasientosgraduacion.ui.screens.SplashScreen
import com.gaby.planificadorasientosgraduacion.ui.screens.PantallaAdminLogin
 import com.gaby.planificadorasientosgraduacion.ui.screens.PantallaConsultaSeccion
import com.gaby.planificadorasientosgraduacion.ui.screens.PantallaListaEstudiantes
import com.gaby.planificadorasientosgraduacion.ui.screens.PantallaPlanoAsientos
import com.gaby.planificadorasientosgraduacion.ui.screens.ResultadoConsulta


@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "splash") {

        composable("splash") { SplashScreen(navController) }
        composable("main_menu") { MainMenuScreen(navController) }
        composable("admin_login") { PantallaAdminLogin(navController) }
        composable("consulta_seccion") { PantallaConsultaSeccion(navController) }
        composable("admin_home") { AdminHomeScreen(navController) }

        // Navegación del menú inferior
        composable("plano_asientos") { PantallaPlanoAsientos(navController) }
        composable("lista_estudiantes") { PantallaListaEstudiantes(navController) }

         composable(
            route = "resultado_consulta/{nombre}/{codigo}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("codigo") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val codigo = backStackEntry.arguments?.getString("codigo") ?: ""
            ResultadoConsulta(nombre, codigo, navController)
        }
    }
}
