package br.edu.fatecpg.livros.DAO

import br.edu.fatecpg.livros.model.Book

class BookDao {
    companion object {
        private val books = mutableListOf<Book>()
    }

    fun addBook(book:Book){
        books.add(book)
    }

    fun getBooks():List<Book>{
        return books
    }

}
