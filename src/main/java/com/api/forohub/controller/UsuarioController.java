package com.api.forohub.controller;

import com.api.forohub.domain.usuario.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistrarUsuario datos){
        String encodedPassword = passwordEncoder.encode(datos.password());
        var usuarioNuevo = new Usuario(datos.nombre(),datos.email(),encodedPassword);
        usuarioRepository.save(usuarioNuevo);

        var response = new DatosRespuestaUsuario(usuarioNuevo);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaUsuario>> listadoUsuarios(@PageableDefault(size = 4) Pageable paginacion) {
        return ResponseEntity.ok(usuarioRepository.findAll(paginacion).map(DatosRespuestaUsuario::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaUsuario> buscarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);

        var response = new DatosRespuestaUsuario(usuario);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaUsuario> actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario actualizarUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(actualizarUsuario.id());

        String encodedPassword = null;
        if(actualizarUsuario.password() != null){
            encodedPassword = passwordEncoder.encode(actualizarUsuario.password());
        }
        usuario.actualizarDatos(actualizarUsuario.nombre(), encodedPassword);

        var response = new DatosRespuestaUsuario(usuario);
        return ResponseEntity.ok(response);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
