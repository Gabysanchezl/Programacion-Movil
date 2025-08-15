package GameClasses

enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf(Directions.START)

    val north: () -> Boolean = {
        path.add(Directions.NORTH)
        true
    }

    val south: () -> Boolean = {
        path.add(Directions.SOUTH)
        true
    }

    val east: () -> Boolean = {
        path.add(Directions.EAST)
        true
    }

    val west: () -> Boolean = {
        path.add(Directions.WEST)
        true
    }

    val end: () -> Boolean = {
        path.add(Directions.END)
        println("Game Over: $path")
        path.clear()
        false
    }

    fun move(where: () -> Boolean) {
        where()
    }

    fun makeMove(input: String?) {
        when (input?.lowercase()) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }
}
