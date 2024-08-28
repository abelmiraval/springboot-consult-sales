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


    @Query("SELECT new com.novasoft.springbootconsultsales.domain.aggregates.client.Client(c.id, c.fullName, c.ruc, c.dni, c.contact, c.phone, c.email) " +
            "FROM Client c " +
            "WHERE c.fullName LIKE %:search% " +
            "OR c.ruc LIKE %:search% " +
            "OR c.dni LIKE %:search%")
    Optional<List<Client>> autocomplete(@Param("search") String search, Pageable pageable);

    @Query("SELECT new com.novasoft.springbootconsultsales.domain.aggregates.client.Client(c.id, c.fullName, c.ruc, c.dni, c.contact, c.phone, c.email) " +
            "FROM Client c " +
            "WHERE c.fullName LIKE %:search% " +
            "OR c.ruc LIKE %:search% " +
            "OR c.dni LIKE %:search%")
    Optional<List<Client>> search(@Param("search") String search, Pageable pageable);

    @Query("SELECT c FROM Client c WHERE c.ruc = :ruc OR c.dni = :dni")
    Optional<Client> findByRuc(@Param("ruc") String ruc, @Param("dni") String dni);

    @Query("SELECT MAX(CAST(c.id AS int)) FROM Client c")
    Integer getMaxIdClient();
}
