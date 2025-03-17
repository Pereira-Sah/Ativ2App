package br.edu.fatecpg.imc_projeto

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ResultadoImc : AppCompatActivity(R.layout.activity_resultado_imc) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val Textoresultado = findViewById<TextView>(R.id.txv_resultadoIMC)
        val Textomensagem = findViewById<TextView>(R.id.txv_mensagem)

        val resultado = intent.getFloatExtra("resultado", 0.0f)
        val mensagem = intent.getStringExtra("mensagem")

        Textoresultado.text = " IMC: %.2f".format(resultado)
        Textomensagem.text = mensagem
    }
}