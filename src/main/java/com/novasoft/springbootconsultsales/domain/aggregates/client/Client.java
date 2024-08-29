package com.novasoft.springbootconsultsales.domain.aggregates.client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @Column(name = "idcliente")
    private String id;
    @Column(name = "cliente")
    private String fullName;
    @Column(name = "ncomercial")
    private String businessName;
    private String ruc;
    private String dni;
    @Column(name = "contacto")
    private String contact;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "correo")
    private String email;
    @Column(name = "direccion")
    private String address;
    @Column(name = "fecha")
    private Date date;

    public Client(String id, String fullName, String ruc, String dni, String contact, String phone, String email) {
        this.id = id;
        this.fullName = fullName;
        this.ruc = ruc;
        this.dni = dni;
        this.contact = contact;
        this.phone = phone;
        this.email = email;
    }

}
