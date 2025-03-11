package br.edu.fatecpg.com.meuprojeto.model

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.com.meuprojeto.R
import br.edu.fatecpg.com.meuprojeto.view.OhmActivity
import br.edu.fatecpg.com.meuprojeto.view.ConversorActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnTemperatura = findViewById<Button>(R.id.btn_temperatura)
        val btnOhm = findViewById<Button>(R.id.btn_calcular)

        btnTemperatura.setOnClickListener {
            val intent = Intent(this, ConversorActivity::class.java)
            startActivity(intent)
        }

        btnOhm.setOnClickListener {
            val intent = Intent(this,OhmActivity::class.java)
            startActivity(intent)
        }
    }
}
