package libroClass

 open class libroClasE (val titulo: String, val autor: String, val year: Int){

    //Primer metodo FUNCION, libro y autor como PAIR
    fun getTituloyAutor(): Pair<String, String> {
        return Pair(titulo, autor)
    }
//Segundo Metodo, titulo, autor y anio como TRIPLE

    fun getTodoDatodelLIBRO(): Triple<String, String, Int> {
        return Triple(titulo, autor, year)
    }
}