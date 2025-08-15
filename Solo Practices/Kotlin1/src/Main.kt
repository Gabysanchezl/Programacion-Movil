
    fun main() {
        val quizAnswer1 = 15
        var quizAnswer2 = 3
        val quizAnswer3 = "isosceles"
        val quizAnswer4 = 47

        // Write your code below
        println("Que es 75 / 5?")
        var studentAnswer1  = Integer.valueOf(readLine())
        println("Encuentra el valor de y en la ecuacion 6 * 2y = 36")
        var studentAnswer2  = Integer.valueOf(readLine())
        println("Cual es el nombre del triangulo que tiene dos lados iguales?")
        var studentAnswer3 = readLine()
        println("Encuentra la solucion de 8 * 6 - (3 - 2)")
        var studentAnswer4 = Integer.valueOf(readLine())


        var points = 0
        if (studentAnswer1 == quizAnswer1) {
            points +=25
        }
        if (studentAnswer2 == quizAnswer2) {
            points +=25
        } else if ((studentAnswer2 == quizAnswer2 + 1) || (studentAnswer2 == quizAnswer2 -1)){
            points += 20
            println("La respuesta $studentAnswer2 esta a 1 punto de distancia de tu intento.")
        } else {
            points += 1
        }

        if (studentAnswer3 == quizAnswer3){
            points += 25
        } else if (studentAnswer3 == "equilatero"){
            points += 10
        } else {
            points += 1
        }

        if (studentAnswer4 == quizAnswer4){
            points += 25
        } else if (studentAnswer4 >= 44 && studentAnswer4 <=54){
            points += 20
        } else {
            points += 1
        }

//Returning a Final Grade

        when (points){
            in 0..59 -> println("Te quemaste, sacaste F")
            in 60..69 -> println("Debes seguir mejorando, tienes una D")
            in 70..79 -> println("Vas bien pero podrias estar mejor, tienes una C")
            in 80..89 -> println("Sigue trabajando, vas por buen camino, tienes una B")
            in 90..100 -> println("Excelente, recibiste una A")
            in 101..110 -> println("Eres todo un genio, aqui esta tu A+")
        }




    }