package com.novasoft.springbootconsultsales.application.queries.client;

import com.novasoft.springbootconsultsales.domain.aggregates.client.Client;

import java.util.List;
import java.util.Optional;

public interface IClientQuery {

    Optional<Client> findById(String id);

    Optional<List<Client>> autocomplete(String search);

    Optional<List<Client>> search(String search, int pageNumber, int pageSize);

    Boolean create(Client client);
}
