package Spices

class SimpleSpice {
    val name : String = "curcuma"
    val spiciness: String = "hot"

    val heat: Int
        get ()= when(spiciness) {                     // esto no es una funcion normal, es una PROPIEDAD con getter.
        "mild" -> 5                                 //parece un valor pero es una funcion que calcula su valor
        "medium" -> 10                              //cada vez que se accede a la misma
        "hot" -> 15
        else -> 0
        }

}