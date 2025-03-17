package br.edu.fatecpg.livros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.livros.DAO.BookDao
import br.edu.fatecpg.livros.model.Book
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val edtTitulo = findViewById<EditText>(R.id.edt_titulo)
        val edtAutor = findViewById<EditText>(R.id.edt_autor)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabLivros = findViewById<FloatingActionButton>(R.id.fab_livros)
        val dao = BookDao()

        btnCadastrar.setOnClickListener{
            val titulo = edtTitulo.text.toString()
            val autor = edtAutor.text.toString()
            val book = Book(titulo,autor)
            dao.addBook(book)

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Livro cadastrado  com sucesso")
            val dialog = builder.create()
            dialog.show()

            edtTitulo.text.clear()
            edtAutor.text.clear()
        }

        fabLivros.setOnClickListener{
            val intent = Intent(this, BookActivity::class.java)
            startActivity(intent)
        }
    }
}
