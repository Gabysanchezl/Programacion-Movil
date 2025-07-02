import javax.swing.Spring
import javax.swing.Spring.height
import kotlin.times
import java.lang.Math
import kotlin.math.PI


// SubClasses y Herencia

//Clases deben marcarse como OPEN para ser Subclasses

//Sus variables y metodos deben ser OPEN tambien para poder Override on them

open class Aquarium (open var width:Int = 20, open var height:Int =40, open var length:Int=100){
    init{
        println("Aquarium initializing...")
    }
    open var volume: Int
        get() = width * height * length / 1000                  // 1000 cm^3 = 1 liter
        set(value) {
            height = (value * 1000) / (width * length)
        }



    //  Add an open shape property with the value "rectangle".
    open var shape = "rectangle"
    open var water: Double = 0.0
        get()= volume * 0.9


    fun printSize(){
        println("The width of our Aquarium is $width cm, The height is ${height} cm and the length is $length cm.")
        println("Volume: $volume liters. | Water: $water liters (${water/volume*100.0}%full)")

        println(shape)

    }





}


    //subclasses can be Added in the same file as the Main Class FATHER
    class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
        override open var volume: Int
            //override to  calcular un cilindro instead (elipse area = π * r1 * r2
            get() = (width/2 * length/2 * height / 1000 * PI).toInt()                 // 1000 cm^3 = 1 liter
            set(value) {
                height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
            }
       override open var water = volume * 0.8          //("ahora sera el 80%")
        override  open var shape = "cylinder"


    }
