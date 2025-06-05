package Spices

class SimpleSpice2 (val name : String, val spiciness: String = "mild"){

        val picante: Int
            get ()= when(spiciness) {                     // esto no es una funcion normal, es una PROPIEDAD con getter.
                "mild" -> 1                                 //parece un valor pero es una funcion que calcular su valor
                "medium" -> 2                              //cada vez que se accede a la misma
                "spicy" -> 3
                "hot" -> 4
                "very hot" -> 5
                else -> 0
            }
    init {
        println("Spice creada: $name, Spicenesss: $spiciness, Heat: $picante")
    }
}