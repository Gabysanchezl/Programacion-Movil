//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*
fun main() {

    Hola


}

import java.util.*
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    // Arrays, Lists and Loops
    val universidades = listOf("Unicda", "UASD", "PUCMM")
    println(universidades)

    //Mutable ListOf
    val myList = mutableListOf("Ballena", "Tiburon", "Cocodrilo", "Dino")
    myList.remove("Dino")
    println(myList)

    // Creation of Arrays
    val accesorios = arrayOf("Mouse", "CPU", "Monitor")
    println(java.util.Arrays.toString(accesorios))

    // mixed arrays
    val mix = arrayOf("ballena",12, 26, "Unicda", 5)
    println(mix.contentToString())

    val numbers = intArrayOf(1, 2, 3,)
    println(numbers.contentToString())

    //Combine two arrays with the + operator.
    val numeros = intArrayOf(1, 2, 3, 4)
    val numeros2 = intArrayOf(8, 9, 10)
    val numeros3 = numeros + numeros2
    println("la posicion 2 de estos dos arreglos es " +numeros3 [2])

    //combinations of nested arrays and lists
    val cantidad = intArrayOf(1, 2, 3)
    val oceanos = listOf("OddList:", "Atlantic", "Pacific")
    val oddList = listOf(cantidad, oceanos, "salmon")
    println(oddList.toString())

    //Create Loops
    val university = arrayOf("UNIBE", "INTEC","UTESA")
    for (element in university) {
        println (element + " ")
    }
    //Loop through indexes
    for ((index, element) in university.withIndex()   ) {
        println(("Item at $index is $element"))
    }

    ///Ranges
    println("RANGOS:")
    for (a in 1..10) print(a)
    for (b in 5 downTo 0) println(b)
    for (c in 5..16 step 2) print(c)
    for (i in 'd'..'g') println (i)

    // While and DoWhile Loops
    var burbujas = 0
    while (burbujas < 10){
        burbujas++
        println("Hay $burbujas burbujas en el agua")
    }

    do{
        burbujas--
    } while (burbujas > 20)
    println("$burbujas burbujas en el aguita")

    repeat(3){
        println("Hay muchas burbujas en la pecera! ")
    }

}