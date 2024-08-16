package com.novasoft.springbootconsultsales.api.controllers.response.client;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientResponse {
    private String idcliente;
    private String text;
    private String cliente;
    private String ruc;
    private String dni;
    private String contacto;
    private String telefono;
    private String correo;

    public String getText() {
        return getCliente() + " - " + getRuc();
    }
}
