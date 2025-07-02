package Ejercicio9

class Caja<T>(private val contenido: T?) {              //RECORDAR QUE "?" indica que PUEDE SER NULO

    fun obtenerContenido(): T? {
        return contenido
    }

    fun estaVacia(): Boolean {
        return contenido == null
    }
}

fun main() {
    val cajadeMensajes = Caja("Letters to my father")
    val cajadeBloques = Caja(42)
    val cajaVacia = Caja<String>(null)

    println("Caja de Mensajes: '${cajadeMensajes.obtenerContenido()}', ¿Esta caja está vacía?: ${cajadeMensajes.estaVacia()}")
    println("Caja de Bloques: Contiene ${cajadeBloques.obtenerContenido()} bloques de madera, ¿Esta Caja está vacía?: ${cajadeBloques.estaVacia()}")
    println("Caja vacía: ${cajaVacia.obtenerContenido()}, ¿Está vacía esta caja?: ${cajaVacia.estaVacia()}")

}