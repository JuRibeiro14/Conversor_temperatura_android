package br.edu.fatecpg.com.meuprojeto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.meuprojeto.dao.UsuarioDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class OhmActivity : AppCompatActivity(R.layout.activity_ohm) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val txtUsuario = findViewById<TextView>(R.id.txt_usuario1)
        val edtValor1 = findViewById<EditText>(R.id.edt_valor1)
        val edtValor2 = findViewById<EditText>(R.id.edt_valor2)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val fabSair = findViewById<FloatingActionButton>(R.id.fab_sair)
        val txtResultado = findViewById<TextView>(R.id.txt_resultado2)

        val usuarioSalvo = UsuarioDao.retornarUsuario()
        txtUsuario.text = "Bem-vindo, ${usuarioSalvo.nome}!"
        txtResultado.text = "Último resultado: ${usuarioSalvo.resultado}"

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

        fabSair.setOnClickListener {
            finish()
        }
    }
}