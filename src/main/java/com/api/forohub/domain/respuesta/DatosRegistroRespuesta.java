package com.api.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotNull
        Long idUsuario,
        @NotNull
        Long idTopico,
        @NotBlank
        String solucion
) {
}
