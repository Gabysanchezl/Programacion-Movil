// Ejercicio 5: Clases Abstractas - `Animal`

package E5_ClasesAbstractas_ANIMAL

import E5_ClasesAbstractas_ANIMAL.Animal.Gatito
import E5_ClasesAbstractas_ANIMAL.Animal.Pajaro
import E5_ClasesAbstractas_ANIMAL.Animal.Perro

abstract class Animal (val nombre:String) {

    abstract fun hacerSonido()
    abstract fun moverse()

    class Perro(nombre: String): Animal(nombre){
        override fun hacerSonido(){
            println("Mi perro $nombre ladra: Guau Guau!")
        }
        override fun moverse(){
            println("$nombre corre de un lado a otro")
        }
    }

    class Gatito(nombre: String): Animal(nombre){
        override fun hacerSonido(){
            println("Mi gatita $nombre ronronea y dice \"Meow\"")
        }
        override fun moverse(){
            println("$nombre se acurruca debajo de la mesa")
        }
    }

    class Pajaro(nombre: String): Animal(nombre){
        override fun hacerSonido(){
            println("$nombre cotorrea como humano sin parar")
        }
        override fun moverse(){
            println("$nombre vuela en su jaulita")
        }
    }


}

fun main(){

    val listaAnimal: List<Animal> = listOf(Perro("Firulais"), Gatito("Missouri"), Pajaro("Yayo"))
    println("Tengo 3 animalitos en mi casa ------------------")

    for(animal in listaAnimal){
        animal.hacerSonido()
        animal.moverse()
        println(".......")
    }
}