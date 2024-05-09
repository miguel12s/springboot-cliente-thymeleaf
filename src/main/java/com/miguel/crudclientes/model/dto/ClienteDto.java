package com.miguel.crudclientes.model.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data

public class ClienteDto implements Serializable {
    private Integer idCliente;
    private String nombre;
    private String apellido;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    private String telefono;
    private String correo;
}
