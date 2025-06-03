fun main() {

    //----LECCION 3

    dayOfWeek()
}
fun dayOfWeek() {
    println("What day is it today?")

    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    val dayName = when (day) {
        1 -> ("Today is Sunday")
        2 -> "Today is Monday"
        3 -> "Today is Tuesday"
        4 -> "Today is Wednesday"
        5 -> "Today is Thursday"
        6 -> "Today is Friday"
        7 -> "Today is Saturday"
        else -> "Armagedon arrived :b "
    }
    println(dayName)

    // Changing Water

fun anadirPez(
    tamanoTanque: Double,
    pecesActuales: List<Int>,
    nuevoPezsize: Int = 2,
    tieneDecoraciones: Boolean = true
): Boolean {                                                                          //la funcion me devovera un Boolean

    //cabe un nuevo pez?
    val capacidadMaximaTanque = if (tieneDecoraciones) tamanoTanque * 0.8 else tamanoTanque
    val totaldePecesActuales = pecesActuales.sum()

    return totaldePecesActuales + nuevoPezsize <= capacidadMaximaTanque    }

println(anadirPez(10.0, listOf(3,3,3)))
println(anadirPez(9.0, listOf(1,1,3), 3))
println(anadirPez(10.0, listOf(), 7, true))
println(anadirPez(8.0, listOf(2,2,2), tieneDecoraciones =false))





//WHATSHOULD I DO TODAY


fun whatShouldIDoToday (mood: String, weather: String = "sunny", temperature: Int = 24):
        String {                                                                                        //la funcion me devolvera un String
    return when {
        mood == "happy" && weather == "sunny" -> ("go for a walk")
        mood == "tired" && weather == "rainy" && temperature == 15 -> "Rest the whole day"
        else -> "Stay at home and sleep"
    }
}
println(whatShouldIDoToday("sad"))


}