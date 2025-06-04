import java.util.Calendar
import kotlin.text.get


fun main() {

///Ejercicio 5 y 6

    //Filters

    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry")
    val eager = spices.filter {it.length <= 6}
    println (eager)

    val lazy = spices.filter {it.startsWith("c") && it.endsWith("e")}
    println (lazy)

    val filtro3 = spices.take(3).filter {it.startsWith("c")}
    println(filtro3)

///


    //Lambdas

    fun actualizarSuciedad(nivel: Int, operacion: (Int) -> Int): Int {                      // función de orden superior ---- es una función que recibe otra función como parámetro
        return operacion(nivel)                                                             //operacion es una función que recibe un Int y devuelve un Int.
    }
    val resultado = actualizarSuciedad(30) { sucio -> sucio / 2 }
    println(resultado)








}
