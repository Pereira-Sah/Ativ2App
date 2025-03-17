package br.edu.fatecpg.livros.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.livros.R
import br.edu.fatecpg.livros.model.Book

class BookAdapter(private val books:List<Book>): RecyclerView.Adapter<BookAdapter.ViewHolder>() {
        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val txv_titulo = itemView.findViewById<TextView>(R.id.txv_titulo)
            val txv_autor = itemView.findViewById<TextView>(R.id.txv_autor)
        }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_book_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookAdapter.ViewHolder, position: Int) {
        val book = books[position]
        holder.txv_titulo.text = book.titulo
        holder.txv_autor.text = book.autor
    }
}
