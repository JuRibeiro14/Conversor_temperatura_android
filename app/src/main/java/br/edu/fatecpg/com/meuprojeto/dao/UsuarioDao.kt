package br.edu.fatecpg.meuprojeto.dao

import br.edu.fatecpg.meuprojeto.model.Usuario

class UsuarioDao {
    companion object {
        private var usuario: Usuario = Usuario()
        fun definirUsuario(usuarioRecebido: Usuario) {
            Companion.usuario = usuarioRecebido
        }

        fun retornarUsuario(): Usuario {
            return Companion.usuario
        }
    }
}