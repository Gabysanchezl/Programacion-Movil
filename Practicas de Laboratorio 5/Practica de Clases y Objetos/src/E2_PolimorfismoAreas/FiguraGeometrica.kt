//Ejercicio 2: Polimorfismo con Áreas


package E2_PolimorfismoAreas
import kotlin.math.PI

 open class FiguraGeometrica (val nombre:String){

     open fun imprimirNombre(){
        println("Soy una figura geometrica, soy un:  $nombre")

    }
     open fun CalcularArea():Double {
        return 0.0
     }

}

    class Circulo(nombre:String, val radio: Double): FiguraGeometrica(nombre){
    override fun CalcularArea(): Double{
        return PI*radio*radio
    }
    }

    class Cuadrado(nombre:String, val lado: Double): FiguraGeometrica(nombre) {
        override fun CalcularArea(): Double {
            return lado * lado
        }
    }

        fun main() {

            val figuracirculo = Circulo("circulo", 2.5)
            figuracirculo.imprimirNombre()

            val figuracuadrado = Cuadrado("cuadrado", 14.0)
            figuracuadrado.imprimirNombre()


            val listadeFiguras: List<FiguraGeometrica> = listOf(figuracirculo, figuracuadrado)
            println("Area de figuras ------------------")

            for(figura in listadeFiguras){
                figura.imprimirNombre()
                println("Área calculada: ${figura.CalcularArea()}")                     //    POLIMORFISMO???
                println("--------------------------")
            }

         }


