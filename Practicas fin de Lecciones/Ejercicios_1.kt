fun main (args: Array<String>) {



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
//    Create a nullable integer variable called nullTest
//  and set it to null. Use a null-check that increases
// the value by one if it's not null, otherwise returns 0, and prints the result.
    val nullTest: Int? = 2
    println (nullTest?.inc() ?: 0)   //Bosquejo "Hay algo en la variable?" Si....entonces ejecuta el incremento. No hay nada en la variable? osea es Null. pos dame 0 // "
    //test 2
    val nullTest2: Int? = null
    println (nullTest2?.inc() ?: 0)

    "Hello" + "Fish"


}