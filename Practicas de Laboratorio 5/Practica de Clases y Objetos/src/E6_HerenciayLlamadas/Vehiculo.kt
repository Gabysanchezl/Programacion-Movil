// Ejercicio 6: Herencia y Llamadas a `super`

package E6_HerenciayLlamadas

open class Vehiculo {
    open fun describir(){
        println("Este es un vehículo genérico.")
    }
}

class Coche(): Vehiculo(){
    override fun describir(){
        super.describir()
        println("Este es un coche, específicamente, un coche de 4 ruedas.")
    }
}

fun main() {

    val cocherojo = Coche()
    cocherojo.describir()

}