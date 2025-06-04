import java.util.Calendar
import kotlin.text.get

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


    fun whatShouldIDoToday (mood: String, weather: String = "Soleado", temperature: Int = 24):
            String {                                                                                        //la funcion me devolvera un String
        return when {
            mood == "Feliz" && weather == "sunny" -> ("Vamos a caminar!")
            mood == "Cansado" && weather == "rainy" && temperature == 15 -> "Quedate en casa todo el dia, descansa"
            else -> "Quedarse en casa y dormir"
        }
    }
    println(whatShouldIDoToday("Triste"))



    //WHATSHOULD I DO TODAY ---- VERSION MEJORADA

    fun haceMuchoCalor(temp: Int) = temp > 30
    fun haceMuchoFrioyLLUVIA(temp: Int, weather: String) = temp == 0 && weather == "llueve"
    fun haceFrioyTRISTE(temp: Int, weather: String, mood: String) = temp == 0 && weather == "llueve" && mood == "triste"

    fun whatShouldIDoToday (mood: String, weather: String = "soleado", temperature: Int = 24): String {                                                                                        //la funcion me devolvera un String
        return when {
            haceFrioyTRISTE(temperature, weather, mood) -> "Quedate en la camita"
            haceMuchoCalor(temperature) -> "Vete para la playa y refrescate!"
            haceMuchoFrioyLLUVIA(temperature, weather) -> "Deberias hacer Pan con Chocolate"
            mood == "feliz" && weather == "soleado" -> "Disfruta el dia, sal a la calle. Carpe Diem!"
            mood == "enojado" -> "Ve al gym, descarga esa furia"
            else -> "Haz lo que quieras hoy"
        }}

    println("¿Cómo te sientes hoy? (Ej: Triste, Feliz, Enojado)")
    val mood= readLine()!!.lowercase()
    println("¿Cómo está el clima hoy? (Ej: Soleado, Llueve)")
    val weather= readLine()!!.lowercase()
    println("¿Cuál es la temperatura actual? (en grados Celsius)")
    val temperature = readLine()!!.toInt()?: 24
    println(whatShouldIDoToday(mood, weather, temperature))



}