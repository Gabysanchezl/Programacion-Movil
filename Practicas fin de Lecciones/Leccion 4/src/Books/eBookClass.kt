package Books

// Subclase eBookClass hereda de BookClass la funcion de readPage ahora llamada wordCount y override o sobreescribre la funcion readPage por wordCount

class eBookClass( title: String, author: String, val format: String= "text"): BookClass(title, author) {

    private var wordCount = 0

    override fun readPage() {
        wordCount += 250
    }
}

