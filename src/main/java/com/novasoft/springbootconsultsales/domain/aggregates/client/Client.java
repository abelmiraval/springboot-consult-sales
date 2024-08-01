package com.novasoft.springbootconsultsales.domain.aggregates.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    private String idcliente;
    private String cliente;
    private String ruc;
    private String dni;
    private String contacto;
    private String telefono;
    private String correo;
}
