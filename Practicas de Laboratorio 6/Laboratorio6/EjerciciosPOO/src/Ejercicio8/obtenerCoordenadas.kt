package Ejercicio8

fun obtenerCoordenadas(): Pair<Int, Int> {
        val x = 20
        val y = 40
        return Pair(x, y)
    }

    fun obtenerDatosUsuario(): Triple<String, Int, Boolean> {
        val nombre = "Gabriela"
        val edad = 22
        val estaActivo = true
        return Triple(nombre, edad, estaActivo)

    }

fun main(){

    //Usar desestructuración
    val (x, y) = obtenerCoordenadas()
    println("Coordenadas obtenidas: x = $x, y = $y")

    //Usar desestructuración para este Triple tambien

    val (nombre, edad, estaActivo) = obtenerDatosUsuario()
    println("👤 Usuario: $nombre, \nEdad: $edad, \n¿Activo?: $estaActivo")




}