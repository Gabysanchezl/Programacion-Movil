
import Spices.SimpleSpice2

fun main (){

    ///SIMPLE-SPICES-2

    val spices2 = listOf(
        SimpleSpice2("Curry", "hot"),
        SimpleSpice2("Pimienta", "medium"),
        SimpleSpice2("Canela","mild"),
        SimpleSpice2("Paprika","medium"),
        SimpleSpice2("Chili", "Very Hot"),
        SimpleSpice2("Curcuma", "mild"),
    )

    println("Spices que pican (picantes o mas)")
    val spicesPicantes = spices2.filter {it.picante >= 2}
    for (spices2 in spicesPicantes) {
        println("${spices2.name} es una spice con un nivel de picante: ${spices2.picante}")
    }

    fun makesalt(): SimpleSpice2 {
        return SimpleSpice2("salt", "mild")
    }

}
