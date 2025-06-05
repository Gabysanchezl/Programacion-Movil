package Books

open class BookClass
     (val title: String, val author: String) {
        private var currentPage: Int = 0

        open fun readPage() {
            currentPage++
        }
    }

