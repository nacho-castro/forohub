package com.api.forohub.domain.topico.validaciones;

import com.api.forohub.domain.topico.DatosRegistrarTopico;
import com.api.forohub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoDuplicado implements ValidadorTopico{

    @Autowired
    TopicoRepository topicoRepository;

    @Override
    public void validar(DatosRegistrarTopico datos) {
        var tituloExiste = topicoRepository.existsByTitulo(datos.titulo());
        var mensajeExiste = topicoRepository.existsByMensaje(datos.mensaje());

        if(tituloExiste && mensajeExiste){
            throw new ValidationException("El topico esta duplicado. Ingrese topico diferente.");
        }
    }
}
