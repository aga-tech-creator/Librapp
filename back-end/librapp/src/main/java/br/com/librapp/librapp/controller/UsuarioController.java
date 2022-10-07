package br.com.librapp.librapp.controller;

import br.com.librapp.librapp.model.Usuario;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import br.com.librapp.librapp.service.UsuarioService;

@Controller
@RequestMapping("api/usuario")
public class UsuarioController {
    private static UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
    // Optional<Usuario> usuarioOp = usuarioService.findOne(id);

    // if(usuarioOp.isPresent())
    // return ResponseEntity.ok().body(usuarioOp.get());
    // else
    // return ResponseEntity.notFound().build();
    // }

    @PostMapping("/")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        if (usuario.getId() == 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid path id = null");

        usuario = usuarioService.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }
}
