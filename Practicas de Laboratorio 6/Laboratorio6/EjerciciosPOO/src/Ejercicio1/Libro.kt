package Ejercicio1

data class Libro (val titulo: String, val autor: String, val isbn: String){

}

fun main(){
    val libroCiencias = Libro (" Los Atomos del Universo"," Newton Robinson"," AK-521565")
    val libroFisica = Libro (" Los Atomos del Universo"," Newton Robinson", " AK-521565")
    val libroEducacion = libroCiencias.copy(titulo =  " Masterclass de Ciencias")

    println("¿Son iguales los dos libros? ${libroCiencias == libroFisica}")
    println(libroFisica)
    println(libroEducacion)
}