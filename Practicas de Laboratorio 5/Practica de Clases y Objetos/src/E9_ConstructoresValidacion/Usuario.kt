// Ejercicio 9: Constructores y Validación en Cadena

package E9_ConstructoresValidacion

open class Usuario (var username: String, var email: String){

    init{
        if(username.isEmpty()){
            throw IllegalArgumentException("El nombre de usuario no puede estar vacio")
        } else {
            println("El usuario $username ha sido creado correctamente con el correo $email")
        }
    }

    constructor(username: String) : this(username, "$username@empresa.com".also{
        if(!it.contains("@")){
            throw IllegalArgumentException("El correo electronico suministrado: $it no es valido")
        }
    })
}

fun main() {
    val usuario1 = Usuario("Gabysanchezl", "lgab.sanchez@gmail.com")
    val usuarip2 = Usuario("LauraGabs")
 }