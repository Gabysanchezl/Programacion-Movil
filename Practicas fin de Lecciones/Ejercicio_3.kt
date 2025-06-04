fun main () {

    /*
/// GET FORTUNE COOKIE   -   Random
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
    print("Enter your birthday: ")                                      ///readLine()	Lee lo que el usuario escribió como texto.
    val birthday = readLine()?.toIntOrNull()
        ?: 5                                                              /// ?.toIntOrNull()	Intenta convertirlo a número. Si no puede, devuelve null.
    val index = birthday % fortunes.size                                ///  y si es null entonces usara el valor 5 por defecto.
                                                                            /// % es el operador módulo, que da el resto de una división. Garantiza que el número nunca se pase de la cantidad de frases.
                                                                              //Ejemplo:   Si birthday = 10 y hay 7 frases → 10 % 7 = 3 → muestra la frase #3.
    return fortunes[index]
}
val fortune = getFortuneCookie()
println("Your Fortune is: $fortune")

}
    */


    //GetFortune - Part 2

    fun getBirthday(): Int {
        print("Enter your birthday: ")
        val input = readLine()
        return input?.toIntOrNull() ?: 1
    }

    fun getFortuneCookie(birthday: Int): String {
        val fortunes = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
        )

        return when (birthday) {
            28, 31 -> "Special days bring special surprises!"
            in 1..7 -> "You are blessed early in the month!"
            else -> fortunes[birthday % fortunes.size]
        }
    }

    val birthday = getBirthday()
    val fortune = getFortuneCookie(birthday)
    println("Your fortune is: $fortune")

}