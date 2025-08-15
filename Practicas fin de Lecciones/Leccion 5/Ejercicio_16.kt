import Buildings.*

fun main() {
    val woodBuilding = BuildingStructure(Wood())
    woodBuilding.build()
    isSmallBuilding(woodBuilding)

    val brickBuilding = BuildingStructure(Brick())
    brickBuilding.build()
    isSmallBuilding(brickBuilding)
}

// Función genérica que evalúa el tamaño del edificio
fun <T : BaseBuildingMaterial> isSmallBuilding(building: BuildingStructure<T>) {
    if (building.actualMaterialsNeeded < 500) {
        println("small building")
    } else {
        println("large building")
    }
}