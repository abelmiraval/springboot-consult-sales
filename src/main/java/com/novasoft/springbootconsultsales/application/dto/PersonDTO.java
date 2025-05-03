package com.novasoft.springbootconsultsales.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {

    private String documentNumber;
    private String fullName;
    private String names;
    private String paternalSurname;
    private String maternalSurname;
    private int verificationCode;
    private String ubigeoSunat;
    private List<String> ubigeo;
    private String address;
}
