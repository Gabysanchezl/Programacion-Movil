fun main() {
    //  Crear Set de libros - autor William Shakespeare
    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Othello")

    val library = mapOf("William Shakespeare" to allBooks)                                  //  Crear un Map que asocia el Set de libros con el autor


    val tieneHamlet = library.any { (_, libros) -> "Hamlet" in libros }                     // Any() revisa si algún libro es de "Hamlet" Y DEVUELVE UN VALOR BOOLEANO si hay o no hay un libro con este nombre
    println("¿Hay algún libro llamado 'Hamlet'? $tieneHamlet")


    val moreBooks = mutableMapOf<String, String>()                                      //  Creamos un MutableMap y agregamos un libro con su autor
    moreBooks["Don Quijote "] = " Miguel de Cervantes"

    val autor1984 = moreBooks.getOrPut(" 1984 ") { "George Orwell" }              //  getOrPut() verifica si un libro existe, y si no, lo agrega.

    println("El autor de '1984' es $autor1984")
    println("Libros en moreBooks: $moreBooks")                                       // Comprobamos si '1984' está en el mapa después del getOrPut
}
