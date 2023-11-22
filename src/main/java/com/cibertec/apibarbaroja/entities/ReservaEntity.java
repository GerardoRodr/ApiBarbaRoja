package com.cibertec.apibarbaroja.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reservas")
public class ReservaEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "IdServicio", referencedColumnName = "id")
    private ServicioEntity servicio;

    @Column(name = "FechaReserva")
    private LocalDateTime fechaReserva;

    @Column(name = "FechaDeCreacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "Estado", length = 20)
    private String estado = "PENDIENTE";
}
