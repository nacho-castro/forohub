package com.api.forohub.controller;

import com.api.forohub.domain.usuario.DatosAutenticar;
import com.api.forohub.domain.usuario.Usuario;
import com.api.forohub.infra.security.TokenService;
import com.api.forohub.infra.security.TokenJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJWT> autenticar(@RequestBody @Valid DatosAutenticar datosUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosUsuario.email(), datosUsuario.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(JWTtoken));
    }
}
