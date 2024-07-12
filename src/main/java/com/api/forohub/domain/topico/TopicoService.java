package com.api.forohub.domain.topico;

import com.api.forohub.domain.topico.validaciones.ValidadorTopico;
import com.api.forohub.domain.usuario.Usuario;
import com.api.forohub.domain.usuario.UsuarioRepository;
import com.api.forohub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    List<ValidadorTopico> validadores;

    public DatosDetalleTopico registrarTopico(DatosRegistrarTopico datos){
        if(!usuarioRepository.existsById(datos.idUsuario())){
            throw new ValidacionDeIntegridad("Id de usuario no encontrado");
        }

        //Validaciones
        validadores.forEach(v->v.validar(datos));

        Usuario usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        var topicoNuevo = new Topico(datos.titulo(), datos.mensaje(),usuario, datos.curso());

        topicoRepository.save(topicoNuevo);

        return new DatosDetalleTopico(topicoNuevo);
    }
}
