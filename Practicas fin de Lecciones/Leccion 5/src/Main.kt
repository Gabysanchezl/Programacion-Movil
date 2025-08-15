import libroClass.libroClasE


fun main() {

    println("  ")
    //PAIRS & or TRIPLES
    val (ingrediente, platillo, efecto) = Triple("Cebolla Empanizada", "Aros de Cebolla", "saciedad")
    println("Con el ingrediente: $ingrediente, vamos a cocinar: $platillo")

    //👉 Convertir un Pair a un string:
    val triple = "Cebolla Empanizada" to "Aros de Cebolla"
    println(triple.toString() + " esto es un string")  // (fishnet, catching fish)

    //👉 Convertir un Pair a Lista:
    val lista = triple.toList()
    println(lista + " esto es una lista")  // (fishnet, catching fish)

}

