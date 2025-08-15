import kotlin.random.Random

fun main() {
    val book = Book("Harry Potter", " J. K. Rowling", 1990, 100)
    val puppy = Puppy()

    while (book.pages > 0) {
        println("El perrito está jugando con el libro...")
        puppy.playWithBook(book)
        println("📖 Quedan ${book.pages} páginas.")
    }

    println("  El libro ya no tiene páginas.")
}


class Book(val title: String, val author: String, val year: Int, var pages: Int)                    //// Clase Book con propiedad mutable 'pages'

fun Book.weight(): Double {                                                                     //// EXTENSION FUNCTION para calcular el peso del libro
    return this.pages * 1.5
}


fun Book.tornPages(paginasArrancadas: Int) {                                                      //// EXTENSION FUNCTION para simular que se arrancan páginas

    pages = if (pages - paginasArrancadas >= 0) pages - paginasArrancadas else 0
}


// Clase Puppy con metodo que arranca páginas random
class Puppy {
    fun playWithBook(book: Book) {
        val paginasPerdidas = Random.nextInt(1, 20)  // Arranca entre 1 y 19 páginas
        println("🦴 El perrito arrancó $paginasPerdidas páginas!")
        book.tornPages(paginasPerdidas)
    }
}
