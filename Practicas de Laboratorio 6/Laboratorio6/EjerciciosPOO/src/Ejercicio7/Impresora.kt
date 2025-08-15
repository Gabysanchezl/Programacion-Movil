package Ejercicio7

    interface Impresora {
        fun imprimir(documento: String)
    }


    interface Escaner{
        fun escanear():String
    }

    class ImpresoraLaser : Impresora{
        override fun imprimir(documento: String) {
            println("Imprimiendo $documento con láser.")
        }
    }

    class EscanerDeCamaPlana: Escaner{
        override fun escanear(): String {
            val texto = "Documento escaneado."
            println(texto)
            return texto
        }
    }

class Multifuncional (val impresorita:Impresora, val miescaner: Escaner) : Impresora by impresorita, Escaner by miescaner
/*
Multifuncional puede usar imprimir() y escanear() como si los hubiera escrito, pero en verdad los ejecutan los objetos recibidos de "impresorita" y "miescaner".

 */

fun main() {
    val impresora = ImpresoraLaser()
    val escaner = EscanerDeCamaPlana()

    val multifuncional = Multifuncional(impresora, escaner)

    multifuncional.imprimir("Contrato de alquiler del Señor Jimenez")
    val resultadoEscaneo = multifuncional.escanear()

    println("Resultado del escaneo: $resultadoEscaneo")
}
