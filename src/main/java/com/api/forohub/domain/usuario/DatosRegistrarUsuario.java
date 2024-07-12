package com.api.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarUsuario(
        @NotBlank
        String email,
        @NotBlank
        String nombre,
        @NotBlank
        String password
) {
}
