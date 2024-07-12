package com.api.forohub.domain.respuesta;

import com.api.forohub.domain.topico.DatosDetalleTopico;
import com.api.forohub.domain.topico.Topico;
import com.api.forohub.domain.topico.TopicoRepository;
import com.api.forohub.domain.usuario.Usuario;
import com.api.forohub.domain.usuario.UsuarioRepository;
import com.api.forohub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    RespuestaRepository respuestaRepository;

    public DatosMostrarRespuesta registrarRespuesta(DatosRegistroRespuesta datos){
        if(!usuarioRepository.existsById(datos.idUsuario())){
            throw new ValidacionDeIntegridad("Id de usuario no encontrado");
        }

        if(!topicoRepository.existsById(datos.idTopico())){
            throw new ValidacionDeIntegridad("Id de topico no encontrado");
        }

        Usuario usuario = usuarioRepository.getReferenceById(datos.idUsuario());
        Topico topico = topicoRepository.getReferenceById(datos.idTopico());

        Respuesta respuestaNueva = new Respuesta(datos.solucion(),topico,usuario);
        respuestaRepository.save(respuestaNueva);

        return new DatosMostrarRespuesta(respuestaNueva);
    }
}
