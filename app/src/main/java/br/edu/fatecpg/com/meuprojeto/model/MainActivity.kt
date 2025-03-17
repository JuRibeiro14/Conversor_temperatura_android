package br.edu.fatecpg.com.meuprojeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.com.meuprojeto.R
import br.edu.fatecpg.meuprojeto.dao.UsuarioDao
import br.edu.fatecpg.meuprojeto.model.Usuario

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val editTextNome = findViewById<EditText>(R.id.edt_nome)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)

        val usuarioSalvo = UsuarioDao.retornarUsuario()

        if (usuarioSalvo.nome.isEmpty()) {
            btnSalvar.setOnClickListener {
                val nome = editTextNome.text.toString()
                if (nome.isNotEmpty()) {
                    val usuario = Usuario(nome = nome)
                    UsuarioDao.definirUsuario(usuario)
                    println("Usuário salvo: ${usuario.nome}")
                } else {
                    editTextNome.error = "Nome não pode ser vazio"
                }
            }
        } else {
            editTextNome.setText(usuarioSalvo.nome)
            editTextNome.isEnabled = false
            btnSalvar.isEnabled = false
        }

        val btnTemperatura = findViewById<Button>(R.id.btn_temperatura)
        val btnOhm = findViewById<Button>(R.id.btn_calcular)

        btnTemperatura.setOnClickListener {
            val intent = Intent(this, ConversorActivity::class.java)
            startActivity(intent)
        }

        btnOhm.setOnClickListener {
            val intent = Intent(this, OhmActivity::class.java)
            startActivity(intent)
        }
    }
}
