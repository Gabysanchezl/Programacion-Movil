package com.gaby.laboratorio10

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

object AppRoutes{
    const val BIENVENIDA = "bienvenida"
    const val DATOS_PERSONALES = "datos_personales"
    const val DATOS_FINANCIEROS = "datos financieros"
    const val CONFIRMACION = "confirmacion"
    const val EXITO = "exito"

}


@Composable
fun AppNavigation (){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppRoutes.BIENVENIDA) {
        composable(AppRoutes.BIENVENIDA) {
            PantallaBienvenida {
                navController.navigate(AppRoutes.DATOS_PERSONALES)
            }
        }

        composable(AppRoutes.DATOS_PERSONALES) {
            PantallaDatosPersonales {
                navController.navigate(AppRoutes.DATOS_FINANCIEROS)
            }
        }

        composable(AppRoutes.DATOS_FINANCIEROS) {
            PantallaDatosFinancieros {
                navController.navigate(AppRoutes.CONFIRMACION)
            }
        }

        composable(AppRoutes.CONFIRMACION) {
            PantallaConfirmacion {
                navController.navigate(AppRoutes.EXITO)
            }
        }

        composable(AppRoutes.EXITO) {
            PantallaExito {
                navController.popBackStack(AppRoutes.BIENVENIDA, false)

            }
        }

    }
}
