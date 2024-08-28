package com.novasoft.springbootconsultsales.api.controllers.response.client;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse{
    private String id;
    private String fullName;
    private String ruc;
    private String dni;
    private String text;
    private String contact;
    private String phone;
    private String email;

    public String getText(){
        return getFullName().concat(" - ").concat(getRuc());
    }
}
