import java.lang.Math
import javax.swing.Spring
import javax.swing.Spring.height
import kotlin.times

fun buildAquarium(){
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()

    //Nuevos Aquariums
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    val aquarium2 = Aquarium(height = 49)
    aquarium2.printSize()
    val aquarium3 = Aquarium(width = 54, length = 98)
    aquarium3.printSize()
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()

    //ejemplo 1
   /* val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volume = 70
    aquarium6.printSize()
    /*
    //ejemplo 2
    */
    val aquarium6 = ClassAquarium(numberOfFish = 29)
    aquarium6.printSize()
    println("Volume: ${aquarium6.width   *  aquarium6.length  *  aquarium6.height / 1000} litros.")
    */
    //ejepmplo 3
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()


    val myTowerTank = TowerTank(diameter = 25, height = 45)
    myTowerTank.printSize()


}


    fun makeFish(){
       val tiburoncin = Shark()
        val calamardo = Plancton()

        println("Mi Tiburoncin es ${tiburoncin.color}")
        tiburoncin.eat()

        println("Mi plancton llamado Calamardo es de color ${calamardo.color}")
        calamardo.eat()

    }


fun main(){

    buildAquarium()
    makeFish()

}
