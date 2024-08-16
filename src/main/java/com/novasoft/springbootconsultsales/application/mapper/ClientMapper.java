package com.novasoft.springbootconsultsales.application.mapper;

import com.novasoft.springbootconsultsales.api.controllers.response.client.ClientResponse;
import com.novasoft.springbootconsultsales.domain.aggregates.client.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
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

}
