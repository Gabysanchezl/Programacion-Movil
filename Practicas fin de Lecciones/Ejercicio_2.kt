fun main (){

    //  PRACTICAS FINAL DE LECCION

    val trout = "trout"
    val haddock  = "haddock"
    val snapper = "snapper"
    println ("Me gusta comer $trout y $snapper dos veces a la semana pero odio el $haddock")

    var fishName = "Bacalao"
    when (fishName.length) {
        0 -> println("Debes darle un nombre a tu pez")
        in 3..12 -> println("$fishName es un buen nombre para tu pececito")
        else -> println("Ok Fish name")
    }

    //Arrays and Loops
    val pares = Array(5) { it * 2 }
    println(pares.joinToString())

    val impares = Array(6) { it * 2 + 1 }
    println(impares.joinToString())

    val mensajes = Array(4) { "Ítem número ${it + 1}" }
    println(mensajes.joinToString())

    //Create an integer array of numbers called numbers, from 11 to 15.
    //Create an empty mutable list for Strings.
    //Write a for loop that loops over the array and adds the string representation of each number to the list.

    val numbers = intArrayOf(11, 12, 13, 14 , 15)
    var listaString = mutableListOf<String> ()
    for (number in numbers) {
        listaString.add(number.toString())
        println(listaString)
    }

}