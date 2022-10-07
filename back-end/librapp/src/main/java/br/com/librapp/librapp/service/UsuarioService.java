package br.com.librapp.librapp.service;

import br.com.librapp.librapp.model.Usuario;
import br.com.librapp.librapp.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }
}
