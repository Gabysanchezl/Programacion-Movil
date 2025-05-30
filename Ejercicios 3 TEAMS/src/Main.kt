import java.security.Principal

fun main() {

    //Exercise 1: Optional User Details
    val userName: String? = null
    val userEmail: String? = "pedrito@oi.com"
    val userBio: String? = null
    if (userName != null){
        println ("Name: $userName")
    } else println ("Name [Not Provided]")

    if (userEmail != null) {
        println ("Email: $userEmail")
    } else println ("Email [Not Provided]")


    if (userBio == null){
        println ("Bio: [User has no bio]")
    } else if (userBio?.isEmpty()== true) {
        println ("Bio: [User has no bio or it's empty]")
    } else {
        println ("Bio: $userBio")
    }
//usando elvis operator y safe operator
    val biografiaa: String? = null
    biografiaa?.takeIf {it.isNotEmpty()}
    ?.let { "Bio: $it"}
    ?: if (biografiaa == ""){
            "Bio: [User has no bio or it's empty]"
        } else {
            "Bio:[NO EXXISTE, NO HAY bio]"
        }

}
