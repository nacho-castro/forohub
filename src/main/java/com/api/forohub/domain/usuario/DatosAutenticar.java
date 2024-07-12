package com.api.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticar(
        @NotBlank
        String email,
        @NotBlank
        String password) {
}
