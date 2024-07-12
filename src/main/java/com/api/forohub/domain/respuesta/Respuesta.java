package com.api.forohub.domain.respuesta;

import com.api.forohub.domain.topico.Topico;
import com.api.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String solucion;
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    public Respuesta(String mensaje, Topico topico, Usuario usuario) {
        this.solucion = mensaje;
        this.fechaCreacion = LocalDateTime.now();
        this.topico = topico;
        this.autor = usuario;
    }

    public void actualizarDatos(DatosActualizarRespuesta datos){
        if(datos.solucion() != null){
            this.solucion = datos.solucion();
            this.fechaCreacion = LocalDateTime.now();
        }
    }
    public Long getId() {
        return id;
    }

    public String getSolucion() {
        return solucion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Topico getTopico() {
        return topico;
    }

    public Usuario getAutor() {
        return autor;
    }
}
