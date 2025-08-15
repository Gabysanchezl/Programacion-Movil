package SpicesAbstract

 /*

fun main() {
    val curcuma = Spice3AbstractClass.Curcuma("hot")
    curcuma.prepararSpice()
}
*/
/*

fun main() {
    val curry = Spice3AbstractClass.Curry("hot")
    println("The curry spice is ${curry.color} in color.")

    curry.prepararSpice()


}
*/

fun main() {
    val container1 = SpiceContainer(Especiasencilla("Curry", "hot"))
    val container2 = SpiceContainer(Especiasencilla("Pepper", "medium"))
    val container3 = SpiceContainer(Especiasencilla("Paprika", "mild"))

    val containers = listOf(container1, container2, container3)

    for (container in containers) {
        println("Sticker: Esta especia se llama ${container.label} ")
    }


}


///Delegation

