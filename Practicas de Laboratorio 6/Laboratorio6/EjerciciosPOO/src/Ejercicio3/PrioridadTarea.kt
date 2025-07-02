package Ejercicio3

enum class PrioridadTarea (val colorHex: String) {
    BAJA("#00FF00"), MEDIA("#15LK21"), ALTA("#35HF85")
}

fun obtenerColor (prioridad:PrioridadTarea): String {
    return prioridad.colorHex
}

fun main(){

    println(PrioridadTarea.BAJA.ordinal)
    println(PrioridadTarea.BAJA.name)
    println(PrioridadTarea.BAJA.colorHex)


    println(PrioridadTarea.MEDIA.ordinal)
    println(PrioridadTarea.MEDIA.name)
    println(PrioridadTarea.MEDIA.colorHex)

    println(PrioridadTarea.ALTA.ordinal)
    println(PrioridadTarea.ALTA.name)
    println(PrioridadTarea.ALTA.colorHex)



    //itera sobre todos los valores de `PrioridadTarea` usando `PrioridadTarea.values()
    println("${PrioridadTarea.values()}")

}

