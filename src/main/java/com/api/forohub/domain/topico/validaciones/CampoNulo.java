package com.api.forohub.domain.topico.validaciones;

import com.api.forohub.domain.topico.DatosRegistrarTopico;
import com.api.forohub.infra.errores.ValidacionDeIntegridad;
import org.springframework.stereotype.Component;

@Component
public class CampoNulo implements ValidadorTopico{
    @Override
    public void validar(DatosRegistrarTopico datos) {
        if(datos.idUsuario() == null){
            throw new ValidacionDeIntegridad("idUsuario no puede ser null");
        }
        if(datos.titulo() == null){
            throw new ValidacionDeIntegridad("Titulo no puede ser null");
        }
        if(datos.mensaje() == null){
            throw new ValidacionDeIntegridad("Mensaje no puede ser null");
        }
        if(datos.curso() == null){
            throw new ValidacionDeIntegridad("Curso no puede ser null");
        }
    }
}
