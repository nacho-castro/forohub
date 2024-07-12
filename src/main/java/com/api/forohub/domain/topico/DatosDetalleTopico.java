package com.api.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosDetalleTopico(
        Long id,
        String usuario,
        String titulo,
        String mensaje,
        String curso
) {
    public DatosDetalleTopico(Topico topico){
        this(topico.getId(), topico.getUsuario().getNombre(), topico.getTitulo(), topico.getMensaje(), topico.getCurso());
    }
}
