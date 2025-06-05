import Aquarium.ClassAquarium
import Spices.SimpleSpice
import Spices.SimpleSpice2

fun main (){

    //AQUARIUM CLASS

    buildAquarium()
}

    private fun buildAquarium() {
    val myAquarium = ClassAquarium()

    println("Longitud: ${myAquarium.largo} cm")
    println("Ancho: ${myAquarium.ancho} cm")
    println("Altura: ${myAquarium.altura} cm")
    println("Volumen: ${myAquarium.volumen} litros")

    // Cambios de altura
    myAquarium.altura = 60
    println("Nueva altura: ${myAquarium.altura} cm")
    println("Nuevo volumen: ${myAquarium.volumen} litros")

    // También cambiar el volumen,  cambiaria la altura automáticamente
    myAquarium.volumen = 100
    println("Después de ajustar el volumen:")
    println("Altura ajustada automáticamente: ${myAquarium.altura} cm")

        println("Water volume (90%): ${myAquarium.water} L")





        //







    }
