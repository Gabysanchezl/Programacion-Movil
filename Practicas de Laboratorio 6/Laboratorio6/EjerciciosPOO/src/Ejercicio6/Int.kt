package Ejercicio6

    fun Int.esPar(): Boolean{                       //esto es una funcion de INT donde buscamos que se cumpla la condicion de
        return this % 2 == 0                       ///que sea PAR en este caso, el numero que una vez aplicada la funcion compruebe que %2 == 0 (sea par)
    }

    fun Int.cuadrado(): Int {               //Lo mismo pasa aqui con la funcion .cuadrado que va a validar o devolver
        return this * this                  // un numero por si mismo, es decir 'al cuadrado'
    }

fun main() {
    val numeroPar = 10
    val numeroImpar = 9

    println("El numero 10 es par? : ${numeroPar.esPar()}")
   println("El numero 10 elevado al cuadrado da como resultado: ${numeroPar.cuadrado()}")
   println("----------------------------")

    println("El numero 9 es par?: ${numeroImpar.esPar()}")
    println("El cuadrado de el numero 9 es: ${numeroImpar.cuadrado()}")
}