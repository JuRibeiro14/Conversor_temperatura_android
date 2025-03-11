package br.edu.fatecpg.com.meuprojeto.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.com.meuprojeto.R

class OhmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ohm)

        val edtValor1 = findViewById<EditText>(R.id.edt_valor1)
        val edtValor2 = findViewById<EditText>(R.id.edt_valor2)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val btnVoltar = findViewById<Button>(R.id.fab_sair)
        val txtResultado = findViewById<TextView>(R.id.text_resultado2)

        btnCalcular.setOnClickListener {
            val valor1 = edtValor1.text.toString().toDoubleOrNull()
            val valor2 = edtValor2.text.toString().toDoubleOrNull()

            if (valor1 != null && valor2 != null) {
                val resultado = valor1 * valor2
                txtResultado.text = "Resultado: $resultado"
            } else {
                txtResultado.text = "Por favor, insira valores válidos!"
            }
        }

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}