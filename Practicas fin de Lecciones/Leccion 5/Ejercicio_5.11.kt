import Buildings.*

fun main() {
    val buildingDeMadera = Building(Madera())
    buildingDeMadera.build()  // Debería imprimir: "400 Madera required"

    val buildingDeLadrillo = Building(Ladrillo())
    buildingDeLadrillo.build()  // Debería imprimir: "800 Ladrillo required"
}