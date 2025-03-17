package br.edu.fatecpg.imc_projeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val number_altura = findViewById<EditText>(R.id.number_altura)
        val number_peso = findViewById<EditText>(R.id.number_peso)
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        btn_calcular.setOnClickListener{
            val peso = number_peso.text.toString().toFloatOrNull()
            val altura = number_altura.text.toString().toFloatOrNull()

            if(peso != null && altura != null && altura > 0){
                val imc = IMC(peso, altura)
                val resultado = imc.calcular()
                val mensagem = imc.imc_classificacao(resultado)
                val intent = Intent(this, ResultadoImc::class.java)
                intent.putExtra("resultado", resultado)
                intent.putExtra("mensagem", mensagem)
                startActivity(intent)
            }else{
                val alertDialog = AlertDialog.Builder(this)
                    .setTitle("Erro")
                    .setMessage("Por favor, insira valores válidos para peso e altura.")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .create()
                alertDialog.show()

            }
        }
    }
}