package example.myapp

    fun buildAquarium(){
        val myAquarium = ClassAquarium()
        myAquarium.printSize()
        myAquarium.height = 60
        myAquarium.printSize()

        //Nuevos Aquariums
        val aquarium1 = ClassAquarium()
        aquarium1.printSize()
        val aquarium2 = ClassAquarium(height = 49)
        aquarium2.printSize()
        val aquarium3 = ClassAquarium(width = 54, length = 98)
        aquarium3.printSize()
        val aquarium4 = ClassAquarium(width = 25, height = 35, length = 110)
        aquarium4.printSize()

        val aquarium6 = ClassAquarium(numberOfFish = 29)
        aquarium6.printSize()
        aquarium6.volume = 70
        aquarium6.printSize()
        /*
        val aquarium6 = ClassAquarium(numberOfFish = 29)
        aquarium6.printSize()
        println("Volume: ${aquarium6.width   *  aquarium6.length  *  aquarium6.height / 1000} litros.")
        */


    }



fun main(){

    buildAquarium()


}
