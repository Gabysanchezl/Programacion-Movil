import libroClass.libroClasE

fun main (){

    val libroqueLeo = libroClasE("Hunger Games", "Alguien Famoso", 1985)

    //solo puedo llamar una clase a la vez por que ambos valores titulo y autor estan nombrados igual
    /*  val (titulo, autor) = libroqueLeo.getTituloyAutor()
          println("El libro que estoy leyendo se llama $titulo del escritor $autor")*/

    val (titulo, autor, year) = libroqueLeo.getTodoDatodelLIBRO()
    println("Te lo recomiendo $titulo, lo escribio $autor en el $year")

}