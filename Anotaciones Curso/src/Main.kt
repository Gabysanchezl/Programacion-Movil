import java.util.Calendar
import kotlin.random.Random

/*fun main() {

    //DEFINICIONES

    // Suma
    val result1 = 1 + 1  //variable que no se cambia VAL
    println("1 + 1 = $result1") // Imprime: 1 + 1 = 2

    // Hay 50 peces y llegan 3 más
    var fish = 50 + 3       //Variable cuyo valor puede cambiar VAR
    println("Total peces: $fish") // Imprime: Total peces: 53

    // 3 peces bebé son comida de tiburones
    fish -= 3
    println("Peces después de la morision :v : $fish") // Imprime: Peces después del ataque: 50

    // Dividimos los peces en poncheras de a 10 cada una
    val batches = fish / 10
    println("Grupos de 10 peces: $batches") // Imprime: 5



    // Separadores visuales en números
    val bigNumber = 1_000_000
    println("Número grande: $bigNumber")                     // Imprime: 1000000


    //NULLABILITY

    // var marbles: Int = null
    //will give error, as NULLL cant be a value of a NON-NULL type Int
    //so, we put it like this var marbles: Int? = null                      le estamos diciendo al programa que este valor puede ser nulo, es decir, estar  vacio.

// SAFE OPERATOR
    /*/
           ?. → Solo ejecuta el metodo si la variable no es null.                         se pregunta "Tiene algo?" Si lo tiene me da el dato. Si no tiene NADA me da NULL = NADA
           ?: → Si es null, devuelve un valor alternativo. ELVIS OPERATOR
           !! → Fuerza el acceso aunque sea null (y puede explotar el programa si lo es). POR ESO HAY QUE ESTAR MUY SEGUROS
   */

    var treats: Int? = 5                     //   Puede ser null aunque ahora mismo hay 5
    val loquesobra = treats?.dec()            //  Devuelve null si treats es null. Pregunta "¿Hay algo?" si hay me da lo que tiene la variable segun lo que pedi = dec 5 = 4
    val siNohayNada = treats?.dec() ?: 0         // Devuelve 0 si treats es null. Pregunta "¿Hay algo?".  Si hay me da lo que tiene la variable segun lo que pedi = dec 5 = 4 ..... PERO "SI NO HAY, dame el valor = 0"

//listas y nulls
//elementos de una lista pueden ser nulos
    val list1: List<String>? = null                     // Lista puede ser null, elementos no
    val list2: List<String?> = listOf("pez", null)      // Lista no es null, elementos sí
    val list3: List<String?>? = null                    // Todo puede ser null
    println(list2[0])                   // "pez"
    println(list2[1])                   // null


}
*/

/*
    ////PARTE 3
    fun main () {
        dayOfWeek()
    }
    fun dayOfWeek() {
        println("What day is it today?")

        val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        val dayName = when (day) {
            1 -> ("Sunday")
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> "Time has stopped"
        }
        println(dayName)
    }
*/

fun main(args: Array<String>) {                     //Significa que tu programa puede recibir argumentos desde la línea de comandos. Se guardan en el arreglo args.

    val temperatura = 25
    val mensaje = if (temperatura > 50) "El pez está frito" else "El pez está a salvo"
    println(mensaje)

    //RAMDOM FNCTIONS
}


       fun feedTheFish() {
           val day = randomDay()
           val food = fishFood (day)
        println("Today is $day and the fish eat $food")
    }
    fun randomDay(): String {
         val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        return week[Random().nextInt(7)]
    }
// Fish Food
    fun fishFood(day: String): String {
    var food = "Ayuno"

    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food
    }


/// Anadir peces

fun canAddFish(
    tankSize: Double,                      // Tamaño de la pecera en galones
    currentFish: List<Int>,               // Lista de peces actuales (su tamaño en pulgadas)
    fishSize: Int = 2,                    // Tamaño del pez nuevo. Por defecto, 2 pulgadas. A menos que yo defina un valor distinto
    hasDecorations: Boolean = true        // ¿Tiene decoraciones? Por defecto, sí.
): Boolean {
    ...


}
