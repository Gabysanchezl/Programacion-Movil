

abstract class AquariumFish {
    abstract val color: String

}
//Creamos interfaces
interface FishAction  {
    fun eat()
}

interface FishColor {
    val color: String
}


// creacion de SubClases

class Shark : FishAction, FishColor {
    override val color= "grey"
    override fun eat (){
        println("Este shark little Fishes")
    }
}

class Plancton (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor


//SINGLETON CLASS * They make it possible for us to use the instance of this object only once, instead of having multiple instances of it or overriding it.
object  GoldColor: FishColor {
    override val color= "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}
