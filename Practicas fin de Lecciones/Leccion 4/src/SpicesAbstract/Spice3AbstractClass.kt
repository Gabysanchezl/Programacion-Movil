package SpicesAbstract

/*

class Spice3AbstractClass {
    interface Grinder {
        fun grind() {
            println("Grinding the spice in the grinder.")
        }
    }

    // Clase abstracta
    abstract class Especias(val name: String, val spiciness: String = "mild") {

        val heat: Int
            get() = when (spiciness) {
                "mild" -> 5
                "medium" -> 10
                "hot" -> 15
                else -> 0
            }

        abstract fun prepararSpice()
    }

    // Subclase concreta
    class Curcuma(spiciness: String) : Especias("Curcuma", spiciness), Grinder {

        override fun prepararSpice() {
            grind()                                                                                 // metodo de la interfaz
            println("Preparing $name with spiciness $spiciness (heat: $heat)")
        }
    }
}

*/

    //ABSTRACT CLASS CON SPICECOLOR POR DELEGACION

class Spice3AbstractClass {
    interface Grinder {
        fun grind() {
            println("Grinding the spice in the grinder.")
        }
    }

    // Clase abstracta
    abstract class Especias2( val name: String,val spiciness: String = "mild", color: SpiceColor) :
        SpiceColor by color {

        val heat: Int
            get() = when (spiciness) {
                "mild" -> 5
                "medium" -> 10
                "hot" -> 15
                else -> 0
            }
        abstract fun prepararSpice()
    }
    class Curry(spiciness: String, color: SpiceColor = YellowSpiceColor) :
        Especias2("Curry", spiciness, color) {

        override fun prepararSpice() {
            println("Grinding and preparing $name spice with heat level $heat.")
        }
    }

}

