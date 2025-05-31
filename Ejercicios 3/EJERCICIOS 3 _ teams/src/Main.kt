//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
        val biografiaa: String? = "Hola soy paris y vivo en la calle Francia, desayuno Croissants y amo los éclairs. Aurevoir"
        val biografiaPersonal = biografiaa?: "Bio: [User has no bio]"
    println(biografiaPersonal)

        //Exercise 2: Simple To-Do List ✅



}