// Ejercicio 3: Jerarquía de Empleados con `init`

package E3_JerarquiaEmpleados

open class Empleado (var nombre: String, var edad: Int, var salarioBase:Double) {
    init {
        println("Se ha registrado un nuevo empleado: ${nombre}.")
        println("------------------------------------")
        }
    open fun calcularSalario(): Double {
        return salarioBase
    }
}

    class Gerente(nombre:String, edad: Int, salarioBase: Double, val bono:Double): Empleado("Mercedes", 42, 85200.00){
        override fun calcularSalario():Double{
          return salarioBase + bono
        }
    }

    class Desarrollador(nombre:String, edad: Int, salarioBase: Double, val lenguaje:String) : Empleado(nombre, edad, salarioBase){
        override fun calcularSalario():Double{
            return salarioBase
        }
    }

fun main() {
    val nuevoGerente = Gerente("Rocio Tejeda", 22, 87000.00, 13000.00)
    nuevoGerente.calcularSalario()
    println("El salario Base de ${nuevoGerente.nombre}, Gerente de la empresa, es ${nuevoGerente.salarioBase}")
    println("Se le paga tambien un bono de ${nuevoGerente.bono}.")
    println("En total ${nuevoGerente.nombre} recibe un salario de ${nuevoGerente.calcularSalario()}")


    val nuevoDesarrollador = Desarrollador("Elon Musk", 45, 70000.00, "Python")
    nuevoDesarrollador.salarioBase
    println("El salario de ${nuevoDesarrollador.nombre} desarrollador de la emrpesa es ${nuevoDesarrollador.salarioBase}")
    println("${nuevoDesarrollador.nombre} trabaja utilizando ${nuevoDesarrollador.lenguaje}")
}