import java.security.Principal

fun main () {
    val Pecaitos = 60
    val Algas = 55
    if (Pecaitos > Algas) {
        println("Wow, cuantos peces man!")
    } else {
        println(" Pero, hay demasiadas plantas para tan chin peces")
    }
    val Vehiculos = 75
    if (Vehiculos in 1..50) {
        println(Vehiculos)
    }

    if (Pecaitos == 0) {
        println("Tanque Vacio")
    } else if (Pecaitos < 40) {
        println("Que jevi. Hay peces!")
    } else {
        println("Pero hay demasiados peces juntos, saca par")
    }

    when (Pecaitos) {
        0 -> println("Tanque Vacio")
        in 1..39 -> println("Hay peces!")
        else -> println("Hay demasiados peces para esa pecerita!")
    }


////Ejercicioos de TEAMS

    //Exercise 1: Simple Age Checker 👶👴
    var edadRobert = 24
    if (edadRobert < 18) {
        println("Es Menor de edad")
    } else {
        println("Es Mayor de edad")
    }

    //Exercise 2: Grade Evaluator 🎓

    val calificacion = 58
    if (calificacion in  90..100){
            println("Usted ha obtenido una A")
    }
    else if (calificacion in 80..89){
            println("Usted ha obtenido una B")
        }

    else if (calificacion in 70..79){
        println("Usted ha obtenido una C")
    }
    else if (calificacion in 60..69) {
        println("Usted ha obtenido una D")
    }
    else if (calificacion in 0..60) {
        println("Usted se quemó, tiene una F")
    }


//Exercise 3: Traffic Light Simulator 🚦
    var trafficLight: String = "Yellow"
    when (trafficLight){
        "Yellow" -> println ("Caution ")
        "Red" -> println ("Stop")
        "Green" -> println ("Go")
        else  -> println ("Go")

    }

    //Exercise 4: Even or Odd? 🤔
    val number: Int = 7
    if (number % 2 == 0) {
        println("Es un Numero Par")
    }else {
        println("Es un Numero ImpPar")
    }

    ///Exercise 5: Login Attempt 🔑
    val savedUsername: String = "Gabysanchezl"
    val savedPassword: String = "Unicda.1234"
    var enteredUsername: String = "PedroPascal"
    var enteredPassword: String = "Unicda.123445r"

    if (enteredUsername == savedUsername) {
        if (enteredPassword == savedPassword) {
            println("Login Succesful")
        } else {
            println("Incorrect Password")
        }
    }
    else {
        println("Incorrect Username")}

    /// Exercise 6: Temperature Guide 🌡️
    val temperature: Double = 6.5
    when (temperature) {
        in -1000000.9..0.0 -> println("Freezing! Wear very warm clothes.")
        in 1.0..10.0 -> println("Cold. Wear a warm jacket!.")
        in 11.0..20.0 -> println("Cool. A light jacket should be fine.")
        in 21.0..30.0 -> println("Warm. Enjoy the weather!")
        in 31.0..10000.0 -> println("Hot! Stay hydrated.")
        else -> println("Temperature out of typical range.")
    }
    ///Exercise 7: Nullable Name Greeting 👋
/*
    Declare a nullable String variable named userName.
    Assign a name to it (e.g., "Alice").
    Write an if statement to check if userName is not null.
    If it's not null, print "Hello, [userName]!".
    If it is null, print "Hello, Guest!".
    Now, set userName to null and observe the different output.
*/

    val userName: String?  = "DIOLI"
    //if userName
 
}