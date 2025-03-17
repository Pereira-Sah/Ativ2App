package br.edu.fatecpg.livros

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.livros.DAO.BookDao
import br.edu.fatecpg.livros.adapter.BookAdapter

class BookActivity : AppCompatActivity(R.layout.activity_book) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dao = BookDao()
        val books = dao.getBooks()
        Log.i("Books", books.toString())
        val rvBooks = findViewById<RecyclerView>(R.id.rv_books)
        rvBooks.layoutManager = LinearLayoutManager(this)
        rvBooks.adapter = BookAdapter(books)
    }
}
