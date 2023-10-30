package com.cibertec.apibarbaroja.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="administradores")
public class AdministradorEntity extends BaseEntity{

    @Column(name = "NombreAdmin")
    private String nombreAdmin;

    @Column(name = "ApellidoAdmin")
    private String apellidoAdmin;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Pass")
    private String pass;

    @Column(name = "Telefono")
    private String telefono;
}