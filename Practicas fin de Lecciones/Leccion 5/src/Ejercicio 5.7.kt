
const val MAX_LIBROS_PRESTADOS = 3                        // se define la constante que dice el para máximo de libros a prestar

fun main() {

        val libro = libraryBooks("CienAñosDeSoledad", 3)

        println("¿Puedo tomar más libros prestados? ${libro.canBorrow()}")
        libro.printUrl()

}



class libraryBooks (val title: String, val librosPrestados: Int) {

    fun canBorrow(): Boolean {
        return librosPrestados < MAX_LIBROS_PRESTADOS
    }

    fun printUrl() {
        println("URL del libro: ${BASE_URL}${title}.html")
    }

    companion object {
        const val BASE_URL = "https://library.gabybooks.com/"
    }
}

object constants {
    const val BASE_URL = "https://library.gabybooks.com/"
}