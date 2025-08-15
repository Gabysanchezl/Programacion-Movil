//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //Exercise 1: Optional User Details
    println("Ejercicio #1--------------------")
    println("  ")
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

        val todoList: MutableList<String?> = mutableListOf()

        // Step 2: Add some tasks, including a null
    println("Ejercicio #2--------------------")
    println("  ")
    todoList.add("Buy groceries")
        todoList.add(null)
        todoList.add("Walk the dog")
        todoList.add("Finish Kotlin lab")

        println("To-Do List:")
        for (item in todoList) {
            println(item ?: "[No task description]")
        }

        val firstTask = todoList.firstOrNull()
            if (firstTask == null) {
                println("First task: [No task description]")
            } else {
                println("First task: ${firstTask ?: "[No task description]"}") // MANEJA NULLABLE
            }


    // Ejercicio 3  - ITEM PRICES
    println("Ejercicio #3--------------------")
    println("  ")

    val itemNames = arrayOf("Laptop", "Phone", "Headphones", "Mouse", "Charger")
     val itemPrices: Array<Double?> = arrayOf(999.99, 699.50, null, 25.99, 19.99)

        val index = 2
        if (index in itemNames.indices && index in itemPrices.indices) {
            val name = itemNames[index]
            val price = itemPrices[index]

            if (price != null) {
                println("Item: $name, Price: $$price")
            } else {
                println("Item: $name, Price: Not available")
            }
        } else {
            println("Invalid item index.")
        }

        /// Ejercicio 4 : Default Configuration Values ⚙️

    println("Ejercicio #4--------------------")
    println("  ")
        var settingColorTheme: String? = null
        var settingFontSize: Int? = 16


        val actualColorTheme = settingColorTheme ?: "Light"
        val actualFontSize = settingFontSize ?: 12

        println("Applying theme: $actualColorTheme, Font size: ${actualFontSize}pt.")



}