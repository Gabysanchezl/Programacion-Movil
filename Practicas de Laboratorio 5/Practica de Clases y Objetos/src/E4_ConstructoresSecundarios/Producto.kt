// Ejercicio 4: Constructores Secundarios para `Producto`

package E4_ConstructoresSecundarios

class Producto (var codigo: String, var precio: Double){
    init {
        if (precio < 0.0){
            throw IllegalArgumentException("El precio no puede ser negativo.")
        }
    }
    constructor(codigo: String): this(codigo, 9.99)
    constructor():this ("GEN-001", 0.99)
}


fun main(){
    val producto1 = Producto("Chinola-Power", 3.52)
    val producto2 = Producto("Bateria0--0-JK")                                 // va a utilizar el precio asigado por defecto
    val producto3 = Producto()                                                  // va a usar el codigo dado y el precio asignado tambie por el segundo constructor


    println("Producto 1 = ${producto1.codigo}, Precio = ${producto1.precio}")
    println()
    println("Producto 2 = ${producto2.codigo}, Precio = ${producto2.precio}")
    println()
    println("Producto 3 = ${producto3.codigo}, Precio = ${producto3.precio}")

}