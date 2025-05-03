package com.novasoft.springbootconsultsales.application.mapper;

import com.novasoft.springbootconsultsales.application.dto.PersonDTO;
import com.novasoft.springbootconsultsales.infrastructure.services.apiperu.ApiPeruPersonModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    PersonDTO personModelToPersonDTO(ApiPeruPersonModel person);

}
