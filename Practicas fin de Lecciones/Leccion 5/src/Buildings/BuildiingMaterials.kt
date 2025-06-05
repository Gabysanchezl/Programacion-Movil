// En Buildings.kt o Materiales.kt

package Buildings

open class BaseBuildingMaterial {
    open val numberNeeded: Int = 1
}

// Subclases especializadas
class Wood : BaseBuildingMaterial() {
    override val numberNeeded = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded = 8
}

class BuildingStructure<out T : BaseBuildingMaterial>(private val material: T) {                    // Clase generica renombrada


    private val baseMaterialsNeeded = 100

    val actualMaterialsNeeded: Int
        get() = baseMaterialsNeeded * material.numberNeeded

    fun build() {
        println("${actualMaterialsNeeded} ${material::class.simpleName} required")
    }
}