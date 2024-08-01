package com.novasoft.springbootconsultsales.application.queries.client;

import com.novasoft.springbootconsultsales.domain.aggregates.client.Client;
import com.novasoft.springbootconsultsales.domain.aggregates.client.IClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientQuery implements IClientQuery {

    private final IClientRepository clientRepository;

    public ClientQuery(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    public Optional<List<Client>> autocomplete(String search) {
        return clientRepository.autocomplete(search);
    }
}
