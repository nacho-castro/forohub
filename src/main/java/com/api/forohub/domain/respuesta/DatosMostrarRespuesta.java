package com.api.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosMostrarRespuesta(
        Long id,
        String autor,
        String tituloTopico,
        LocalDateTime fechaCreacion,
        String solucion
) {
    public DatosMostrarRespuesta(Respuesta respuesta){
        this(respuesta.getId(),
                respuesta.getAutor().getNombre(),
                respuesta.getTopico().getTitulo(),
                respuesta.getFechaCreacion(),
                respuesta.getSolucion());
    }
}
