//1_ Figuras Geometricas Basicas y Polimorfismo con Areas


package E1_FigurasGeometricasBasicas


open class FigurasGeometricas (val nombre:String){

    open fun imprimirNombre(){
            println("Soy una figura geometrica, soy un:  $nombre")
    }
}

class Circulo(nombre:String, val radio: Double): FigurasGeometricas(nombre){

}

class Cuadrado(nombre:String, val lado: Double): FigurasGeometricas(nombre) {

}

fun main() {

    val figuracirculo = Circulo("circulo", 2.5)
    figuracirculo.imprimirNombre()
    println("El radio de ${figuracirculo.nombre} es: ${figuracirculo.radio}")

    val figuracuadrado = Cuadrado("cuadrado", 14.0)
    figuracuadrado.imprimirNombre()
    println("Los lados del ${figuracuadrado.nombre} miden: ${figuracuadrado.lado}")


}