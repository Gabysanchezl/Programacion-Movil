package Ejercicio4

object Logger {

    private val listaLogs = mutableListOf<String>()

    fun log(mensaje: String) {
        listaLogs.add(mensaje)
        println("Log: $mensaje")

    }

    fun mostrarLogs(){
        println("----------- HISTORIAL DE LOGS -----------")
        for (mensaje in listaLogs){
            println(mensaje)
        }
    }
}



fun main(){

    Logger.log("EJecutando Programa...")
    Logger.log("Iniciando analisis...")
    Logger.log("Conectando a la red...")
    Logger.log("Conectando a la base de datos...")


    Logger.mostrarLogs()

}