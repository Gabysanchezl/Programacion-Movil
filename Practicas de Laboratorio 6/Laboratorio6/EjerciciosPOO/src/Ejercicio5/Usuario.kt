package Ejercicio5

class Usuario private constructor( val email: String) {

    companion object {

        fun crearDesdeEmail(email: String): Usuario?{
            if ("@" in email) {
                return Usuario(email)
            } else return null
        }
    }


}

fun main() {

    val usuariogerente = Usuario.crearDesdeEmail("mygerente@empresa.com")
    val myusuario = Usuario.crearDesdeEmail("gabysanchez.com")

    if (usuariogerente != null){
        println("Usuario ha sido creado con el email ${usuariogerente.email}")
    } else {
        println("El email es invalio, no se pudo crear el usuario")
    }


    if (myusuario != null){
        println("Usuario ha sido creado con el email ${myusuario.email}")
    } else {
        println("El email es invalio, no se pudo crear el usuario")
    }

}