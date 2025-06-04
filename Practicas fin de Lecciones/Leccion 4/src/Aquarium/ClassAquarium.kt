package Aquarium

class ClassAquarium {

    var largo = 100
    var ancho = 20
    var altura = 40

    var volumen: Int
        get() = largo * ancho * altura / 1000
        set(valornuevo) {
            altura = (valornuevo * 1000) / (largo * ancho)
        }
    var water: Double = volumen * 0.9

}