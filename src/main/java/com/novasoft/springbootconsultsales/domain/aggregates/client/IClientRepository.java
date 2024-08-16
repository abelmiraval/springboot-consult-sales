package com.novasoft.springbootconsultsales.domain.aggregates.client;

import com.novasoft.springbootconsultsales.infrastructure.repository.IBaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClientRepository extends IBaseRepository<Client, String> {


    @Query("SELECT new com.novasoft.springbootconsultsales.domain.aggregates.client.Client(c.idcliente,c.cliente, c.ruc,c.dni, c.contacto, c.telefono, c.correo) " +
            "FROM Client c " +
            "WHERE c.cliente LIKE %:search% " +
            "OR c.ruc LIKE %:search% " +
            "OR c.dni LIKE %:search%")
    Optional<List<Client>> autocomplete(@Param("search") String search, Pageable pageable);

    @Query("SELECT new com.novasoft.springbootconsultsales.domain.aggregates.client.Client(c.idcliente,c.cliente, c.ruc,c.dni, c.contacto, c.telefono, c.correo) " +
            "FROM Client c " +
            "WHERE c.cliente LIKE %:search% " +
            "OR c.ruc LIKE %:search% " +
            "OR c.dni LIKE %:search%")
    Optional<List<Client>> search(@Param("search") String search, Pageable pageable);
}
