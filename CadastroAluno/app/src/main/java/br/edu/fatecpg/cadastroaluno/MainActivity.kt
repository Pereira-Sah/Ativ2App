package br.edu.fatecpg.cadastroaluno

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val edtName = findViewById<EditText>(R.id.edt_name)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)

        btnCadastrar.setOnClickListener{
            val nome = edtName.text.toString()
            if(nome.length > 2){
                val intent = Intent(this, GerarCodigo::class.java)
                intent.putExtra("usuario_nome",
                        nome)
                startActivity(intent)
            }
        }
    }
}