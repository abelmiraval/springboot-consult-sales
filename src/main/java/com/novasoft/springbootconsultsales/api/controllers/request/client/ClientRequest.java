package com.novasoft.springbootconsultsales.api.controllers.request.client;


import com.novasoft.springbootconsultsales.application.util.MessageValidator;
import com.novasoft.springbootconsultsales.infrastructure.validator.obligatory.ObligatoryLong;
import com.novasoft.springbootconsultsales.infrastructure.validator.obligatory.ObligatoryString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    @ObligatoryLong(message = MessageValidator.NOT_EMPTY)
    private Long numberDocument;
    @ObligatoryString(message = MessageValidator.NOT_EMPTY)
    private String firstName;
    @ObligatoryString(message = MessageValidator.NOT_EMPTY)
    private String lastName;
    private String contact;
    private String phone;
    private String email;

}
