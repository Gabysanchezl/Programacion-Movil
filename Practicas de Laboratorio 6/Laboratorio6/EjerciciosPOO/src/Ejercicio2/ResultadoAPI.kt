package Ejercicio2

import Ejercicio2.ResultadoAPI.Cargando.procesarResultado

sealed class ResultadoAPI {

    data class Exito(val datos: String):ResultadoAPI()

    data class Error(val mensaje:String): ResultadoAPI()

    object Cargando : ResultadoAPI()


    fun procesarResultado(resultado:ResultadoAPI){
        when (resultado){
            is ResultadoAPI.Exito -> {
                println("Exito: ${resultado.datos}")
            } is ResultadoAPI.Error ->{
                println("Error: ${resultado.mensaje}")
            } is ResultadoAPI.Cargando -> {
                println("Cargando...")
            }
        }
    }
}

fun main (){

    val diagnostico1 = ResultadoAPI.Exito("Se cargaron todos los datos correctamente")
    val diagnostico2 = ResultadoAPI.Error("No se ha podido realizar el proceso.")
    val diagnostico3 = ResultadoAPI.Cargando


    procesarResultado(diagnostico1)
    procesarResultado(diagnostico2)
    procesarResultado(diagnostico3)

}