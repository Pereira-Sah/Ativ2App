package br.edu.fatecpg.cadastroaluno

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import java.util.Random


class GerarCodigo : AppCompatActivity(R.layout.activity_gerar_codigo) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val txvName = findViewById<TextView>(R.id.txv_name)
        val btnCod = findViewById<Button>(R.id.btn_cod)
        val txvCod = findViewById<TextView>(R.id.txv_cod)
        val usuario_nome = intent.getStringExtra("usuario_nome")
        txvName.text = "Bem-Vindo, $usuario_nome"

        btnCod.setOnClickListener{
            val matricula = gerarCodigo()
            txvCod.text = "Matrícula: $matricula"
        }
    }

    fun gerarCodigo():String{
        val random = Random()
        val letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val numeros = "0123456789"
        val letrasA = (1..3)
            .map{letras[random.nextInt(letras.length)]}
            .joinToString("")
        val numerosA = (1..4)
            .map {numeros[random.nextInt(numeros.length)]}
            .joinToString("")

        return "$letrasA-$numerosA"
    }
}
