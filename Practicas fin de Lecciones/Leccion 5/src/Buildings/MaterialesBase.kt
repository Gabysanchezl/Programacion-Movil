package Buildings

open class MaterialesBase {
    open val numberNeeded: Int = 1
}

class Madera : MaterialesBase() {
    override val numberNeeded = 4                       ///Cada material sobreescribe numberNeeded con su propio valor.
}                                                       // Madera necesita 4 y Ladrillo 8
class Ladrillo : MaterialesBase() {
    override val numberNeeded = 8
}


class Building<out T: MaterialesBase>(private val material: T) {

    private val MaterialesBase = 100

    val actualMaterialsNeeded: Int
        get() = MaterialesBase * material.numberNeeded

    fun build() {
        println("${actualMaterialsNeeded} ${material::class.simpleName} required")
    }
}

