package example.myapp

class ClassAquarium (width:Int = 20, height:Int =40, length:Int=100){
        init{
        println("Aquarium initializing...")
        }
      /*  init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} liters")
         }*/

    constructor(numberOfFish: Int) : this() {                               // this implica que va a tomar en cuenta los valores
                                                                              // del constructor principal para realizar cualquier tarea
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }

    var volume: Int
        get() = width * height * length / 1000                  // 1000 cm^3 = 1 liter
        set(value) {
            height = (value * 1000) / (width * length)
        }

        var width: Int = width
        var height: Int = height
        var length: Int = length

    fun printSize(){
        println("The width of our Aquarium is $width cm, The height is $height cm and the length is $length cm.")
        println("Volume: $volume liters.")


    }


    }

