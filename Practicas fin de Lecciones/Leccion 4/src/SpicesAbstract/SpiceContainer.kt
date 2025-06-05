package SpicesAbstract



class Especiasencilla(val name: String, val spiciness: String = "mild")

data class SpiceContainer(val especiaas: Especiasencilla){
    val label: String
        get() = especiaas.name


}

