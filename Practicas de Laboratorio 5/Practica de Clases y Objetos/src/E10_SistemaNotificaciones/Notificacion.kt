package E10_SistemaNotificaciones


open class Notificacion {
    open fun enviar(){
        println("Enviado notificación genérica...")
    }
}
class NotificacionEmail(val destinatario: String, val asunto: String) : Notificacion(){
    override fun enviar(){
        println("Enviando correo electrónico a '$destinatario' con asunto: '$asunto'...")
    }
}

class NotificacionSMS(val numeroTelefono: String, val mensaje: String) : Notificacion() {
    override fun enviar() {
        println("Enviando mensaje de texto a '$numeroTelefono': '$mensaje'...")
    }
}
class NotificacionPush(val deviceId: String, val contenido: String) : Notificacion() {
    override fun enviar() {
        println("Enviando notificación push a '$deviceId' con contenido: '$contenido'...")
    }
}

fun main(){

    fun enviarTodas(notificaciones: List<Notificacion>) {
        for (n in notificaciones){
            n.enviar()
        }
    }
    //probar con un numero de notificaciones
    val email = NotificacionEmail("lgab.sanchez@gmail.com",  "Bienvenida!")
    val sms = NotificacionSMS("8295551234", "Tu código es 7890")
    val push = NotificacionPush("device-001", "Nuevo mensaje recibido")

    val listaNotificaciones = listOf<Notificacion>(email, sms, push)

    enviarTodas(listaNotificaciones)
}

