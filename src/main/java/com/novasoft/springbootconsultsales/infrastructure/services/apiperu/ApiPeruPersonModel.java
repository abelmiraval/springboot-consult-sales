package com.novasoft.springbootconsultsales.infrastructure.services.apiperu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiPeruPersonModel {
    private String numero;
    private String nombre_completo;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private int codigo_verificacion;
    private String ubigeo_sunat;
    private List<String> ubigeo;
    private String direccion;
}
