package com.cibertec.apibarbaroja.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clientes")
public class ClienteEntity extends BaseEntity{

    @Column(name = "NombreCliente")
    private String nombreCliente;

    @Column(name = "ApellidoCliente")
    private String apellidoCliente;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Pass")
    private String pass;

    @Column(name = "Telefono")
    private String telefono;
}