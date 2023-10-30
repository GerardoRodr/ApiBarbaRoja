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

    @JoinColumn(name = "IdCliente")
    private String idCliente;

    @JoinColumn(name = "IdServicio")
    private String idServicio;

    @Column(name = "FechaReserva")
    private LocalDateTime fechaReserva;

    @Column(name = "FechaDeCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "Estado", length = 20)
    private String estado = "PENDIENTE";
}
