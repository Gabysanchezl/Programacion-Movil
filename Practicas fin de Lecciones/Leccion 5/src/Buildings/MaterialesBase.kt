package Buildings

open class MaterialesBase {
    open val numberNeeded: Int = 1
}

class Madera : MaterialesBase() {
    override val numberNeeded = 4
}

class Ladrillo : MaterialesBase() {
    override val numberNeeded = 8
}

class Building<out T : MaterialesBase>(private val material: T) {

    private val baseMaterialsNeeded = 100

    val actualMaterialsNeeded: Int
        get() = baseMaterialsNeeded * material.numberNeeded

    fun build() {
        println("${actualMaterialsNeeded} ${material::class.simpleName} required")
    }
}