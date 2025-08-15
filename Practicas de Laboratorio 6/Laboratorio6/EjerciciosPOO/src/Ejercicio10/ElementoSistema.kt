package Ejercicio10

sealed class ElementoSistema(open val nombre: String)

data class Archivo(
    override val nombre: String, val tamanoKB: Int) : ElementoSistema(nombre)

data class Directorio(
    override val nombre: String,
    val contenidos: MutableList<ElementoSistema> = mutableListOf()) : ElementoSistema(nombre)

object GestorArchivos {
    fun crearArchivo(nombre: String, tamanoKB: Int): Archivo {
        return Archivo(nombre, tamanoKB)
    }

    fun crearDirectorio(nombre: String): Directorio {
        return Directorio(nombre)
    }
}

// Función de extensión para calcular tamaño total
fun Directorio.calcularTamanoTotal(): Int {
    var total = 0
    for (elemento in contenidos) {
        total += when (elemento) {
            is Archivo -> elemento.tamanoKB
            is Directorio -> elemento.calcularTamanoTotal()
        }
    }
    return total
}

fun main() {
    val raiz = GestorArchivos.crearDirectorio("Raíz")

    val doc = GestorArchivos.crearDirectorio("Documentos")
    val img = GestorArchivos.crearDirectorio("Imágenes")

    val archivo1 = GestorArchivos.crearArchivo("CV.pdf", 200)
    val archivo2 = GestorArchivos.crearArchivo("Notas.txt", 30)
    val archivo3 = GestorArchivos.crearArchivo("foto1.jpg", 452)
    val archivo4 = GestorArchivos.crearArchivo("logo.png", 152)

    doc.contenidos.addAll(listOf(archivo1, archivo2))
    img.contenidos.addAll(listOf(archivo3, archivo4))

    raiz.contenidos.addAll(listOf(doc, img))

    println("Tamaño total del directorio '${raiz.nombre}': ${raiz.calcularTamanoTotal()} KB")
}
