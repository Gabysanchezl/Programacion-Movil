import java.util.Calendar

fun main() {

// Practice Basic Operations in Kotlin = TASKS

    // --LECCION 2

    // 01. Ejercicio
    val fish = 2
    var firstoffspring = 71
    var secondoffspring =  233
    var totalfish = firstoffspring + secondoffspring
    println("Toal of Fish: $totalfish")

// 13 fish are swallowed by a hungry moray ee
    var survivingFishes = totalfish - 13
    println(survivingFishes)
    println(survivingFishes/30)
// lol, RESPUESTA CORRECTA DEBIO HABER SIDO:
//in one line of code:
    println( 2.plus(71).plus(233).minus(13).div(30).plus(1))


/// 02. Ejercicio

    var rainbowColor: String? = "Azul"
    rainbowColor =  "Violeta"
    rainbowColor = "Marron"
    rainbowColor = null
    val blackColor = "Black"
    //   blackColor = "Naranja" //gives error

// 03. Ejercicio
    var rainbowColor2: String? = null
    var greenColor = null
    val blueColor: Int? = null

// 04. Ejercicio
    val list1: List<String?> = listOf(null, null)
    val listelementNulos: List<String?>? = null
    val listaNula: List<String>? = null


//05. Ejercicio
//*    Create a nullable integer variable called nullTest
// , and set it to null. Use a null-check that increases
// the value by one if it's not null, otherwise returns 0, and prints the result.
    val nullTest: Int? = 2
    println (nullTest?.inc() ?: 0)   //Bosquejo "Hay algo en la variable?" Si....entonces ejecuta el incremento. No hay nada en la variable? osea es Null. pos dame 0 // "
    //test 2
    val nullTest2: Int? = null
    println (nullTest2?.inc() ?: 0)

    "Hello" + "Fish"

    //  OTHER TASKS STRINGS
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

//*Create an integer array of numbers called numbers, from 11 to 15.
//Create an empty mutable list for Strings.
//Write a for loop that loops over the array and adds the string representation of each number to the list.

    val numbers = intArrayOf(11, 12, 13, 14 , 15)
    var listaString = mutableListOf<String> ()
    for (number in numbers) {
        listaString.add(number.toString())
        println(listaString)
    }

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

        //// Second Exercise = Greetings,Kotlin

        fun time24Hours(args: Array<String>) {
            val horas = args [0].toInt()
            if(horas < 12) {
                println("Good Morning, Kotlin")
            }else {
                println("Good Night, Kotlin")
            }
        }
        /// TASK --- RAMDOM

        val fortune = getFortuneCookie()
        println("Your Fortune is: $fortune")
    }
    fun getFortuneCookie(): String? {           ///Devuelve un String (la frase de la fortuna).
        val fortunes = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
        )
        print("Enter your birthday: ")                          ///readLine()	Lee lo que el usuario escribió como texto.
        val birthday = readLine()?.toIntOrNull()?: 5            /// ?.toIntOrNull()	Intenta convertirlo a número. Si no puede, devuelve null.
        val index = birthday % fortunes.size                    ///  y si es null entonces usara el valor 5 por defecto.

        return fortunes[index]
    }
/// getfortune function - part 2

