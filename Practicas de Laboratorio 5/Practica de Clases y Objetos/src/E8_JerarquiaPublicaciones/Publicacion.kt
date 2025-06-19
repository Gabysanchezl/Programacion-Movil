// Ejercicio 8: Jerarquía de Publicaciones

package E8_JerarquiaPublicaciones

open class Publicacion (val titulo: String, val autor: String){

}

class Libro(titulo: String, autor: String, val numeroPaginas: Int) : Publicacion(titulo, autor){

}
class ArticuloDeRevista(titulo: String, autor: String, val nombreRevista: String) : Publicacion(titulo, autor){

}

fun main(){

    val libroZafon = Libro("La Sombra del Viento", "Carlos Ruiz Zafon", 542)
    val revista = ArticuloDeRevista("El autor que hizo revivir los libros olvidados","Benito Juarez", "El Redactor")

    println("Libro: ${libroZafon.titulo} | Escritor ${libroZafon.autor} | Numero de Paginas: ${libroZafon.numeroPaginas}.")
    println()
    println("La Revista ${revista.nombreRevista}, publicó un articulo sobre el fallecido escritor ${libroZafon.autor}. \n El artículo fue escrito por el reconocido critico ${revista.autor}. \n Su articulo titulado \"${revista.titulo}\" dice asi...")

}