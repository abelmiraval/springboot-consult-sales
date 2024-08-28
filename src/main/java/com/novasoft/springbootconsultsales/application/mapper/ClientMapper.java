package com.novasoft.springbootconsultsales.application.mapper;

import com.novasoft.springbootconsultsales.api.controllers.request.client.ClientRequest;
import com.novasoft.springbootconsultsales.api.controllers.response.client.ClientResponse;
import com.novasoft.springbootconsultsales.domain.aggregates.client.Client;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "text", ignore = true)
    ClientResponse clientToResponse(Client client);

    @Mapping(target = "text", ignore = true)
    List<ClientResponse> clientsToResponse(List<Client> clients);

    @Mapping(target = "fullName", ignore = true)
    Client requestToClient(ClientRequest client);


    @AfterMapping
    default void setFullName(ClientRequest clientRequest, @MappingTarget Client client) {
        client.setFullName(clientRequest.getFirstName().toUpperCase()  + " " + clientRequest.getLastName().toUpperCase());
    }

    @AfterMapping
    default void setRuc(ClientRequest clientRequest, @MappingTarget Client client) {
        client.setRuc(clientRequest.getNumberDocument().toString());
    }

    @AfterMapping
    default void setDni(ClientRequest clientRequest, @MappingTarget Client client) {
        client.setDni(clientRequest.getNumberDocument().toString());
    }

    @AfterMapping
    default void setBusinessName(ClientRequest clientRequest, @MappingTarget Client client) {
        client.setBusinessName(clientRequest.getFirstName().toUpperCase() + " " + clientRequest.getLastName().toUpperCase());
    }
}
