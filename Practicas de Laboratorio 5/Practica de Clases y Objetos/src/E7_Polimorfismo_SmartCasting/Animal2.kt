//Ejercicio 7: Polimorfismo y Smart Casting

package E7_Polimorfismo_SmartCasting
import E7_Polimorfismo_SmartCasting.Animal2.Gatito
import E7_Polimorfismo_SmartCasting.Animal2.Pajaro
import E7_Polimorfismo_SmartCasting.Animal2.Perro

    abstract class Animal2 (val nombre:String) {

        abstract fun hacerSonido()
        abstract fun moverse()

        class Perro(nombre: String): Animal2(nombre){
            override fun hacerSonido(){
                println("Mi perro $nombre ladra: Guau Guau!")
            }
            override fun moverse(){
                println("$nombre corre de un lado a otro.")
            }
        }

        class Gatito(nombre: String): Animal2(nombre){
            override fun hacerSonido(){
                println("Mi gatita $nombre ronronea y dice \"Meow\"")
            }
            override fun moverse(){
                println("$nombre se acurruca debajo de la mesa.")
            }
        }

        class Pajaro(nombre: String): Animal2(nombre){
            override fun hacerSonido(){
                println("$nombre cotorrea como humano sin parar.")
            }
            override fun moverse(){
                println("$nombre vuela en su jaulita.")
            }
        }
    }

    fun describirComportamiento(animal: Animal2){
    when(animal){
    is Pajaro -> println("Este animal vuela alto.")
    is Perro -> println("Este animal es el mejor amigo del hombre.")
     else -> println("Este animal tiene un comportamiento interesante.")
    }
    }

    fun main(){

        val listaAnimal: List<Animal2> = listOf(Perro("Firulais"), Gatito("Missouri"), Pajaro("Yayo"))
        println("Tengo 3 animalitos en mi casa ------------------")

        for(animal in listaAnimal){
            animal.hacerSonido()
            animal.moverse()
            describirComportamiento(animal)
            println(".......")

        }


        /* LAS INSTANCIAS PUEDEN SER LLAMADAS TANTO DECLARANDOLAS AQUI COMO VARIABLES, COMO LA LISTA QUE TENGO MAS
        / ARRIBA EN LA CUAL SE AUTODECLARAN EN CONJUNTO A LA LISTA QUE CREE.

        val perro = Perro("Duke")
        val pajaro = Pajaro("Piolin")
        val gato = Gatito("Mississipi")
        */
}