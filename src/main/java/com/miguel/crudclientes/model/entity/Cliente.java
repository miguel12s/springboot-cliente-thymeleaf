package com.miguel.crudclientes.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
}
