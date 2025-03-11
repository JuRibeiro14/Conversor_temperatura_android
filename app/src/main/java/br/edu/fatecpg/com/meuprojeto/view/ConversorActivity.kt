package br.edu.fatecpg.com.meuprojeto.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.com.meuprojeto.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ConversorActivity : AppCompatActivity(R.layout.activity_conversor) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtTemperatura = findViewById<EditText>(R.id.edt_temperatura)
        val btnConverter = findViewById<Button>(R.id.btn_converter)
        val txtResultado = findViewById<TextView>(R.id.text_resultado2)
        val btnVoltar = findViewById<FloatingActionButton>(R.id.fab_sair)

        btnConverter.setOnClickListener {
            val temperaturaCelsius = edtTemperatura.text.toString().toDoubleOrNull()

            if (temperaturaCelsius != null) {
                val temperaturaFahrenheit = celsiusToFahrenheit(temperaturaCelsius)
                txtResultado.text = "Resultado: $temperaturaFahrenheit °F"
            } else {
                txtResultado.text = "Por favor, insira um valor válido!"
            }
        }

        btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun celsiusToFahrenheit(celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }
}
