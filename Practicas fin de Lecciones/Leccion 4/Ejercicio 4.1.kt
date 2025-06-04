import Spices.SimpleSpice

fun main (){


   //Spices Class


    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry")
    val eager = spices.filter { it.length <= 6 }
    println(eager)

    val lazy = spices.filter { it.startsWith("c") && it.endsWith("e") }
    println(lazy)

    val filtro3 = spices.take(3).filter { it.startsWith("c") }
    println(filtro3)

    val especias2 = SimpleSpice()
    println("Spice name: ${especias2.name}")
    println("Heat Level: ${especias2.heat}")


}
