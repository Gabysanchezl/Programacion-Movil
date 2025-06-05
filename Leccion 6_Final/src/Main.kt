import GameClasses.Game

fun main() {
    val game = Game()

    while (true) {
        print("Enter a direction (n/s/e/w): ")
        val input = readLine()
        game.makeMove(input)
    }
}